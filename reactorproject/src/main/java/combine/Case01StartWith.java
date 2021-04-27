package combine;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/* Startwith prepends the flux to the other flux. Following example prepends the "Cached" Flux
with the generated flux.

Observe that the subscriber 2 gets first 2 values from the cache and 3rd value is generated.
 */
public class Case01StartWith {

    private static List<String> cache = new ArrayList<>();

    public static void main(String[] args) {
        timeConsumingMethodGetCountryList()
                .take(2)
                .subscribe(country -> System.out.println("Subscriber 1 : " + country));

        timeConsumingMethodGetCountryList()
                .take(3)
                .subscribe(country -> System.out.println("Subscriber 2 : " + country));
    }

    private static Flux<String> timeConsumingMethodGetCountryList() {
        return Flux.generate(synchronousSink -> {
            String country = Faker.instance().country().name();
            System.out.println("Generating : " + country);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cache.add(country);
            synchronousSink.next(country);
        })
                .cast(String.class)
                .startWith(getCountryListFromCache());
    }

    private  static Flux<String> getCountryListFromCache() {
        Flux<String> cacheFlux = Flux.fromIterable(cache);
        return cacheFlux;
    }
}
