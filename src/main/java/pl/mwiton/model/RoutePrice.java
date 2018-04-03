package pl.mwiton.model;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
public class RoutePrice {
    private String start;
    private String end;
    private double price;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
