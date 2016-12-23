package software.travel.pegs.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by phenadone on 22.12.16.
 */
public class SampleHttpEndpointProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        final String message = exchange.getIn().getBody(String.class);
        exchange.getIn().setBody("Endpoint message - " + message);
        System.out.println("Endpoint message - " + message);
    }
}
