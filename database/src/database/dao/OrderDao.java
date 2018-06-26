package database.dao;

import entities.Customer;
import entities.Order;
import entities.Order_;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class OrderDao {

    @PersistenceContext(unitName = "OrderUnit")
    private EntityManager manager;

    public int createOrder(Order order){
        manager.persist(order);
        return order.getId();
    }


    public List<Order> gerAllOrders(){
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);
        return manager.createQuery(query).getResultList();
    }
    public List<Order> getOrdersByAddress(String address){

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);
        query.where(cb.equal(order.get(Order_.address),address));
        return manager.createQuery(query).getResultList();
    }

    public List<Order> getOrdersByCustomer(Customer customer){
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);
        query.where(cb.equal(order.get(Order_.customerByCustomerId1),customer));
        return manager.createQuery(query).getResultList();
    }

    public List<Order> getOrdersByAddressOnDate(String address, Date dateDelivery){
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);
        query.where(cb.and(cb.equal(order.get(Order_.address),address),cb.equal(order.get(Order_.dateDelivery),dateDelivery)));
        return manager.createQuery(query).getResultList();
    }

    public Order getOrderById(int id){
        return manager.find(Order.class,id);
    }

    public void removeOrder(Order order){
        manager.remove(order);
    }
    public void updateOrder(Order order) {
        manager.merge(order);
    }
}
