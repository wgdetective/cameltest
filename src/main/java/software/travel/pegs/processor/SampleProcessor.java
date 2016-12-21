package software.travel.pegs.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * @author Vladimir Medunetski on 20.12.16.
 */
@Component
public class SampleProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        final String message = exchange.getIn().getBody(String.class);
/*        File file = new File("test.txt");
        FileUtils.write(file, message);*/
        exchange.getIn().setBody("Incoming message - " + message);
        System.out.println("Message - " + message);
    }
}
