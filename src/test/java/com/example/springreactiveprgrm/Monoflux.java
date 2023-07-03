package com.example.springreactiveprgrm;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Predicate;

public class Monoflux {
    @Test
    public void monoTest(){
        Mono<String> publisher = Mono.just("nikhil").log();
//     to access any publisher(mono, flux) we  need to call subscribe method from publisher
//        subscriber needs to access publisher
        publisher.subscribe(
                n -> {
                    System.out.println("data recieved");
                    System.out.println(n.charAt(0));
                },
                n -> System.out.println("printing"),
                () -> System.out.println("completed")
        );
    }

    @Test
    public void monoFluxTest(){
        Mono<String> producer=Mono.just("monoflux").log();
        producer.subscribe(System.out::println);
    }

    @Test
    public void fluxTest(){
        Flux<String> publisherflux=Flux.just("one","two","three")
                .concatWithValues("fourth from concat")
                .concatWith(Flux.error(new Exception("some exception")))
                .log();
        publisherflux.subscribe(System.out::println);

    }
}

