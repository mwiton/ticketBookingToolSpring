package pl.mwiton.Ticket;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Mateusz Witoń on 01.03.2018.
 */
@Target({ElementType.FIELD,
    ElementType.METHOD,
    ElementType.TYPE,
    ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TicketCreatorQualifier {
    enum TicketCreatorType {
        JSON, LENGTH
    }

    TicketCreatorType type();
}
