package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;


public class T04RunOn {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "2", "3", "4", "5", "6", "7")
                .parallel()
                .runOn(Schedulers.parallel())
                .map( str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    return Integer.parseInt(str);
                })
                .sequential()
                .subscribe(System.out::println);
        Thread.sleep(5000);
    }
}
