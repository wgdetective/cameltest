package software.travel.pegs.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;
import software.travel.pegs.processor.SampleProcessor;

/**
 * @author Vladimir Medunetski on 20.12.16.
 */
@Component
public class SampleHttpRouteBuilder extends SpringRouteBuilder {

    public void configure() throws Exception {
        from("file:src/data")
                .process(new SampleProcessor())
                .to("file:src/data2");
    }
}
