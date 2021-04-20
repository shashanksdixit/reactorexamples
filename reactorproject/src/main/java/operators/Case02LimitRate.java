package operators;

import reactor.core.publisher.Flux;

public class Case02LimitRate {
    public static void main(String[] args) {
        /* default */
        Flux.range(1, 1000)
                .log()
                .limitRate(100)
                .log()
                .subscribe(i -> System.out.println("Received : " + i));

        /* limit rate can be changed
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 99)
                .log()
                .subscribe(i -> System.out.println("Received : " + i)); */

        /* If high tide and low tide are equal then it is back to 75%
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 100)
                .log()
                .subscribe(i -> System.out.println("Received : " + i)); */

        /* case - low tide = 0
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 0)
                .log()
                .subscribe(i -> System.out.println("Received : " + i)); */
    }
}
