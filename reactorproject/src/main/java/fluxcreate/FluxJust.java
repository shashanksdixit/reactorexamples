package fluxcreate;

import reactor.core.publisher.Flux;

public class FluxJust {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        integerFlux.subscribe(System.out::println);
    }
}
