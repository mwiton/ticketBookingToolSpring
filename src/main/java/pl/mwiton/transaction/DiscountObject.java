package pl.mwiton.transaction;

import pl.mwiton.model.Ticket;

/**
 * Created by Mateusz Witoń on 01.03.2018.
 */
public interface DiscountObject {
    void useDiscount(Ticket ticket);
}
