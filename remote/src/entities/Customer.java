package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable{

    private int id;
    private String name;
    private Account accountByAccountAccountId;

    public Customer(){}

    public Customer(String name,Account account){
        this.name = name;
        this.accountByAccountAccountId = account;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_account_id", referencedColumnName = "id")
    public Account getAccountByAccountAccountId() {
        return accountByAccountAccountId;
    }

    public void setAccountByAccountAccountId(Account accountByAccountAccountId) {
        this.accountByAccountAccountId = accountByAccountAccountId;
    }
}
