package Ch_13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

/*
Creating threads
1)Thread class
2)Runnable interface
States -> new,runnable,running,waiting,timed_waiting,blocked,terminated
 */
public class Concurrency {
    public static void main(String[] args) {
        //Thread class
        Thread t1= new Thread( ()-> System.out.println("running t1..."));
        Thread t2= new Thread( ()-> System.out.println("running t2..."));
        t1.start();t2.start();
        System.out.println("hello");


        //Runnable interface
        Runnable r1= ()-> System.out.println("running runnable . .");
        r1.run(); // 1 way or
        new Thread(r1).start(); //2nd way

        Thread t3 = new Thread(()-> System.out.println("This is daemon thread.."));
        t3.setDaemon(true);
        t3.start();

        //Thread.interrupt () is a way to tell  a thread to stop
    }
}

/*
ExecutorService
 */
class Sample{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newCachedThreadPool();
        exe.submit(()-> System.out.println("hello"));
        exe.submit(()-> System.out.println("hello"));
        exe.submit(()-> System.out.println("hello"));
        //Executor.shutdown() does not end process , it doesn't allow new tasks
        //Future object for Runnable is Null //future.get() -> null

        var service = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> result = service.submit(() ->
                    30 + 11);
            System.out.println(result.get()); // 41
        } finally {
            service.shutdown();
        }

        //awaitTermination() -> waits for the executing thread to finish
        ScheduledExecutorService service1
                = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () ->
                System.out.println("Hello Zoo");
        //Schedueled task -> once in future
        ScheduledFuture<?> r1 = service1.schedule(task1, 1,TimeUnit.SECONDS);
        //Schedueled task -> continuous in future
        service1.scheduleAtFixedRate(task1,1,1,TimeUnit.SECONDS);

    }
}

/*
Thread safety
atomic classes, synchronized blocks, the Lock framework, and cyclic barriers.
 */
//It is critical that you release a lock the same number of times it is acquired!
/*
ConcurrentCollections
When modifying hashmap using multiple threads it gives concurrent modification exception
 */

//Parallel Stream
class Para{
    public static void main(String[] args) {
        List<Integer> ls = List.of(1,2,3,4,5);
        //2 ways
        Stream<Integer> p1 = ls.stream().parallel();
        Stream<Integer> p2 = ls.parallelStream();

        ls.forEach(x-> System.out.println(x));
        System.out.println("--Over--");

        //ls.forEachOrdered(x->x)// maintains order
        /*
        For serial streams, using an unordered version has no effect. But on parallel streams, the
        results can greatly improve performance.
        List.of(1,2,3,4,5,6).stream().unordered().parallel();

        reduce() with parallel streams gives unpredicted data
         */
        System.out.println(List.of("w","o","l","f")
                .parallelStream()
                .reduce("X", String::concat)); //XwXoXlXf
    }
}