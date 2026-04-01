package ch_4;

public class Chapter4 {
    public static void main(String[] args) {
        /*
        STRING class
         */
        String s = "hello";
        String s2 = new String("hello1");
        String s3 = """
                hello
                 ak""";
        //System.out.println(s); // hello
        //System.out.println(s2); // hello1
        //System.out.println(s3); // hello
                                    //ak

        //Concatenation
        // number + number = number
        // String + number = String
        /*
        System.out.println(1 + 2); // 3
        System.out.println("a" + "b"); // ab
        System.out.println("a" + "b" + 3); // ab3
        System.out.println(1 + 2 + "c"); // 3c
        System.out.println("c" + 1 + 2); // c12
        System.out.println("c" + null); // cnull
         */

        //String methods

        /*
        length()
        charAt()
        toUpperCase()
        toLowerCase()
        equals()
        equalsIgnoreCase()
        startsWith() - true/false
        endsWith() - true/false
        replace()
        replaceAll()
         */
        //1 Index of
        // -1 if not found
        String s4= "hello world";
        s4.indexOf('o'); // 4
        s4.indexOf('o', 5); // 7
        s4.indexOf("world"); // 6
        s4.indexOf('a'); // -1

        // substring(include,before);
        //substring(start);
        s4.substring(6); // world
        s4.substring(0,5); // hello
        s4.substring(2,5); // llo
        s4.substring(2,2); // empty string
        //s4.substring(4,2); // StringIndexOutOfBoundsException

        System.out.println(s4.contains("llo")); //true

        String name = "aarun kumar";
        System.out.println(name.replace('a','b')); // bbrun kumbr
        System.out.println(name.replace("aa","b")); // brun kumar

        /*
        Removing white spaces
        trim()- old trim() removes characters with ASCII value ≤ 32 [' ', '\t', '\n', '\r', '\f']
        strip() - new includes Unicode spaces
         */

        String ab = "\u2003omg\u2003";
        System.out.println(ab.trim()); // omg
        System.out.println(ab.strip()); //omg

        /*
        Indent () and StripIndent() - working with multi-line strings
         */
        /*
        Indent() - adds additional '\n' at end
        - positive value adds spaces at the beginning of each line [each line]
        - negative value removes spaces at the beginning of each line [each line]
        - 0 does nothing
         */

        var ans = "arun";
        System.out.println(ans.length()); //4
        System.out.println(ans.indent(1).length()); // 6 " " at start , '/n' at end
        System.out.println(ans.indent(-1).length()); // 5 '/n' at end

        System.out.println("----------------------------------");
        String mul = "arun \n kumar";
        System.out.println(mul+mul.length());
        System.out.println(mul.indent(5)+mul.indent(5).length());
        System.out.println(mul.indent(-1)+mul.indent(-1).length());

        System.out.println("----------------------------------");
        var concat = " a\n"
                    +"  b\n"
                    +" c";
        System.out.println(concat);
        System.out.println(concat.length());
        System.out.println(concat.indent(-4));


        //StripIndent() - removes common leading spaces from each line
        //No additional '\n' is added at the end
        String see = "    Hello\n      World\n  Java";
         //           ^^^^        ^^^^^^      ^^  → common is 2 spaces
        //Removes 2 spaces

        //TranslateEscapes() - converts escape sequences to their actual characters
        String s7 = "Name:\\tArun\\nCity:\\tChennai";

        System.out.println(s7);
        System.out.println("---");
        System.out.println(s7.translateEscapes());

        //isBlank() - true if string is empty or contains only white spaces
        //isEmpty() - true if string is empty [length is 0]

        String umm = "   ";
        //System.out.println(umm.isBlank()); // true
        //System.out.println(umm.isEmpty()); // false

        // String formatting
        //"arun" + "kumar"  >  "arun" + variable  >  String.format()  =  .formatted()
        //     fastest                                                        slowest

    }
}
