package ch_1;
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

