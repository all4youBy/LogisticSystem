package database;

import database.dao.*;

import entities.*;

import remote.DbManagerRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.sql.Date;
import java.util.List;

@Stateless
public class DbManager implements DbManagerRemote {

    @EJB
    private CustomerDao customerDao;

    @EJB
    private AccountDao accountDao;

    @EJB
    private OrderDao orderDao;

    @EJB
    private TruckDao truckDao;

    @EJB
    private StockDao stockDao;


    @Override
    public List<Customer> getCustomers() {
       return customerDao.getAllCustomers();
    }

    @Override
    public List<Order> getOrdersByAddr(String address) {
        return orderDao.getOrdersByAddress(address);
    }

    @Override
    public List<Order> getOrdersByAddrOnDate(String address, Date dateDelivery) {
       return orderDao.getOrdersByAddressOnDate(address,dateDelivery);
    }

    @Override
    public List<Truck> getFreeTrucks() {
        return truckDao.getFreeTrucks();
    }

    @Override
    public List<Truck> getAllTrucks() {
        return truckDao.getAllTrucks();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByAccount(String login, String password) {
        Account account = accountDao.getAccountByLoginAndPassword(login, password);
        return customerDao.getCustomerByAccount(account);
    }

    @Override
    public Account getAccountByLoginAndPassword(String login, String password) {
        return accountDao.getAccountByLoginAndPassword(login, password);
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public Truck getTruckById(int id) {
        return truckDao.getTruckById(id);
    }

    @Override
    public int createCustomer(String name, int accountId) {
        Account account = accountDao.getAccountById(accountId);
        Customer customer = new Customer(name,account);
        return customerDao.createCustomer(customer);
    }

    @Override
    public int createAccount(String login, String password, Integer type) {
        Account account = new Account(login,password,type);
        return accountDao.createAccount(account);
    }

    @Override
    public int createOrder(int cargoQuantity, Date dateOrder, Date dateDelivery, String address, int custId) {
        Customer customer = customerDao.getCustomerById(custId);
        Order order = new Order(cargoQuantity,dateOrder,dateDelivery,address,customer);
        return orderDao.createOrder(order);
    }

    @Override
    public int createTruck(int carryingCapacity, String name, String onTheWay, Stock stock) {
        Truck truck = new Truck(carryingCapacity,name,onTheWay,stock);
        return truckDao.createTruck(truck);
    }

    @Override
    public int createStock(int cargoQuantity, String address) {
        Stock stock = new Stock(cargoQuantity,address);
        return stockDao.createStock(stock);
    }

    @Override
    public int getStockCargoCapacity(int stockId) {
        return stockDao.getStockCargoCapacity(stockId);
    }

    @Override
    public void updateTruck(int truckId) {
        Truck truck = truckDao.getTruckById(truckId);
        truckDao.updateTruck(truck);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void completeOrder(int orderId) {
        Order order = orderDao.getOrderById(orderId);
        order.setOrderState("Завершен");
        Truck truck = order.getTruckByTruckId1();
        truck.setCurrentCapacity(0);
        truck.setOnTheWay("n");
        truckDao.updateTruck(truck);
        order.setTruckByTruckId1(null);
        orderDao.updateOrder(order);
    }

    @Override
    public void removeOrder(int orderId) {
        Order order = orderDao.getOrderById(orderId);
        orderDao.removeOrder(order);
    }

    @Override
    public boolean setTruckToOrder(int orderId, int truckId,int capacity) {
        Order order = orderDao.getOrderById(orderId);
        Truck truck = truckDao.getTruckById(truckId);

        if(truck.getCurrentCapacity() + capacity <= truck.getCarryingCapacity()) {
            truck.setCurrentCapacity(capacity+truck.getCurrentCapacity());
            truckDao.updateTruck(truck);
            truck.setOnTheWay("y");
            order.setTruckByTruckId1(truck);
            order.setOrderState("Подтвержден");
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.gerAllOrders();
    }

    @Override
    public List<Order> getCustomerOrders(Customer customer) {
        return orderDao.getOrdersByCustomer(customer);
    }
}
