package Ch_10;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Streams
Intermediate operations wont run until we call terminal operation
There are 2 types - finite and infinite streams
 */
public class StreamsExample {
    public static void main(String[] args) {
        System.out.println("hello");
        Stream.of(1, 2, 3, 4, 5)
                .filter(n -> {
                    System.out.println("filter: " + n);
                    return n % 2 == 0;
                }).forEach(n -> System.out.println("  result: " + n));


        //Infinite stream methods - iterate and generate
        int sum = Stream.iterate(1,i-> i <101,i->i+1).reduce(0,(a,b)-> a+b);
        System.out.println(sum);

        System.out.println(Optional.empty());  //Optional.empty()

        Stream<Double> ran = Stream.generate(Math::random);
        ran.findAny().ifPresent(System.out::println);

        //FindAny(), FindFirst() -> returns value
        //AnyMatch , AllMatch , NoneMatch -> returns boolean

        List<String> lst = List.of("arun","kumar","ak");
        System.out.println(lst.stream().anyMatch(x->x.startsWith("a"))); //true
        System.out.println(lst.stream().allMatch(x->x.startsWith("a"))); //false
        System.out.println(lst.stream().noneMatch(x->x.startsWith("t"))); //true

        String first = lst.stream().findFirst().get();
        String shortCut = lst.stream().findAny().get();
        System.out.println(shortCut);
        System.out.println(first);

        System.out.println("------------------------------");
        /*
        Reduce method -> single result
        3 ways
        reduce(binary operator)
        reduce ( identity , binary operator)
        reduce ( identity , binary operator ,combiner)
         */

        //method 1
        String result2 = Stream.of("a", "b", "c")
                .reduce( (a, b) -> a + b).get();
        System.out.println(result2);

        //method 2
        // DON'T do this — inefficient (creates new String each step)
        String result = Stream.of("a", "b", "c")
                .reduce("", (a, b) -> a + b);
        System.out.println(result);
        // DO this instead
        String result1 = Stream.of("a", "b", "c")
                .collect(Collectors.joining());
        System.out.println(result1);

        //Method 3
        int ans = Stream.of("ar","b","Cr").reduce(0,(i,a)->i+a.length(), (a,b)->a+b);
        System.out.println(ans);
        System.out.println("------------------------------");

        BinaryOperator<Integer> op = (a, b) ->
                a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        empty.reduce(op).ifPresent(System.out::println); // no output
        oneElement.reduce(op).ifPresent(System.out::println); // 3
        threeElements.reduce(op).ifPresent(System.out::println); // 90


        //Collect()
        //2 ways collect(collector) and collect(suppiler , combiner ,combiner)
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream.collect(
                TreeSet::new,
                TreeSet::add,
                TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]

        Stream<String> strea1m = Stream.of("w", "o", "l", "f");
        Set<String> set1 = strea1m.collect(Collectors.toSet());
        System.out.println(set1); // [f, w, l, o]
    }
}

class IntermediateOps{
    public static void main(String[] args) {
        //predicate
        Predicate<String> isA = a -> a.startsWith("a");
        Predicate<String> isLengthy = a-> a.length()>4;
        Predicate<String> isValid = isA.and(isLengthy);

        //filter
        List<String> words = List.of("ak","arunk" ,"arunkumar","ammma");
        words.stream().filter(isValid).forEach(System.out::print);

        //peek () -can modify data
        //count()
        //sorted() - 2 ways natural , comparator
        //distinct()
        // limit () , skip()

    }
}

/*
Primitive streams
3 - intstream,longstream,doublestream
 */
class PrimitiveStreamsExample{

    /*
    convert primitive stream to obj stream
    2 ways
    1) mapToObj()
    2) boxed()
     */
}

/*
SplitIterator
USed in parallel processing
Spliterator is to streams what Iterator is to collections
 */
class SpliteratorBasic {
    public static void main(String[] args) {
        List<String> names = List.of("Arun", "Ravi", "Kumar", "Priya", "Deepa");

        Spliterator<String> sp = names.spliterator();

        // tryAdvance — processes ONE element
        System.out.println("-- tryAdvance --");
        sp.tryAdvance(name -> System.out.println("First: " + name));  // Arun

        // forEachRemaining — processes ALL remaining
        System.out.println("-- forEachRemaining --");
        sp.forEachRemaining(name -> System.out.println("Rest: " + name));
        // Ravi, Kumar, Priya, Deepa


        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        Spliterator<Integer> original = nums.spliterator();
        Spliterator<Integer> split = original.trySplit(); // splits roughly in half

        System.out.println("Split half:");
        split.forEachRemaining(n -> System.out.print(n + " "));    // 1 2 3 4

        System.out.println("\nOriginal remaining:");
        original.forEachRemaining(n -> System.out.print(n + " ")); // 5 6 7 8
    }
}

record Employee(int id, String name, String dept, double salary) {}
class Hmm {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Arun", "IT", 85000),
                new Employee(2, "Ravi", "IT", 90000),
                new Employee(3, "Priya", "HR", 70000),
                new Employee(4, "Kumar", "HR", 75000),
                new Employee(5, "Deepa", "IT", 80000)
        );
        // LinkedHashMap — preserves insertion order
        Map<Integer, String> ordered = employees.stream()
                .collect(Collectors.toMap(
                        Employee::id,
                        Employee::name,
                        (a, b) -> a,          // merge fn required when supplying map
                        LinkedHashMap::new    // map supplier
                ));

        System.out.println(ordered);
// {1=Arun, 2=Ravi, 3=Priya, 4=Kumar, 5=Deepa}  ← insertion order preserved
    }
}

//Collectors.teeing()