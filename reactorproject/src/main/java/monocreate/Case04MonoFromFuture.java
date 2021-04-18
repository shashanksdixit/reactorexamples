package monocreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Case04MonoFromFuture {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------- From Future --------");
        Mono.fromFuture(getNameFuture()).subscribe(System.out::println);

        Thread.sleep(1000);

    }

    private static CompletableFuture<String> getNameFuture() {
        return CompletableFuture.supplyAsync(() -> Faker.instance().name().fullName());
    }
}
