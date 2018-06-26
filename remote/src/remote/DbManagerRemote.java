package remote;


import entities.*;

import javax.ejb.Remote;

import java.sql.Date;
import java.util.List;

@Remote
public interface DbManagerRemote {

    List<Customer> getCustomers();
    List<Order> getOrdersByAddr(String address);
    List<Order> getOrdersByAddrOnDate(String address, Date dateDelivery);
    List<Truck> getFreeTrucks();
    List<Truck> getAllTrucks();
    List<Order> getAllOrders();
    List<Order> getCustomerOrders(Customer customer);
    Customer getCustomerById(int id);
    Customer getCustomerByAccount(String login, String password);
    Account getAccountByLoginAndPassword(String login, String password);
    Order getOrderById(int id);
    Truck getTruckById(int id);
    int createCustomer(String name, int accountId);
    int createAccount(String login,String password,Integer type);
    int createOrder(int cargoQuantity, Date dateOrder, Date dateDelivery, String address, int custId);
    int createTruck(int carryingCapacity, String name, String onTheWay, Stock stock);
    int createStock(int cargoQuantity, String address);
    int getStockCargoCapacity(int stockId);
    void updateTruck(int truckId);
    void updateCustomer(Customer customer);
    void completeOrder(int orderId);
    void removeOrder(int orderId);
    boolean setTruckToOrder(int orderId, int truckId, int capacity);
}