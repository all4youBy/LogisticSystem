package database.dao;

import entities.Account;
import entities.Customer;
import entities.Customer_;

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
public class CustomerDao {

    @PersistenceContext(unitName = "OrderUnit")
    private EntityManager em;

   public List<Customer> getAllCustomers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<Customer> customer = query.from(Customer.class);
        query.select(customer);

        return em.createQuery(query).getResultList();
    }

    public Customer getCustomerById(int id) {
        return em.find(Customer.class,id);
    }

    public int createCustomer(Customer customer){
       em.persist(customer);
       return customer.getId();
    }

    public Customer getCustomerByAccount(Account account){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<Customer> customer = query.from(Customer.class);
        query.where(cb.equal(customer.get(Customer_.accountByAccountAccountId),account));
        return em.createQuery(query).getResultList().get(0);
    }

    public void updateCustomer(Customer customer){
        em.merge(customer);
    }
}
