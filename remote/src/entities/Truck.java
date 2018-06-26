package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Truck implements Serializable {

    private int id;
    private int carryingCapacity;
    private Integer currentCapacity;
    private String name;
    private String onTheWay;
    private Stock stockByStockId;

    public Truck(){}

    public Truck(int carryingCapacity, String name, String onTheWay, Stock stock){
        this.carryingCapacity = carryingCapacity;
        this.name = name;
        this.onTheWay = onTheWay;
        this.stockByStockId = stock;
    }

    public Truck(int carryingCapacity, String name, String onTheWay, Stock stock,int currentCapacity) {
        this(carryingCapacity,name,onTheWay,stock);
        this.currentCapacity = currentCapacity;
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
    @Column(name = "current_capacity")
    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    @Basic
    @Column(name = "carrying_capacity")
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "on_the_way")
    public String getOnTheWay() {
        return onTheWay;
    }

    public void setOnTheWay(String onTheWay) {
        this.onTheWay = onTheWay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;

        if (id != truck.id) return false;
        if (carryingCapacity != truck.carryingCapacity) return false;
        if (name != null ? !name.equals(truck.name) : truck.name != null) return false;
        if (onTheWay != null ? !onTheWay.equals(truck.onTheWay) : truck.onTheWay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + carryingCapacity;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (onTheWay != null ? onTheWay.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    public Stock getStockByStockId() {
        return stockByStockId;
    }

    public void setStockByStockId(Stock stockByStockId) {
        this.stockByStockId = stockByStockId;
    }



}
