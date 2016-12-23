package software.travel.pegs.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;
import software.travel.pegs.processor.SampleHttpEndpointProcessor;
import software.travel.pegs.processor.SampleProcessor;

/**
 * @author Vladimir Medunetski on 20.12.16.
 */
@Component
public class SampleHttpRouteBuilder extends SpringRouteBuilder {

    public void configure() throws Exception {
        from("jetty:http://localhost:8080/test")
                .process(new SampleProcessor())
                .to("http:localhost:8080/endPoint?bridgeEndpoint=true");

        from("jetty:http://localhost:8080/endPoint")
                .process(new SampleHttpEndpointProcessor())
                .to("file:src/data2?fileName=test.txt");
    }
}
