package monocreate;

import reactor.core.publisher.Mono;

public class Case02MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(10);
        mono.subscribe(i -> System.out.println("Received : " + i),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed."));
    }
}
