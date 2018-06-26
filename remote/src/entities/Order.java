package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "\"order\"")
public class Order implements Serializable{
    private int id;
    private int cargoQuantity;
    private Date dateOrder;
    private Date dateDelivery;
    private String address;
    private Truck truckByTruckId1;
    private Customer customerByCustomerId1;
    private String orderState;

    public Order(){}

    public Order(int cargoQuantity,Date dateOrder,Date dateDelivery,String address,Truck truck,Customer customer) {
        this(cargoQuantity,dateOrder,dateDelivery,address,customer);
        this.truckByTruckId1= truck;
    }

    public Order(int cargoQuantity,Date dateOrder,Date dateDelivery,String address,Customer customer){
        this.cargoQuantity = cargoQuantity;
        this.dateOrder = dateOrder;
        this.dateDelivery = dateDelivery;
        this.address = address;
        this.customerByCustomerId1 = customer;
        this.orderState="Новый";
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
    @Column(name = "cargo_quantity")
    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    @Basic
    @Column(name = "date_order")
    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Basic
    @Column(name = "date_delivery")
    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    @Basic
    @Column(name = "state")
    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (cargoQuantity != order.cargoQuantity) return false;
        if (dateOrder != null ? !dateOrder.equals(order.dateOrder) : order.dateOrder != null) return false;
        if (dateDelivery != null ? !dateDelivery.equals(order.dateDelivery) : order.dateDelivery != null) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cargoQuantity;
        result = 31 * result + (dateOrder != null ? dateOrder.hashCode() : 0);
        result = 31 * result + (dateDelivery != null ? dateDelivery.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id1", referencedColumnName = "id")
    public Truck getTruckByTruckId1() {
        return truckByTruckId1;
    }

    public void setTruckByTruckId1(Truck truckByTruckId1) {
        this.truckByTruckId1 = truckByTruckId1;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id1", referencedColumnName = "id", nullable = false)
    public Customer getCustomerByCustomerId1() {
        return customerByCustomerId1;
    }

    public void setCustomerByCustomerId1(Customer customerByCustomerId1) {
        this.customerByCustomerId1 = customerByCustomerId1;
    }
}
