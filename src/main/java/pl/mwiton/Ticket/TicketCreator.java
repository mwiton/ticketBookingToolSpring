package pl.mwiton.Ticket;

import pl.mwiton.model.Route;
import pl.mwiton.model.Ticket;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
public interface TicketCreator {
    Ticket createTicket(Route route);
}
