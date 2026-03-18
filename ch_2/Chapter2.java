package ch_2;

public class Chapter2 {
    /*
     Unary operators :
     ! - used only with boolean
     ~ - Bitwise Complement , used with int, long, short, byte
     */
    public static void main(String[] args)
    {
        boolean isTrue = true;
        System.out.println(!isTrue); // Output: false

        int a=5;
        System.out.println(~a); // Output: -6
        /*
         Trick to find '~' of a number:
         1) multiply the number by -1
         2) subtract 1 from the result
         */
        int b=6;
        System.out.println(~b); // Output: -7  (6 x -1) - 1 = -6 - 1 = -7
    }
}
/*
int pelican = !5; // DOES NOT COMPILE
boolean penguin = -true;// DOES NOT COMPILE
boolean peacock = !0; // DOES NOT COMPILE
 */

/*
() -> valid in expression
[] -> Invalid
 */

/*
Floor and ceil

float f = 1.5f;
floor(f); // returns 1.0
ceil(f); // returns 2.0

float g= 1.1f;
floor(g); // returns 1.0
ceil(g); // returns 2.0

float h = 1.9f;
floor(h); // returns 1.0
ceil(h); // returns 2.0
 */


/*
Numeric promotion
1) byte, short, char -> int
2) double > float > long > int
3) ++, -- -> same type
 */
class Promotion {
    public static void main(String[] args) {
        byte b = 10;
        short s = 20;
        char c = 'A'; // ASCII value 65
        int i = 30;


        //byte + short
        //byte ans1= b+s; // NOT COMPILE  fix-> ans = (byte)(b+s);
        //short ans= b+s; // NOT COMPILE  fix-> ans = (short)(b+s);
        int ans= b+s; // Complies 30 (10 + 20 = 30)
        System.out.println(ans);

        //char + int
        //char ans2 = c+i; // NOT COMPILE  fix-> ans2 = (char)(c+i);
        int ans2 = c+i; // Complies 95 (ASCII value of 'A' is 65 + 30 = 95)
        System.out.println(ans2);

        byte f = ++b; // Valid , 11


        long l = 12234455665656L;
        //long l1 = (long)122344558886; // Doesn't compile


        /*
        Compound assignment operators:
        *=, /=, %=, +=, -=, <<=, >>=, &=, ^=, |=
        Advantage : can cast the result
         */
        long goat = 10;
        int sheep = 5;
        //sheep = sheep * goat; // DOES NOT COMPILE
        sheep *= goat; // COMPILES, internally => sheep = (int)(sheep * goat);
        System.out.println("Sheep "+sheep);


        /*
        Assignment operators:
        (x=something) -> returns the value assigned
         */
        boolean healthy = false;
        if(healthy = true)
            System.out.println("Good!");

       // System.out.println(null); // doesn't compile
        System.out.println(null == null); // true
    }
}

/*
Instance of operator
instanceof checks if an object is an instance of a class, subclass, or implements an interface.

Object class - Parent class of all classes in Java.
Every class in Java implicitly extends the Object class, so all classes are subclasses of Object.
Present in java.lang package.

Object obj = new String("Hello");
Left Object = Reference type (used by compiler)
Right String = Actual type (used at runtime)
 */


class InstanceOf {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str instanceof String); // true
        System.out.println(str instanceof Object); // true
        //System.out.println(str instanceof Integer); // DOES NOT COMPILE

        Object obj = new String("Hello");
        System.out.println(obj instanceof String); // true
        System.out.println(obj instanceof Object); // true
        System.out.println(obj instanceof Integer); // false

        Integer num = 10;
        System.out.println(num instanceof Integer); // true
        System.out.println(num instanceof Object); // true
        //System.out.println(num instanceof String); // DOES NOT COMPILE

        System.out.println("================================");

        //With null
        System.out.println(null instanceof Object); // false
        Object noObjectHere = null;
        System.out.println(noObjectHere instanceof String); // false
        //System.out.print(null instanceof null); // DOES NOT COMPILE

        //if true next steps are not reached
        int rabbit = 6;
        // left => right order
        boolean bunny = (++rabbit == 8) || (++rabbit==8) || (++rabbit == 7);
        System.out.println(rabbit);

    }
}
