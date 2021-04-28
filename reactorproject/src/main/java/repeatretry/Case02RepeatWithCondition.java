package repeatretry;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicBoolean;

public class Case02RepeatWithCondition {

    private  static final AtomicBoolean flag = new AtomicBoolean(true);
    public static void main(String[] args) {
        publisher()
                .repeat(flag::get)
                .subscribe(country -> System.out.println("Received - " + country),
                        err -> System.out.println("Error - " + err.getMessage()),
                        () -> System.out.println("Subscription Completed"));
    }

    private static Flux<String> publisher() {
        return Flux.range(1, 2)
                .map(i -> {
                    String country = Faker.instance().country().name();
                    System.out.println("-- Emitting Country : " + country);
                    if (country.equals("Canada"))
                        flag.set(false);
                    return country;
                })
                .doOnSubscribe(s -> System.out.println("-- Subscribed --"))
                .doOnComplete(() -> System.out.println("-- Completed --"));
    }
}
