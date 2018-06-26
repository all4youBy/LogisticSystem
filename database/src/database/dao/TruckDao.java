package database.dao;

import entities.Truck;
import entities.Truck_;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class TruckDao {

    @PersistenceContext(unitName = "OrderUnit")
    private EntityManager manager;

    public int createTruck(Truck truck){
        manager.persist(truck);
        return truck.getId();
    }

    public void updateTruck(Truck truck){
        manager.merge(truck);
    }

    public Truck getTruckById(int truckId){
        return manager.find(Truck.class,truckId);
    }

    public List<Truck> getFreeTrucks(){
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Truck> query = cb.createQuery(Truck.class);
        Root<Truck> truck = query.from(Truck.class);
        query.where(cb.equal(truck.get(Truck_.onTheWay),"n"));
        return manager.createQuery(query).getResultList();

    }

    public List<Truck> getAllTrucks(){
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Truck> query = cb.createQuery(Truck.class);
        Root<Truck> truck = query.from(Truck.class);
        return manager.createQuery(query).getResultList();
    }

}
