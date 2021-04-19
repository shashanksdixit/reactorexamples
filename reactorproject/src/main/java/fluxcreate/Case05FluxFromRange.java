package fluxcreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Case05FluxFromRange {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .subscribe(System.out::println);

        // This can be used as for loop

        Flux.range(1, 10)
                .map(i -> Faker.instance().book().title())
                .subscribe(System.out::println);
    }
}
