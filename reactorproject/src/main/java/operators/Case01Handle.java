package operators;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Case01Handle {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Faker.instance().country().name()))
                .map(country -> country.toString())
                .handle((country, synchronousSink) -> { // sends data further with synchronous sync to operate on
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("japan")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(System.out::println);

    }
}
