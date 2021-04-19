package fluxcreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Case08FluxInterval {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .map(i -> Faker.instance().book().title())
                .subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
