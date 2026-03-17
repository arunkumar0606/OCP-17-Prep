package ch_1;

/*
PRIMITIVES
byte<short<int<long
float<double
boolean
char
 */

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
        System.out.println("byte: " + dt.b);
        System.out.println("short: " + dt.s);
        System.out.println("int: " + dt.i);
        System.out.println("long: " + dt.l);
        System.out.println("float: " + dt.f); // doesn't print f at the end
        System.out.println("double: " + dt.d);
        System.out.println("boolean: " + dt.bo);
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

    public static void main(String[] args) {
        System.out.println("String to Integer using valueOf: " + iObj);
        System.out.println("String to int using parseInt: " + parsedInt);
    }
}
