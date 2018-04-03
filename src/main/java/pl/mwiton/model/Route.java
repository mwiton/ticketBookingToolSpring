package pl.mwiton.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
@Entity
public class Route {
    @Id
    @GeneratedValue
    private int idNum;

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int id) {
        this.idNum = id;
    }

    private String startPlace;
    private String endPlace;
    private float length;
    private LocalDateTime startDate;

    public Route(String startPlace, String endPlace) {
        this(startPlace, endPlace, 0, LocalDateTime.now());
    }

    public Route(String startPlace, String endPlace, float length, LocalDateTime startDate) {
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.length = length;
        this.startDate = startDate;
    }

    public Route() { }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String start) {
        this.startPlace = start;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String end) {
        this.endPlace = end;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
