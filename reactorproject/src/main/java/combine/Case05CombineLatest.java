package combine;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Case05CombineLatest {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> publisher1 = Flux.just(1, 2, 3, 4, 5, 6, 7, 8).delayElements(Duration.ofMillis(500));
        Flux<Integer> publisher2 = Flux.just(10, 20, 30, 40, 50, 60).delayElements(Duration.ofMillis(550));

        Flux.combineLatest(publisher1, publisher2, (i1, i2) -> "[" + i1 +"," + i2 + "]")
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
