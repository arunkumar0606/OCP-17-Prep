package ch_6;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Chap6_partTwo {
}


//final variables must be initialized somehow once
class FinalVariables{
    private final String name;
   // private final int age; //does not compile
    public FinalVariables() {
        this.name = "arun";
    }

    public FinalVariables(String name, int age) {
        this.name = name;
       // this.age = age;
    }

}

//Order -> static , instance initializers -> constructors
class GiraffeFamily {
    static { System.out.print("|staticA|"); }
    { System.out.print("|InstanceInitB|"); }

    public GiraffeFamily(String name) {
        this(1);
        System.out.print("|ConsC|");
    }

    public GiraffeFamily() {
        System.out.print("D");
    }

    public GiraffeFamily(int stripes) {
        System.out.print("|ConsE|");
    }
}

 class Okapi extends GiraffeFamily {
    static { System.out.print("staticF"); }

    { System.out.print("|InstanceInitH|"); }

    public Okapi(int stripes) {
        super("sugar");
        System.out.print("|ConsG|");
    }

    public static void main(String[] args) {
        new Okapi(1);
        System.out.println();
        new Okapi(2);
    }
}

/*
Overriding methods in Inheritance
1) method signature must be the same
2) return type must be the same or covariant (subclass of the return type in the parent class)
3) access modifier must be the same or more accessible
4) cannot throw new or broader checked exceptions
5) can throw any unchecked exceptions
6) can call super.method() to invoke the parent class method
7) cannot override private methods
 */


// Parent class
class Animal1 {

    // 1) Method signature
    // 2) Return type (general type)
    // 4) Throws checked exception
    protected Number makeSound() throws IOException {
        System.out.println("Animal makes sound");
        return 1;
    }
}

// Child class
class Dog extends Animal1 {

    // 1) Same method signature
    // 2) Covariant return type (Integer is subclass of Number)
    // 3) More accessible (protected → public)
    // 4) Throws narrower checked exception (IOException → FileNotFoundException)
    // 5) Throws unchecked exception allowed
    @Override
    public Integer makeSound() throws FileNotFoundException {


        System.out.println("Dog barks");

        // unchecked exception (allowed)
        if (true) {
            throw new RuntimeException("Unchecked exception example");
        }

        // (unreachable, but for compilation)
         return 10;
    }
}

// Test class
 class TestOverride {
    public static void main(String[] args) throws Exception {
        Animal1 obj = new Dog(); // runtime polymorphism

        try {
            obj.makeSound();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }
    }
}

// static method hiding - not overriding
class Bear {
    public static void eat() {
        System.out.println("Bear is eating");
    }
    public void hello() {
        System.out.println("Hello from Bear");
    }
}


class Panda extends Bear {
    public static void eat() {
        System.out.println("Panda is chewing");
    }
    //public static void hello() {  // compile error (non static - static) and vice versa
      //  System.out.println("Hello from Panda");
    //}
    public static void main(String[] args) {
        eat();
    } }

/*
Polymorphism
1) only for methods -because method calls are resolved at runtime , sees object type
2) not for fields - field access is resolved at compile time, sees reference type
 */
class ArunK {
    public String name = "Arun";

    public void printName() {
        System.out.println(name);
    }
}
class Kumar extends ArunK {
    public String name = "Kumar";

    public void printName() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        ArunK arun = new ArunK();
        Kumar kumar = new Kumar();
        ArunK arunKumar = new Kumar(); // polymorphic reference
        arun.printName(); // Arun
        kumar.printName(); // Kumar
        arunKumar.printName(); // Kumar - method call resolved at runtime, sees object type (Kumar)

        System.out.println(arun.name); // Arun
        System.out.println(kumar.name); // Kumar
        System.out.println(arunKumar.name); // Arun No polymorphism for fields
    }
}
