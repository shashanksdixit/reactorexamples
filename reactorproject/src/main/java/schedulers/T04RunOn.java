package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// Observe that the threads are created as number of cores available.
public class T04RunOn {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Available Processors : " + Runtime.getRuntime().availableProcessors());
        Flux.just("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
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
