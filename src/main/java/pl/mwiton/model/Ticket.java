package pl.mwiton.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;
    @Column(name = "create_date")
    private String dateOfCreate;
    @Column(name = "name")
    private String name;
    @Column(name = "name")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "start_place_id")
    private Place startPlace;
    @ManyToOne
    @JoinColumn(name = "end_place_id")
    private Place endPlace;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Ticket() {
        setCreateDate(LocalDateTime.now());
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getCreateDate() {
        return LocalDateTime.parse(dateOfCreate, formatter);
    }

    private void setCreateDate(LocalDateTime dateOfCreate) {
        this.dateOfCreate = dateOfCreate.format(formatter);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return String.format("Ticket from %s to %s with price %.02f",
                startPlace.getName(), endPlace.getName(), price);
    }

    public long getId() {
        return id;
    }
}
