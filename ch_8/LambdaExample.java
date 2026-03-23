package ch_8;

import java.util.function.*;

public class LambdaExample {
}

interface Calculate{
    int operate(int a , int b);
}
interface Square{
    int operate(int a);
}
//Valid lambdas
class Sample{
    public static void main(String[] args) {
        Calculate add = (a,b)-> a+b;
        Calculate mul = (a,b) -> {return a*b ; };

        System.out.println(add.operate(1,2));
        System.out.println(mul.operate(1,2));

        Square sq = a->a*a ;
        Square sq1 = (int a) -> a*a ;
        Square sq2 = (a) -> a*a ;
        Square sq3 = a-> {return  a*a ; };

        var sq4 = (Square) a-> a*a;
        System.out.println(sq4.operate(5));

        //Local variables possible
        Square sqq = a -> {
            int bee=5;
            int ceee=6;
            return bee*ceee;
        };

        //lambda can access only final or effectively final variables
        final String name= "arun";
        Square seee = a -> {
            System.out.println(name);
            return a;
        };

    }
}

//equals() , hashCode() and toString() doesn't count towards abstract methods


/*
Method references

 */

interface Home{
    void paint(String s);
}
class House {
    public static void main(String[] args) {
        Home h1 = (s) -> System.out.println(s);
        Home h2 = System.out::println;  //shorter

        h1.paint("Arun"); // Arun
        h2.paint("Arun"); // Arun
    }
}

//1.Static method reference
interface Cal{
    long execute(double d);
}
//2.Instance method on object
interface Two{
    boolean check(String s);
}
//3.Instance methods on parameter
interface Change{
    boolean execute(String str1, String str2) ;

}

// 4. Using constructor reference  :: new
class Some{
    public static void main(String[] args) {
        Cal c = Math::round; //1
        Two d= "arun"::startsWith; //2
        Change r = String::startsWith;  //3 // can automatically convert to str1.startsWith(str2) internally
        System.out.println(c.execute(12.5));
        System.out.println(d.check("a"));
        System.out.println(r.execute("arun","a"));
    }
}

/*
Built in functional interfaces
1) Supplier - get
2) Consumer - accept
3) Predicate - test
4) Function - apply
 */

class Dummy{
    static Supplier<String> breakLine = () -> "---------------------------";

    static Consumer<String> printScreen = System.out::println;
    static BiConsumer<String,String> addWord = (a,b) -> System.out.println("[LOG] : "+a+" "+ b);

    static Predicate <String> isHeOCPCertified = a -> a.startsWith("aru");
    static BiPredicate<String, String> isItCaps = String::startsWith;

    static Function<String,Integer> calculateLength = (String s) -> s.length();
    static BiFunction<String,String,String> combineLength = (a,b) -> "[Log] "+a+" "+b;

    static UnaryOperator<String> uOps = a->a+"...";
    static BinaryOperator<String> biOps = (a,b) -> a+",,,,"+b;

    //combined predicates
    static Predicate<String> isA = a-> a.startsWith("a");
    static Predicate<String> isLength = a-> a.length()>7;
    static Predicate<String> isValid = isA.and(isLength);

    static Function<Integer,Integer> add = (a)-> a+2;
    static Function<Integer,Integer> mul = (a)-> a*3;
    static Function<Integer, Integer> addAndMul = add.compose(mul);  //8
    //static Function<Integer, Integer> addAndMul = add.andThen(mul);  //12


    //Functional interface for primitives
    //DoubleSupplier , IntSupplier , BooleanSupplier etc


    public static void main(String[] args) {
        System.out.println(breakLine.get());
        printScreen.accept("Arun is good");
        addWord.accept("arun","kumar");
        System.out.println(isHeOCPCertified.test("arun"));
        System.out.println(isItCaps.test("Arun","A"));
        System.out.println(calculateLength.apply("arunkumard"));
        System.out.println(combineLength.apply("arun","kumar"));
        System.out.println(uOps.apply("arun"));
        System.out.println(biOps.apply("arun","kumar"));

        System.out.println(isValid.test("arunkumard"));
        System.out.println(addAndMul.apply(2));
    }
}