package sink;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

// Todo replay type. Also elaborate types more.
public class Case02SinkTypes {
    public static void main(String[] args) {
        System.out.println(" ---- Unicast - Only one subscriber ---");
        Sinks.Many<Object> sinkUnicast = Sinks.many().unicast().onBackpressureBuffer();
        Flux<Object> flux = sinkUnicast.asFlux();
        flux.subscribe(o -> System.out.println("Subscriber 1 - " + o));
        flux.subscribe(o -> System.out.println("Subscriber 2 - " + o),
                err -> System.out.println("Error - " + err.getMessage()));
        sinkUnicast.tryEmitNext("object 1");

        System.out.println(" ---- Multicast - More than one subscribers ---");
        Sinks.Many<Object> sinkMulticast = Sinks.many().multicast().onBackpressureBuffer();
        Flux<Object> multicastFlux = sinkMulticast.asFlux();
        multicastFlux.subscribe(o -> System.out.println("Subscriber 1 - " + o));
        multicastFlux.subscribe(o -> System.out.println("Subscriber 2 - " + o));
        sinkMulticast.tryEmitNext("object 1");

        System.out.println(" ---- Multicast - direct All or nothing ---");
        Sinks.Many<Object> direct = Sinks.many().multicast().directAllOrNothing();
        Flux<Object> directFlux = direct.asFlux();
        directFlux.subscribe(o -> System.out.println("Subscriber 1 - " + o));
        directFlux.subscribe(o -> System.out.println("Subscriber 2 - " + o));
        direct.tryEmitNext("object 1");
        direct.tryEmitNext("object 2");
        directFlux.subscribe(o -> System.out.println("Subscriber 3 - " + o));
        direct.tryEmitNext("object 3");

        //Todo Replay
    }
}
