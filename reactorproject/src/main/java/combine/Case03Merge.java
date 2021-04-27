package combine;

import reactor.core.publisher.Flux;

import java.time.Duration;

/* Merge interleaves the flux elements as and when they are received */
public class Case03Merge {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> publisher1 = Flux.just(1, 2, 3, 4, 5, 6, 7, 8).delayElements(Duration.ofMillis(100));
        Flux<Integer> publisher2 = Flux.just(10, 20, 30, 40, 50, 60).delayElements(Duration.ofMillis(130));
        Flux<Integer> publisher3 = Flux.just(100, 200, 300, 400, 500, 600, 700).delayElements(Duration.ofMillis(50));

        Flux.merge(publisher1, publisher2, publisher3)
                .subscribe(i -> System.out.print(" " + i + " "));

        Thread.sleep(3000);
    }
}
