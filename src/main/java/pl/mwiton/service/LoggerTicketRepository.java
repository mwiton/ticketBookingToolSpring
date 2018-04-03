package pl.mwiton.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.mwiton.model.Ticket;

import java.util.Arrays;

/**
 * Created by Mateusz Witoń on 21.03.2018.
 */
@Aspect
@Component
public class LoggerTicketRepository {
    @AfterReturning(pointcut = "execution(* pl.mwiton.service.TicketRepository.add(..)) && args(ticket)",
        returning  = "id")
    public void logAround(JoinPoint jp, Ticket ticket, String id) {
        System.out.format("Method %s executed with argument: [%s] and retured id %s\n", jp.getSignature(), ticket, id);
    }
}
