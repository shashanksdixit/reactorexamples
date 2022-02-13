package fluxcreate;

import reactor.core.publisher.Flux;
import reactor.util.Logger;

import java.time.Duration;
import java.util.logging.Level;

public class Case02FluxMultipleSubscribers {
    public static void main(String[] args) throws Exception {
        Flux<Integer> intFlux = Flux.just(1, 2, 3, 4, 5, 6);

        intFlux
                .log()
                .map(i -> i * 10)
                .log()
                .delayElements(Duration.ofMillis(1))
                .log()
                .subscribe(i -> System.out.println("Subscriber 1 : " + i));

//        intFlux.subscribe(i -> System.out.println("Subscriber 2 : " + i));

//        intFlux.filter(i -> i % 2 == 0).log().subscribe(i -> System.out.println("Subscriber 3 : " + i));
        Thread.sleep(10000);
    }
}
