package src.main.java.application;

import org.glassfish.jersey.server.ResourceConfig;
import src.main.java.rates.RatesEndPoint;

public class ReactiveJava9Application extends ResourceConfig {

    /**
     * Register JAX-RS application Component
     */
    public ReactiveJava9Application(){
        register(RatesEndPoint.class);
    }
}
