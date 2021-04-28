package repeatretry;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Case03Retry {
    public static void main(String[] args) {
        publisher()
                .retry(2)
                .subscribe(i -> System.out.println("Received - " + i),
                        err -> System.out.println("Error - " + err.getMessage()),
                        () -> System.out.println("Subscription Completed"));
    }

    private static Flux<Integer> publisher() {
        return Flux.range(1, 10)
                .doOnSubscribe(s -> System.out.println("-- Subscribed --"))
                .doOnComplete(() -> System.out.println("-- Completed --"))
                .map(i -> i / (Faker.instance().random().nextInt(1, 10) > 8 ? 0 : 1))
                .doOnError(err -> System.out.println("-- Error thrown --"));
    }
}
