package database.dao;


import entities.Account;
import entities.Account_;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class AccountDao {

    @PersistenceContext(unitName = "OrderUnit")
    private EntityManager manager;


    public int createAccount(Account account){
        manager.persist(account);
        return account.getId();
    }

    public Account getAccountById(int id){
        return manager.find(Account.class,id);
    }

    public Account getAccountByLoginAndPassword(String login, String password){

            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery<Account> query = cb.createQuery(Account.class);
            Root<Account> account = query.from(Account.class);
            query.select(account);
            query.where(cb.and(cb.equal(account.get(Account_.login), login)), cb.equal(account.get(Account_.password), password));
            List<Account> accounts = manager.createQuery(query).getResultList();
            if(accounts.isEmpty())
                return null;

            return accounts.get(0);

    }
}
