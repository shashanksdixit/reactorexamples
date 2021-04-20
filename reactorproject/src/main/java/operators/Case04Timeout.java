package operators;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Case04Timeout {
    public static void main(String[] args) throws InterruptedException {

        // observe without and with fallback
        slowProcess().log()
                .timeout(Duration.ofSeconds(2) /*, fallbackProcess()*/)
                .subscribe(System.out::println);

        Thread.sleep(60000);
    }

    private static Flux<Integer> slowProcess() {
        return Flux.range(0, 20).delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallbackProcess() {
        return Flux.range(100, 5).delayElements(Duration.ofMillis(200));
    }
}
