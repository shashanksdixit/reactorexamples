package monocreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class Case03MonoFromSupplierAndCallable {
    public static void main(String[] args) {
        System.out.println("------ From Supplier ----");
        Mono<String> fromSupplier = Mono.fromSupplier(() -> Faker.instance().name().fullName());
        fromSupplier.subscribe(System.out::println);

        System.out.println("------ From Supplier ----");
        Mono<String> fromCallable = Mono.fromCallable(() -> Faker.instance().name().fullName());
        fromCallable.subscribe(System.out::println);

        System.out.println("------ Example ---------");
        Stream.of(1, 2, 0)
                        .forEach(id -> currencyRepository(id)
                .subscribe(currency -> System.out.println("Currency " + currency),
                        err -> System.out.println("Error " + err.toString()),
                        () -> System.out.println("..Complete.."))
        );
    }

    private static Mono<String> currencyRepository(int id) {
        if (id == 1) {
            return Mono.fromSupplier(() -> Faker.instance().currency().name());
        } else if (id == 2) {
            return Mono.empty();
        } else if (id == 0) {
            return Mono.error(new RuntimeException("Not allowed"));
        }
        return Mono.fromSupplier(() -> Faker.instance().currency().name());
    }
}
