package monocreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

public class Case05MonoFromRunnable {
    public static void main(String[] args) {

        System.out.println("-------- From Runnable --------");
        Mono
                .fromRunnable(someOtherTask())
                .subscribe(
                        obj -> System.out.println(obj),
                        err -> System.out.println("Error " + err.getMessage()),
                        () -> System.out.println("Complete") // Notification of someothertask is completed.
                );

    }

    private static Runnable someOtherTask() {
        return () -> System.out.println(Faker.instance().name().fullName());
    }

}
