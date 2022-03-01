package fluxcreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Case10FluxCreateCheckCancel {
    public static void main(String[] args) {
        // Check how flux sink emits even after onComplete. Now uncomment the if statement and check.
        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                String airport = Faker.instance().aviation().airport();
                if (fluxSink.isCancelled()) // After "take(n)" flux sink should stop
                    return;
                System.out.println("Emitting : " + airport);
                fluxSink.next(airport);
            }
        })
                .take(4)
                .log()
                .subscribe(name -> System.out.println("Received " + name));
    }
}
