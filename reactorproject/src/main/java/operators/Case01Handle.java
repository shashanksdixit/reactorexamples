package operators;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Case01Handle {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Faker.instance().country().name()))
                .map(country -> country.toString())
                .handle((country, synchronousSink) -> {
                    synchronousSink.next(country);
                    if (country.toLowerCase().equals("japan")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(System.out::println);

    }
}
