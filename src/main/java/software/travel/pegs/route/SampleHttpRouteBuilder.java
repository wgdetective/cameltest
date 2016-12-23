package software.travel.pegs.route;

import org.apache.camel.Exchange;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Vladimir Medunetski on 20.12.16.
 */
@Component
public class SampleHttpRouteBuilder extends SpringRouteBuilder {
    public void configure() throws Exception {
        from("jetty:http://localhost:8080/test")
                .process(exchange -> {
                    final String iata = exchange.getIn().getHeader("iata", String.class);
                    exchange.getOut().setHeader(Exchange.HTTP_METHOD, "POST");
                    exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/json");
                    exchange.getOut().setBody("{\n" +
                            "  \"codes\": [\n" +
                            "    \"" + iata + "\"\n" +
                            "  ]\n" +
                            "}");
                })
                .to("jetty:http://bst-dev.software.travel/jrest/search/airportsByIATA",
                        "file:src/data2?fileName=test.json")
                .process(exchange -> {
                    exchange.getIn().setBody("Success1");
                    exchange.getOut().setBody("Success2");
                });
    }
}
