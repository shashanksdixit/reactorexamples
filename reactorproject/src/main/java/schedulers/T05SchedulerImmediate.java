package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class T05SchedulerImmediate {
    public static void main(String[] args) {
        Flux.just("1", "2", "3")
                .log()
                .publishOn(Schedulers.immediate())
                .map(str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    return Integer.parseInt(str);
                })
                .subscribe(System.out::println);
    }
}
