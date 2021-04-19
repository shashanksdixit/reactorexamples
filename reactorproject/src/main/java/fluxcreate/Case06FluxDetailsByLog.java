package fluxcreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Case06FluxDetailsByLog {
    public static void main(String[] args) {
        // Observe the output of both the logs. Observe next and complete events.
        Flux.range(1, 10)
                .log()
                .map(i -> Faker.instance().book().title())
                .log()
                .subscribe(System.out::println);
    }
}
