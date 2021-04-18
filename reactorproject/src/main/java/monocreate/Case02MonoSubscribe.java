package monocreate;

import reactor.core.publisher.Mono;

public class Case02MonoSubscribe {
    public static void main(String[] args) {
        // Mono with subscription consumers
        System.out.println("------- Mono - Subscription Consumers --------");

        Mono<Integer> mono = Mono.just(10);
        mono.subscribe(i -> System.out.println("Received : " + i),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed."));

        //Mono - error example
        System.out.println("------- Mono - Error example --------");
        Mono.just(10)
                .map(i -> i / 0)
                .subscribe(i -> System.out.println("Received : " + i),
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("Completed."));
    }
}
