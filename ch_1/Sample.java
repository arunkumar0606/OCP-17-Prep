package ch_1;
import java.util.*;
import java.util.List;
//Public Class name should be same as file name --> Sample.java else Doesnt' compile
public class Sample {
   public static void main( String []  args) {
        //single line comment

        /*
        Multi line comment
         */

        /**
         * javadoc comment
         *@author arun
         */

        // run args -> "arun kumar" kumar
        //line 1:System.out.println(args[0]); -> arun kumar
        //line 2: System.out.println(args[1]); -> kumar
        // run args -> kumar
        // line1: kumar
        // line2 : Error -> arrayindexoutofbound

        System.out.println("Hello");
    }
}

/*
Main Method rules :
1) public , static , void - MUST
2) Order of public , static - can change
3) String[] args - can be represented in different ways
4) public final static void main(final String[] args) {} - Possible
 */



//Imports use wildcard "*" -> only classes

class Imports{
    /*
    import java.util.*.*; -> invalid
    Explicit import > wildcard import
     */

    public static void main(String[] args) {
        List<String> ls= List.of("Arun");
        System.out.println(ls.get(0));
    }
}

class InstanceInitializer{
    private int age=0;
    {age=15;}
    public static void main(String[] args) {

        InstanceInitializer instanceInitializer1 = new InstanceInitializer();
        instanceInitializer1.age=10;
        System.out.println(instanceInitializer1.age);  //10

        InstanceInitializer instanceInitializer2 = new InstanceInitializer();
        System.out.println(instanceInitializer2.age);  //15
    }
}
