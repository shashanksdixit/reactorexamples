import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Case01StepVerifier {

    @Test
    public void fluxJustTest() {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3);

        StepVerifier.create(integerFlux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .verifyComplete();
    }

    @Test
    public void fluxJustTest2() {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3);

        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3)
                .verifyComplete();
    }

    @Test
    public void testError() {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3);
        Flux<Integer> errorFlux = Flux.error(new RuntimeException("Some error"));
        Flux<Integer> combineFlux = Flux.concat(integerFlux, errorFlux);
        StepVerifier.create(combineFlux)
                .expectNext(1, 2, 3)
                .verifyError(RuntimeException.class);
    }

    @Test
    public void testRange() {
        Flux<Integer> range = Flux.range(1, 50);
        StepVerifier.create(range)
                .expectNextCount(50)
                .verifyComplete();
    }

}
