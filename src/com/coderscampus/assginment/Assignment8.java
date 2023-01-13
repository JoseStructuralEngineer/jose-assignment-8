package com.coderscampus.assginment;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Assignment8 {
    private List<Integer> numbers = null;
    private HashMap<Integer,Integer> sm = new HashMap<>();
    private AtomicInteger i = new AtomicInteger(0);

    @Test

    public void getData () {

        Assignment8 assignment = new Assignment8();
        List<CompletableFuture<List<Integer>>> tasks = new ArrayList<>();
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i=0; i<1000; i++) {
            CompletableFuture<List<Integer>> task =
                    CompletableFuture.supplyAsync(() -> assignment.getNumbers(), pool);
            tasks.add(task);
           /*
            List<Integer> numbersList = assignment.getNumbers();

            System.out.println(numbersList);*/

        }

        while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000) {
            //System.out.println("Number of completed threads: "
            //        + tasks.stream().filter(CompletableFuture::isDone).count());
            //tasks.stream().filter(CompletableFuture::isDone).count();
        }

        //System.out.println(tasks.size());

        tasks.stream().filter(CompletableFuture::isDone).forEach((entry) -> {
            try {

                //System.out.println(entry.get());


                entry.get().forEach(e -> {
                    if(sm.get(e)==null){
                        sm.put(e,1);
                    } else {
                        sm.put(e,sm.get(e)+1);
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });


        outputI();

    }

    public Assignment8() {
        try {
            // Make sure you download the output.txt file for Assignment 8
            // and place the file in the root of your Java project
            numbers = Files.readAllLines(Paths.get("output.txt"))
                    .stream()
                    .map(n -> Integer.parseInt(n))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will return the numbers that you'll need to process from the list
     * of Integers. However, it can only return 1000 records at a time. You will
     * need to call this method 1,000 times in order to retrieve all 1,000,000
     * numbers from the list
     *
     * @return Integers from the parsed txt file, 1,000 numbers at a time
     */
    public List<Integer> getNumbers() {
        int start, end;
        synchronized (i) {
            start = i.get();
            end = i.addAndGet(1000);

            //System.out.println("Starting to fetch records " + start + " to " + (end));
        }
        // force thread to pause for half a second to simulate actual Http / API traffic
        // delay
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Integer> newList = new ArrayList<>();

        //Here we are getting the numbers
        IntStream.range(start, end)
                .forEach(n -> {
                    newList.add(numbers.get(n));
                    //Here it fetches all data task by task
                });
        //System.out.println("Done Fetching records " + start + " to " + (end));
        return newList;
    }

    private void outputI() {

        System.out.println(sm);
    }

}