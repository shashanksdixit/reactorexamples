package fluxcreate;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Case01FluxJust {
    public static void main(String[] args) {
        log.debug("Starting program");
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        integerFlux.log().subscribe(System.out::println);
    }
}
