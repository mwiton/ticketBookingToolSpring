package pl.mwiton.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "parts_of_line")
public class PartOfLine {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_part")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "bought_places")
    private int boughtPlaces;

    public PartOfLine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getStartDate() {
        return LocalDateTime.parse(startDate, formatter);
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate.format(formatter);
    }

    public int getBoughtPlaces() {
        return boughtPlaces;
    }

    public void setBoughtPlaces(int boughtPlaces) {
        this.boughtPlaces = boughtPlaces;
    }
}
