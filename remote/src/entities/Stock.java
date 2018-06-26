package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Stock implements Serializable{

    private int id;
    private int cargoQuantity;
    private String address;

    public Stock(){}

    public Stock(int cargoQuantity, String address){
        this.cargoQuantity = cargoQuantity;
        this.address = address;
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

        Stock stock = (Stock) o;

        if (id != stock.id) return false;
        if (cargoQuantity != stock.cargoQuantity) return false;
        if (address != null ? !address.equals(stock.address) : stock.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cargoQuantity;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
