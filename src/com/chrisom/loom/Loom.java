package com.chrisom.loom;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Loom {
    public static Pattern pool = Pattern.compile("ForkJoinPool-[\\d?]");
    public static Pattern worker = Pattern.compile("worker-[\\d?]");
    public static Pattern thread = Pattern.compile("Thread-[\\d+]");

    public static void main(String[] args) throws IOException, InterruptedException {
        /*var thread = Thread.ofPlatform().unstarted(() -> System.out.println(Thread.currentThread()));
        thread.start();
        thread.join();

        var vthread = Thread.ofVirtual().unstarted(() -> System.out.println(Thread.currentThread()));
        vthread.start();
        vthread.join();*/
         /// work stealing
        /*var threads = IntStream.range(0, 10)
                .mapToObj(index -> Thread.ofVirtual().unstarted(() -> {
                    if (index == 0) {
                        System.out.println(Thread.currentThread());
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (index == 0) {
                        System.out.println(Thread.currentThread());
                    }
                })).toList();
        threads.forEach(Thread::start);
        for (Thread thread : threads)
            thread.join();*/
        long startTime = System.nanoTime();
        Set<String> platformThreadNames = ConcurrentHashMap.newKeySet();

        var threads = IntStream.range(0, 10_000_000)
                .mapToObj(index -> Thread.ofVirtual().unstarted(() -> {
                    platformThreadNames.add(Thread.currentThread().toString());
                })).toList();

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Ejecucion en milis: " + elapsedTime/1000000);

        //System.out.println("\nPlatform threads used: ");
        //platformThreadNames.forEach(System.out::println);

    }

}
