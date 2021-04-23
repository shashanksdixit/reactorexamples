package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// Observe that the placement of subscribeon does not matter unlike publish on
public class T09SchedulerSubscribeOn {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "2", "3")
                .log()
//                .subscribeOn(Schedulers.single())
                .map(str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    return Integer.parseInt(str);
                })
                .subscribeOn(Schedulers.single())
                .subscribe(System.out::println);
        Thread.sleep(2000);
    }
}
