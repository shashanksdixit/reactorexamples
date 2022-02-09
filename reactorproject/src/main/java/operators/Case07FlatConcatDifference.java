package operators;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class Case07FlatConcatDifference {
    private static Flux<String> splitWithDelay(String word) {
        Random random = new Random(100);
        var charArray = word.split("");
        return Flux.fromArray(charArray).delayElements(Duration.ofMillis(random.nextInt()));
    }

    private static void flatMapExample(String[] names) {
        Flux.fromArray(names).flatMap(Case07FlatConcatDifference::splitWithDelay).log()
                .collectList()
                .subscribe(System.out::println);
    }

    private static void concatMapExample(String[] names) {
        Flux.fromArray(names).concatMap(Case07FlatConcatDifference::splitWithDelay).log()
                .collectList()
                .subscribe(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        String[] names = new String[]{"abc", "def", "ghi", "jkl"};
        flatMapExample(names);
        concatMapExample(names);
        Thread.sleep(1000);
    }
}
