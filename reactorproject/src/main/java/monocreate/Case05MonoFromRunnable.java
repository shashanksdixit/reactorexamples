package monocreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

public class Case05MonoFromRunnable {
    public static void main(String[] args) {

        System.out.println("-------- From Runnable --------");

        // Use case: When you might want to get notified once a task is done.
        Mono
                .fromRunnable(someOtherTask())
                .subscribe(
                        System.out::println,
                        err -> System.out.println("Error " + err.getMessage()),
                        () -> System.out.println("Complete") // Notification of some other task is completed.
                );

    }

    private static Runnable someOtherTask() {

        return () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Faker.instance().name().fullName());
        };
    }

}
