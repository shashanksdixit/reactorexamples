package repeatretry;

import reactor.core.publisher.Flux;

// Observe that subscription gets repeated N more times where N is the number given in repeat()
// "Subscription completed" message is printed after all the repeats are over.
public class Case01Repeat {
    public static void main(String[] args) {
        publisher()
                .repeat(3)
                .subscribe(i -> System.out.println("Received - " + i),
                        err -> System.out.println("Error - " + err.getMessage()),
                        () -> System.out.println("Subscription Completed"));
    }

    private static Flux<Integer> publisher() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("-- Subscribed --"))
                .doOnComplete(() -> System.out.println("-- Completed --"));
    }
}
