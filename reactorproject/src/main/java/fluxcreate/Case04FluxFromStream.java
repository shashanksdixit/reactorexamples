package fluxcreate;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Case04FluxFromStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4).stream();

        Flux.fromStream(stream)
                .subscribe(i -> System.out.println("Received : " + i),
                        err -> System.out.println("Error : " + err.getMessage()),
                        () -> System.out.println("Completed"));

        // In case of streams, multiple subscribers are not possible.
        Flux.fromStream(stream)
                .subscribe(i -> System.out.println("Received : " + i),
                        err -> System.out.println("Error : " + err.getMessage()),
                        () -> System.out.println("Completed"));

    }
}
