package fluxcreate;

import reactor.core.publisher.Flux;

public class Case02FluxMultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> intFlux = Flux.just(1, 2, 3, 4, 5, 6);

        intFlux.subscribe(i -> System.out.println("Subscriber 1 : " + i));

        intFlux.subscribe(i -> System.out.println("Subscriber 2 : " + i));

        intFlux.filter(i -> i % 2 == 0).subscribe(i -> System.out.println("Subscriber 3 : " + i));

    }
}
