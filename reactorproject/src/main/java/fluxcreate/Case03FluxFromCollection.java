package fluxcreate;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Case03FluxFromCollection {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d");
        Flux
                .fromIterable(strings)
                .subscribe(System.out::println);

        Integer[] array = {1, 2, 3, 4};
        Flux
                .fromArray(array)
                .subscribe(System.out::println);
    }
}
