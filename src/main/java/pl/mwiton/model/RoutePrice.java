package pl.mwiton.model;

import javax.persistence.*;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
public class RoutePrice {
    @Id
    @GeneratedValue
    private int idNum;
    @ManyToOne
    @JoinColumn(name = "start_place_id")
    private Place startPlace;
    @ManyToOne
    @JoinColumn(name = "end_place_id")
    private Place endPlace;
    @Column (name = "price")
    private double price;

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public Place getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(Place startPlace) {
        this.startPlace = startPlace;
    }

    public Place getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(Place endPlace) {
        this.endPlace = endPlace;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
