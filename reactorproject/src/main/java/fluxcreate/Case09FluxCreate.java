package fluxcreate;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class Case09FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for(int i = 0; i < 10; i++)
                fluxSink.next(Faker.instance().aviation().airport());
            fluxSink.complete();
        }).subscribe(System.out::println);

        // We can do it in another way.

        BookPublisher publisher = new BookPublisher();
        Flux.create(publisher).log()
                .subscribe(bookName -> System.out.println("Publishing book - " + bookName));
        for (int i = 0; i < 10; i++)
            publisher.getBook();
        publisher.complete();
    }

//    private static BookPublisher getPublisher() {
//        return new BookPublisher();
//    }

}


class BookPublisher implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;
    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void getBook() {
        fluxSink.next(Faker.instance().book().title());
    }

    public void complete() { fluxSink.complete(); }

}
