package ch_4;

import java.util.Arrays;

public class StringBuilderTut {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        sb.append(" world");
        System.out.println(sb); // hello world

        sb.insert(5, ",");
        System.out.println(sb); // hello, world

        sb.delete(0,5);
        System.out.println(sb); //, world

        //sb.replce("world", "java"); // error: cannot find symbol
        sb.replace(2,6, "java");
        System.out.println(sb); //, javad
    }

    //String pool - a special area in memory where string literals are stored.
    // intern () - makes it to store in string pool
}

class Other{
    public static void main(String[] args) {
        String[] strings = { "stringValue" };
        System.out.println(strings[0]); // stringValue

        /*
        Arrays Comparing
        1) compare() -> compares element by element
        2) mismatch()
         */

        System.out.println("compare()");
        System.out.println(Arrays.compare(new int[] {1,2}, new int[] {2,9,9})); //-1
        System.out.println(Arrays.compare(new int[] {1,2}, new int[] {1,2})); //0
        System.out.println(Arrays.compare(new int[] {1,2}, new int[] {1,1})); //1
        System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"A"})); //32
        System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"aa"})); //-1
        System.out.println(Arrays.compare(new String[] {"a"}, new String[] {null})); //1
        System.out.println("mismatch()");
        System.out.println(Arrays.mismatch(new int[] {1,2}, new int[] {2,9,9})); //-1
        System.out.println(Arrays.mismatch(new int[] {1,2}, new int[] {1,2})); //0
        System.out.println(Arrays.mismatch(new int[] {1,2}, new int[] {1,1})); //1
        System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {"A"})); //32
        System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {"aa"})); //-1
        System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {null})); //1


        System.out.println(Math.round( 0.5));  //  1
        System.out.println(Math.round(-0.5));  //  0  ← not -1!
        //int  c = Math.round(3.5);    // ❌ won't compile — double returns long!
        System.out.println(Math.rint(1.4)); // 1.0
        Math.round(Double.NaN);            // 0
        Math.round(Double.POSITIVE_INFINITY); // Long.MAX_VALUE
        Math.round(Double.NEGATIVE_INFINITY); // Long.MIN_VALUE

    }
}





