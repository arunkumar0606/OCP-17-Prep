package ch_5;

public class Chapter5 {
    private String name;
    /*
    Methods
    1) method signature - setName(String name)
    2) method body - { this.name = name; }
     */
    public void setName(String name){
        //final variable - cannot be reassigned after initialization
        final int age=5;
        //effectively final variable - can be assigned only once, but not declared as final
        // if added final it still works
        int age2;
        age2=10;
        System.out.println(age);
        System.out.println(age2);
        this.name = name;


    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}


class StaticExample{
    private static int staticCount;
    private int count;

    public void increment() {
        staticCount++;
        count++;
    }

    public static void decrement() {
        staticCount--;
        //count--; // Cannot access non-static variable 'count' from a static context
    }

    public static void main(String[] args) {
        StaticExample example = new StaticExample();
        example.staticCount++;
        //StaticExample.count++; // Cannot access non-static variable 'count' from a static context
        example.count++;
        System.out.println("Static Count: " + example.staticCount); // Output: Static Count: 1
        System.out.println("Instance Count: " + example.count); // Output: Instance Count: 1

        example.increment();
        System.out.println("Static Count after increment: " + example.staticCount); // Output: Static Count after increment: 2
        System.out.println("Instance Count after increment: " + example.count); // Output: Instance Count after increment: 2

        StaticExample.decrement();
        System.out.println("Static Count after decrement: " + example.staticCount); // Output: Static Count after decrement: 1
        System.out.println("Instance Count after decrement: " + example.count); // Output: Instance Count after decrement: 2 (unchanged)
    }

    //Static imports
        //import static java.lang.Math.PI;
        //import static java.lang.Math.sqrt;
        //import static java.lang.Math.*; // imports all static members of Math class
    //we can just use sqrt(4) instead of Math.sqrt(4) and PI instead of Math.PI

    //JAVA - Pass by value


}
//Recreating System.out.println
class PrintString{
    public static void println(String str){
        System.out.println(str);
    }
}
class AkSystem{
    public static PrintString out = new PrintString();
}

class Test{
    public static void main(String[] args) {
        AkSystem.out.println("Hello from AkSystem!");
    }
}

//Method overloading - same method name but different parameters

//Object > Long > Int > Short
//Object > String
//Auto-boxing happens internally
class OverloadingExample{
    public void display(short s){
        System.out.println("Short: " + s);
    }
    public void display(int i){
        System.out.println("Int: " + i);
    }
    public void display(long l) {
        System.out.println("Long: " + l);
    }

    public void display(String s){
        System.out.println("String: " + s);
    }
    public void display(Object o){
        System.out.println("Object: " + o);
    }

    public static void main(String[] args) {
        OverloadingExample example = new OverloadingExample();
        example.display(10); // Calls display(int i)
        example.display((short) 10); // Calls display(short s)
        example.display(10L); // Calls display(long l)

        example.display("Hello"); // Calls display(String s)
        example.display(new Object()); // Calls display(Object o)
    }
}
//var args - variable number of arguments
class Toucan {
    public void fly(int[] lengths) {}
   // public void fly(int... lengths) {} // DOES NOT COMPILE
}

/*
Exact match -> Larger primitive -> Autoboxing -> Varargs
print(1,2);
1) print(int a, int b) - exact match
2) print(long a, long b) - larger primitive
3) print(Integer a, Integer b) - autoboxing
4) print(int... numbers) - varargs
 */
