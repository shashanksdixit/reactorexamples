package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class T03SubscribeOn {
    public static void main(String[] args) throws InterruptedException {
        Scheduler scheduler = Schedulers.newParallel("parallel-1", 4);

        final Flux<String> flux = Flux.range(1, 10)
                .map(i -> 10 + i).log()
                .subscribeOn(scheduler)
                .map(i -> "Value " + i).log();

        Thread t = new Thread(() -> {
            flux.subscribe(str -> System.out.println(Thread.currentThread().getName() + " : " + str));
        });
        t.start();
        t.join();
    }
}
