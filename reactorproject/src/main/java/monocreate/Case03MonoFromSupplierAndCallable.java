package monocreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

public class Case03MonoFromSupplierAndCallable {
    public static void main(String[] args) {
        System.out.println("------ From Supplier ----");
        Mono<String> fromSupplier = Mono.fromSupplier(() -> Faker.instance().name().fullName());
        fromSupplier.subscribe(System.out::println);

        System.out.println("------ From Supplier ----");
        Mono<String> fromCallable = Mono.fromCallable(() -> Faker.instance().name().fullName());
        fromCallable.subscribe(System.out::println);
    }
}
