package ch_1;
import java.util.List;
//Public Class name should be same as file name --> Chapter1.java else Doesnt' compile
public class Chapter1 {
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

/*
can modify instance across all objects
 */
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

/*
Order of instance init block
 */
/* OP
static 1
static 2
main 1
Ins 1
Cons 1
main 2
 */
class InstanceInitOrder{
    {
        System.out.println("Ins 1");
    }
    static {
        System.out.println("static 1");
    }
    static {
        System.out.println("static 2");
    }
    public InstanceInitOrder(){
        System.out.println("Cons 1");
    }
    public static void main(String[] args) {
        {
            System.out.println("main 1");
        }
        InstanceInitOrder instanceInitOrder=new InstanceInitOrder();
        {
            System.out.println("main 2");
        }
    }
}

