package pl.mwiton.Ticket;

import pl.mwiton.model.Route;
import pl.mwiton.model.RoutePrice;
import pl.mwiton.model.Ticket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Witoń on 20.02.2018.
 */
@Component
@TicketCreatorQualifier(type = TicketCreatorQualifier.TicketCreatorType.JSON)
public class TicketCreatorJSON implements TicketCreator{
    private static List<RoutePrice> prices;
    public static final String DEFAULT_LIST = "relationPrices";
    public static final String DEFAULT_FILE = "routes.json";
    public static void loadJson(String source, String routesPacket) {
        prices = new ArrayList<>();
        try(Reader reader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(source))) {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(reader);
            JSONObject jsonObject = (JSONObject)object;
            jsonObject = (JSONObject)jsonObject.get("routesList");
            JSONArray array = (JSONArray)jsonObject.get("routes");
            array.stream().filter(list -> ((JSONObject)list).get("name").equals(routesPacket))
                .forEach(list -> addPrice((JSONArray)((JSONObject)list).get("route")));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public TicketCreatorJSON() {
        if(prices == null) {
            loadJson(DEFAULT_FILE, DEFAULT_LIST);
        }
    }

    private static void addPrice(JSONArray routes) {
        routes.forEach(obj -> {
            JSONObject route = (JSONObject)obj;
            RoutePrice routePrice = new RoutePrice();
            routePrice.setStart((String)(route.get("start")));
            routePrice.setEnd((String)(route.get("end")));
            Number priceNumber = (Number)route.get("price");
            routePrice.setPrice(priceNumber.doubleValue());
            prices.add(routePrice);
        });
    }

    public Ticket createTicket(Route route) {
        Ticket ticket = new Ticket(route);
        prices.stream().filter(price -> price.getStart().equals(route.getStartPlace()) &&
                price.getEnd().equals(route.getEndPlace())).forEach(price -> ticket.setPrice(price.getPrice()));
        return ticket;
    }
}
