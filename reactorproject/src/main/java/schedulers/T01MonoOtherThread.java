package schedulers;

import reactor.core.publisher.Mono;

public class T01MonoOtherThread {
    public static void main(String[] args) throws InterruptedException {
        Mono<String> mono = Mono.just("Hello ");
        Thread t = new Thread(
                () -> mono.map(msg -> msg + " Thread ")
                    .subscribe( v -> System.out.println(v + Thread.currentThread().getName()))
        );
        t.start();
        t.join();
    }
}
