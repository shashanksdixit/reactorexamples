package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class T06SchedulerPublishOnSingle {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "2", "3")
                .log()
                .publishOn(Schedulers.single())
                .map(str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    return Integer.parseInt(str);
                })
                .subscribe(System.out::println);
        Thread.sleep(2000);
    }
}
