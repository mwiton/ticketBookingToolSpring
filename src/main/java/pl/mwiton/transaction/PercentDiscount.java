package pl.mwiton.transaction;

import pl.mwiton.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Witoń on 01.03.2018.
 */
@Component
@Primary
public class PercentDiscount implements DiscountObject{
    private int discountPercent = 25;

    PercentDiscount() {}
    PercentDiscount(int percent) {
        discountPercent = percent;
    }

    @Override
    public void useDiscount(Ticket ticket) {
        double price = ticket.getPrice();
        ticket.setPrice(price - price * (discountPercent / 100.0));
    }
}
