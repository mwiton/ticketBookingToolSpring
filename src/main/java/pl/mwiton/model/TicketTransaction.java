package pl.mwiton.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mateusz Witoń on 08.04.2018.
 */
public class TicketTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long id;
    @OneToMany
    @JoinColumn(name = "ticket_id", referencedColumnName="id_ticket")
    private List<Ticket> tickets;
    @Column(name = "price")
    private Integer valueOfTransaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Integer getValueOfTransaction() {
        return valueOfTransaction;
    }

    public void setValueOfTransaction(Integer valueOfTransaction) {
        this.valueOfTransaction = valueOfTransaction;
    }
}
