package combine;

import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Case04Zip {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> publisher1 = Flux.just(1, 2, 3, 4, 5, 6, 7, 8);
        Flux<Integer> publisher2 = Flux.just(10, 20, 30, 40, 50, 60);
        Flux<Integer> publisher3 = Flux.just(100, 200, 300, 400, 500, 600, 700);

        Flux.zip(publisher1, publisher2, publisher3)
                .delayElements(Duration.ofSeconds(1)) //Added just to understand the output
                .subscribe(System.out::println);

        Thread.sleep(10000);

    }
}
