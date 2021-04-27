package combine;

import reactor.core.publisher.Flux;

public class Case02Concat {
    public static void main(String[] args) {
        Flux<String> publisher1 = Flux.just("1", "2");
        Flux<String> publisher2 = Flux.just("3", "4", "5");

        System.out.println("--------  Concat Output ------------");
        publisher1.concatWith(publisher2)
                .subscribe(System.out::println);

        System.out.println("--------  Concat Output - If Error ------------");
        Flux<String> errorPublisher = Flux.error(new RuntimeException("Runtime Error.."));
        Flux.concat(publisher1, errorPublisher, publisher2)
                .subscribe(System.out::println);

        System.out.println("--------  Concat Output - Delay Error ------------");
        Flux.concatDelayError(publisher1, errorPublisher, publisher2)
                .subscribe(System.out::println);
    }
}
