package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class T11SchedulerSubscribePublishBoth {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "2", "3")
                .log()
                .subscribeOn(Schedulers.single())
                .map(str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    return Integer.parseInt(str);
                })
                .publishOn(Schedulers.parallel())
                .map(i -> {
                    int j = i * 100;
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + j);
                    return j;
                })
                .subscribe(System.out::println);
        Thread.sleep(2000);
    }

}
