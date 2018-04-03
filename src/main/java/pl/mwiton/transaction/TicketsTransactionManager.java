package pl.mwiton.transaction;

import pl.mwiton.Ticket.TicketCreator;
import pl.mwiton.Ticket.TicketCreatorQualifier;
import pl.mwiton.model.Route;
import pl.mwiton.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mwiton.service.GenericRepository;

/**
 * Created by Mateusz Witoń on 21.02.2018.
 */
@Component
public class TicketsTransactionManager {
    private TicketCreator ticketCreator;

    public GenericRepository<String, Ticket> getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(GenericRepository<String, Ticket> repository) {
        this.repository = repository;
    }

    private GenericRepository<String, Ticket> repository;
    private DiscountObject discountObject;

    @Autowired
    public TicketsTransactionManager(@TicketCreatorQualifier(
            type = TicketCreatorQualifier.TicketCreatorType.LENGTH) TicketCreator creator) {
        ticketCreator = creator;
    }

    public TicketCreator getTicketCreator() {
        return ticketCreator;
    }

    public void setTicketCreator(TicketCreator ticketCreator) {
        this.ticketCreator = ticketCreator;
    }

    public DiscountObject getDiscountObject() {
        return discountObject;
    }

    @Autowired (required = false)
    public void setDiscountObject(DiscountObject discountObject) {
        this.discountObject = discountObject;
    }

    public String makeTransaction(Route route, int number)
    {
        Ticket ticket = null;
        if(ticketCreator != null && number > 0)
        {
            ticket = ticketCreator.createTicket(route);
            ticket.setPrice(ticket.getPrice() * number);
            if(discountObject != null){
                discountObject.useDiscount(ticket);
            }
            if (getRepository() != null) repository.add(ticket);
        }
        return ticket != null ? ticket.getId() : "";
    }
}
