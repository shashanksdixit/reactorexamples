package context;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;


//TODO - Need to work on
public class Case01Context {
    public static void main(String[] args) {
        Mono.just("Some Message")
                .contextWrite(Context.of("trace", "from microservice"));
    }
}
