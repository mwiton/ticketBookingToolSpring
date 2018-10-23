package pl.mwiton.transaction;

import pl.mwiton.model.Ticket;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Witoń on 01.03.2018.
 */
@Component
public class DateDiscount implements DiscountObject{
    private final double TWO_WEEK_DISCOUNT = 0.15;
    private final double ONE_WEEK_DISCOUNT = 0.1;


    @Override
    public void useDiscount(Ticket ticket) {
        /*double price = ticket.getPrice();
        double discount = 0;
        if(ticket.getCreateDate().plusWeeks(2).toLocalDate().compareTo(
                ticket.getRoute().getStartDate().toLocalDate()) <=0) {
            discount = TWO_WEEK_DISCOUNT;
        }
        else if(ticket.getCreateDate().plusWeeks(1).toLocalDate().compareTo(
                ticket.getRoute().getStartDate().toLocalDate()) <=0) {
            discount = ONE_WEEK_DISCOUNT;
        }
        ticket.setPrice(price - discount * price);*/
    }
}
