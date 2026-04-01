package ch_1;

/*
PRIMITIVES
byte<short<int<long
float<double
boolean
char
 */

import java.util.List;

// Local variables do not have default values, they must be initialized before use
public class Data_Types {
    byte b;
    short s;
    int i;
    long l;
    double d;
    float f;
    boolean bo;
    char c;
    public static void main(String[] args) {
        Data_Types dt = new Data_Types();
        System.out.println("Default values of primitives");
        System.out.println("byte: " + dt.b); //0
        System.out.println("short: " + dt.s); //0
        System.out.println("int: " + dt.i); //0
        System.out.println("long: " + dt.l); //0
        System.out.println("float: " + dt.f); //0.0 doesn't print f at the end
        System.out.println("double: " + dt.d); //0.0
        System.out.println("boolean: " + dt.bo); // false
        System.out.println("char " +String.format("\\u%04x", (int) dt.c));  // \u0000
    }
}
/* DEFAULT CHAR VALUE
char c1 = '\u0000';
char c2 = 0;
System.out.println(c1 == c2);  // true
 */

/*
float -> f or F
long -> l or L
Literal -> Literals are fixed values written directly in the code.
 */

/*
Literal rules "_":
1) no start
2) no end
3) no before or after decimal point
4) Not before/after suffix
5) Not in octal, hexadecimal, binary literals
 */

class Special {
    int oct = 017; // octal literal, 017 is 15 in decimal
    int hex = 0x1A; // hexadecimal literal, 0x1A is 26 in decimal
    int bin = 0b1010; // binary literal, 0b1010 is 10 in decimal
    int a= 10000__0;
    double b = 1_0_0.50;

    public static void main(String[] args) {
        Special s = new Special();
        System.out.println("Octal: " + s.oct);
        System.out.println("Hexadecimal: " + s.hex);
        System.out.println("Binary: " + s.bin);
        System.out.println("a: " + s.a);
        System.out.println("b: " + s.b);
    }
}


class Conversion{
    // String to Integer -> ValueOf
    static String str1 = "123";
    static Integer iObj = Integer.valueOf(str1);

    // String to int -> Parsing
    static String str = "123";
    static int parsedInt = Integer.parseInt(str); // Parsing

    static String weird = "1_23";
//    static Integer i1= Integer.valueOf(weird); //error
//    static int i2= Integer.parseInt(weird);   //error


    public static void main(String[] args) {
        System.out.println("String to Integer using valueOf: " + iObj);
        System.out.println("String to int using parseInt: " + parsedInt);
    }
}


class Strings{
    public static void main(String[] args) {

        //String t = """arun""";  // invalid """ should be first line nothing else required at start
        String s = """
                arun
               kumar
               """;
        System.out.print(s);
        System.out.println("------------------");
        String d = """
                arun \
                kumar
                """;
        System.out.print(d);

        String block = """
                "doe\"\"\"
                \"deer\"""
                """;
        System.out.print("*"+ block + "*");
    }
}

/*
VARIABLE NAME RULES
1) start/end with letter, $ or _
2) No start with digit
3) can contain letters, digits, $ and _
4) cannot be a reserved keyword
5) cannot have single '_'
 */

class VariableNames {
    static int _var_ = 10;
    static int $var$ = 20;
    static int var3__= 30;
    // INVALID:  2var, var-1, var 1, _ (single underscore)


    /*
    Declaring multiple variables in a single line
     */
    int a=10,b=10;
    int c=10,d;
    int e=10;int f=10;

    // int c=10,int d=10; -> invalid
    // int c=10;d=10; -> invalid

    public static void main(String[] args) {
        System.out.println("_var1: " + _var_);
        System.out.println("$var2: " + $var$);
        System.out.println("var3: " + var3__);
    }
}


/*
Local variables : Must be initialized before use, no default values
Reason : These are stored in stack and not heap . May give incorrect values if not initialized
 */

class LocalVariables {
    public static void main(String[] args) {
        int localVar; // Declaration without initialization
        //System.out.println(localVar);  // Error: variable localVar might not have been initialized

        localVar = 10; // Initialization
        System.out.println("Local variable value: " + localVar); // Output: Local variable value: 10
    }
}


/*
VAR keyword -> works only when declaring local variables inside methods, blocks, or loops
 */

class VarKeyword {
    public static void main(String[] args) {
        var num = 10; // Inferred as int
        var list = List.of(1, 2, 3); // Inferred as List<Integer>
        //var str =null; // Compile Error
        System.out.println("num: " + num);
        for(var item : list) {
            System.out.println("item: " + item);
        }
    }
}


/*
System.gc() -> does not guarantee gc
 */

class Test {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = t1;

        t1 = null; // object NOT eligible for GC
        //t2 points to t1 object
    }
}