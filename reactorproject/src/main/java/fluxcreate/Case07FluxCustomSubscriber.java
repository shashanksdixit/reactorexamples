package fluxcreate;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Case07FluxCustomSubscriber {
    public static void main(String[] args) {
        AtomicReference<Subscription> subscriptionReference = new AtomicReference<>();
        Flux
                .range(1, 20)
                .log() //Observe logs for request and received integers
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("Received subscription object");
                        subscriptionReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Received : " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Error : " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Complete");
                    }
                });

        subscriptionReference.get().request(4);
        subscriptionReference.get().request(4);
        subscriptionReference.get().cancel();
        subscriptionReference.get().request(4);
    }
}
