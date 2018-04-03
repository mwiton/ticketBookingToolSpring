package pl.mwiton.service;

import org.springframework.stereotype.Component;
import pl.mwiton.model.Ticket;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Witoń on 07.03.2018.
 */
@Component
public class TicketRepository implements GenericRepository<String, Ticket> {
    private List<Ticket> tickets;

    TicketRepository() {
        tickets = new ArrayList<>();
    }

    @Override
    public Ticket get(String id) {
        return tickets.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String add(Ticket object) {
        String id;
        if (object.getId().equals("")) {
            String timeStamp = Long.toString(object.getDateOfBuy().toEpochSecond(ZoneOffset.UTC));
            String lastId = tickets.stream().filter(t -> t.getId().contains(timeStamp)).
                    map(Ticket::getId).sorted((o1, o2) -> -(o2.compareTo(o1))).findFirst().orElse("");
            id = timeStamp + "-";
            if(!lastId.isEmpty()) {
                id = id + (Integer.valueOf(lastId.substring(lastId.indexOf("-")+1))+1);
            }
            else {
                id = id + 1;
            }
            object.setId(id);
        }
        else id = object.getId();
        tickets.add(object);
        return id;
    }
}
