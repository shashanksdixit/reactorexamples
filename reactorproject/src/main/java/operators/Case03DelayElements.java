package operators;

import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Case03DelayElements {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(System.out::println);

        Thread.sleep(60000);
    }
}
