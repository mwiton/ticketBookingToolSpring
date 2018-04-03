package pl.mwiton.model;

import java.time.LocalDateTime;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
public class Ticket {
    private Route route;
    private double price;
    private LocalDateTime dateOfBuy;
    private String id;

    public Ticket(Route route) {
        this.route = route;
        dateOfBuy = LocalDateTime.now();
        id = "";
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(LocalDateTime dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    @Override
    public String toString() {
        return String.format("Ticket from %s to %s with price %.02f",
                route.getStartPlace(), route.getEndPlace(), price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
