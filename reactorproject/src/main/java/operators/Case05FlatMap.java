package operators;

import reactor.core.publisher.Flux;

public class Case05FlatMap {
    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.fromArray(new String[]{"abc", "def", "ghi", "jkl"});
        stringFlux
                .flatMap(word -> Flux.fromArray(word.split("")))
                .subscribe(System.out::println);
    }
}
