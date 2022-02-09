package operators;

import reactor.core.publisher.Flux;

public class Case06ConcatMap {
    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.fromArray(new String[]{"abc", "def", "ghi", "jkl"});
        stringFlux
                .concatMap(word -> Flux.fromArray(word.split("")))
                .subscribe(System.out::println);
    }
}
