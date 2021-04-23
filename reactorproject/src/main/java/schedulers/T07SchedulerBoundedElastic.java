package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


//To do
public class T07SchedulerBoundedElastic {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "2", "3")
                .log()
                .publishOn(Schedulers.boundedElastic())
                .map(str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    if (str.equals("2")) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    return Integer.parseInt(str);
                })
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
