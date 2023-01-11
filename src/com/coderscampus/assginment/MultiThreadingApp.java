package com.coderscampus.assginment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class MultiThreadingApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //We are used to work on a synchronous programing
       /* String message = "Starting";
        System.out.println(message);
        System.out.println("Thread-"+ Thread.currentThread().getName());
*/

        //This starts up as many threads as there are interations in the foor loop.
        //You 1
        //
        //2
        //
        //
        //
        //
        //
        //Search Coders Campusonly want to fire up a ton of threads, if those threads are going to
        //be waiting a lot.. i.e. I/O type

      /*  for(int i =0;i<5; i++){
            SomeTask task = new SomeTask();
            new Thread(task).start();
        }
        */
        // For a CPU bound operation like we hav ein our "SomeTask" class,
        // we should make use of an ExecturorService

        //ExecutorService service = Executors.newSingleThreadExecutor();

     /*   List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for(int i = 0;i<20;i++){
            /*
            Futures were great prior to Java 8
            Future<TaskDto> futureTask =  service.submit(new SomeTask());
            System.out.println(futureTask.get());*/

/*
            CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> new SomeTask())
                    .thenApply(someTask -> someTask.call())
                    .thenAccept(dto -> System.out.println(dto));

            tasks.add(task);

        }

        while (tasks.stream()
                .filter(CompletableFuture::isDone)
        .count() < 20){


        }

        message = "Done";
        System.out.println(message);

*/

    }


}
