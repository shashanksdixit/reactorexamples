package monocreate;


import reactor.core.publisher.Mono;

public class Case01MonoJust {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        mono.subscribe(System.out::println);
        mono.subscribe(i -> System.out.println("Subscribing again " + i));

        /*
            Demonstration of how streams are different
        */
        // Stream stream = Stream.of(1, 2);
        // stream.forEach(System.out::println);
        // stream.forEach(System.out::println);
    }
}
