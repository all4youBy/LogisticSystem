package database.dao;

import entities.Stock;
import entities.Stock_;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
@TransactionManagement(value =  TransactionManagementType.CONTAINER)
public class StockDao {

    @PersistenceContext(unitName = "OrderUnit")
    private EntityManager manager;

    public int createStock(Stock stock){
        manager.persist(stock);
        return stock.getId();
    }

    public Stock getStockById(int id){
        return manager.find(Stock.class,id);
    }

    public int getStockCargoCapacity(int stockId){

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
        Root<Stock> stock = query.from(Stock.class);
        query.select(stock.get(Stock_.cargoQuantity));
        query.where(cb.equal(stock.get(Stock_.id),stockId));
        return manager.createQuery(query).getSingleResult();
    }


}
