package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

//observe that the subscribeOn closest to the publisher matters. Try updating the scheduler on both the subscribeon
public class T10SchedulerMultipleSubscribeOn {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "2", "3")
                .log()
                .subscribeOn(Schedulers.single()) // closest to the publisher
                .map(str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    return Integer.parseInt(str);
                })
                .subscribeOn(Schedulers.parallel())
                .subscribe(System.out::println);
        Thread.sleep(2000);
    }
}
