package pl.mwiton.Ticket;

import pl.mwiton.model.Route;
import pl.mwiton.model.Ticket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Witoń on 21.02.2018.
 */
@Component
@TicketCreatorQualifier(type = TicketCreatorQualifier.TicketCreatorType.LENGTH)
public class TicketCreatorLength implements TicketCreator
{
    @Value("${priceForKm}")
    private double KM_PRICE;

    @Override
    public Ticket createTicket(Route route) {
        Ticket ticket = new Ticket(route);
        ticket.setPrice(route.getLength() * KM_PRICE);
        return ticket;
    }
}
