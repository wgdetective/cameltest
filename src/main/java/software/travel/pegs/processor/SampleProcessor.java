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
        System.out.println("Processor execute!");
    }
}
