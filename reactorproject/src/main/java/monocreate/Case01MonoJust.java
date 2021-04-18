package monocreate;


import reactor.core.publisher.Mono;

public class Case01MonoJust {

    public static void main(String[] args) {
        Mono
                .just(1)
                .subscribe(System.out::println);
    }
}
