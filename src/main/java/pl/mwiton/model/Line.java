package pl.mwiton.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_line")
    private Long id;
    @OneToMany
    @JoinColumn(name = "line_id", referencedColumnName="id_line")
    private List<PartOfLine> parts;
    @Column(name = "available_places")
    private Integer availablePlaces;

    public Line() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PartOfLine> getParts() {
        return parts;
    }

    public void setParts(List<PartOfLine> parts) {
        this.parts = parts;
    }

    public Integer getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(Integer availablePlaces) {
        this.availablePlaces = availablePlaces;
    }
}
