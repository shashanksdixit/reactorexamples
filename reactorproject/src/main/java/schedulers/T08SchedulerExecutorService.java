package schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T08SchedulerExecutorService {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "2", "3")
                .log()
                .publishOn(Schedulers.fromExecutor(Helper.get()))
                .map(str -> {
                    System.out.println("Thread - " + Thread.currentThread().getName() + ":: Working on - " + str);
                    return Integer.parseInt(str);
                }).doFinally((signal) -> Helper.shutdown())
                .subscribe(System.out::println);
        Thread.sleep(2000);
    }

}

class Helper {
    private static ExecutorService executorService;

    public static ExecutorService get() {
        if (executorService == null)
            executorService = Executors.newFixedThreadPool(10);
        return executorService;
    }

    public static void shutdown() {
        if (executorService != null)
            executorService.shutdown();
    }
}
