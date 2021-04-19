package fluxcreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Case11FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Faker.instance().country().name()))
                .take(10) // -- generate keeps generating
                .subscribe(System.out::println);
    }
}
