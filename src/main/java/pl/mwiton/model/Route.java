package pl.mwiton.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
@Entity
public class Route {
    @Id
    @GeneratedValue
    private int idNum;
    @ManyToOne
    @JoinColumn(name = "start_place_id")
    private Place startPlace;
    @ManyToOne
    @JoinColumn(name = "end_place_id")
    private Place endPlace;
    @Column(name = "length")
    private Float length;


    @Column(name = "time")
    private Integer time; //in minutes

    public Route(Place startPlace, Place endPlace) {
        this(startPlace, endPlace, 0, 0);
    }

    public Route(Place startPlace, Place endPlace, float length, int time) {
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.length = length;
        this.time = time;
    }

    public Route() { }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int id) {
        this.idNum = id;
    }

    public Place getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(Place start) {
        this.startPlace = start;
    }

    public Place getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(Place end) {
        this.endPlace = end;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

}
