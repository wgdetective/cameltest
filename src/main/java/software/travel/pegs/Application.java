package software.travel.pegs;

import org.apache.camel.spring.Main;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Vladimir Medunetski on 20.12.16.
 */
@Configuration
@ImportResource({"classpath:META-INF/spring/camel-context.xml"})
public class Application {

    public static void main(final String[] params) throws Exception {
        final Main main = new Main();
        main.run();
        System.out.println("Hello world!");
    }


}
