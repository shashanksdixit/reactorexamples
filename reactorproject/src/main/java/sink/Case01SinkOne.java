package sink;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Case01SinkOne {
    public static void main(String[] args) {
        Sinks.One<Object> one = Sinks.one();
        Mono<Object> mono = one.asMono();
        mono.subscribe(System.out::println);
        one.tryEmitValue("Single Value Sink");

        // what if another value is emitted

        one.emitValue("another value", (signalType, emitResult) -> {
            System.out.println("Signal Type :" + signalType);
            System.out.println("Emit Result : " + emitResult);
            return false; // return false on the error
        });
    }
}
