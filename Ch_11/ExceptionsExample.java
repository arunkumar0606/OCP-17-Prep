package Ch_11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//throws can be added even when no exception is thrown in the method
//Exception is a object and can be stored in a variable
public class ExceptionsExample {
    public static void hello() throws IOException {
        System.out.println("hello..");
        var e = new IOException();
        System.out.println(e.getClass());
        throw e;
    }

    public static void main(String[] args) throws IOException {
        hello();
    }
}
//new keyword is needed
//checked exception must be handled
class Sample{
    public static void main(String[] args) {
       // throw new RuntimeException();  //valid
        //throw RuntimeException();  // requires new keyword - doesn't compile
        try{
            throw new IOException();
            //throw new ArithmeticException();  //Doesn't  compile -> unreachable
        }catch (Exception e){
            System.out.println("Caught...");
        }
    }
}

//IF method doesn't throw checked exception it cant be caught
class Example {
    private static void asus() {
        System.out.println("asus..");
    }

    public static void main(String[] args) {
        // try{
        asus();
//        }catch (IOException e ){  //doesn't compile
//            System.out.println("somehing");
//        }
        // }
    }
}
/*
Checked exceptions
FileNotfoundException
NotSerializableExcpetion 
Ioexception

 */

/*
Exceptions with method overriding
1) Cant introduce new exception / higher exception in subclass
2) Can remove or lower exception in subclass
3) Special case -> can introduce Runtime Exceptions
 */

class Exam{
    public void test(){}
    public void examine() throws IOException {}
    public void copy() throws Exception {}
}
class Student extends Exam{
    // public void test() throws IOException { -> not possible
    // public void test() throws NullPointerException { -> possible
    public void test() throws NullPointerException{
        System.out.println("testing");
    }
    //public void examine() throws Exception {  -> not possible
    public void examine() throws IOException {
        System.out.println("examining .. ");
    }
    //public void copy()  { -> possible
    public void copy() throws IOException {
        System.out.println("copying .. ");
    }
}

/*
Runtime exceptions
Arithmetic
StringIndexoutofbound
classcast
nullpointer
IllegelArgument
Numberformat
 */
class Some{
    public static void main(String[] args) {
        int s = Integer.parseInt("10_0");
    }
}

/*
order od exception -> subclass ->parent class
 */
class Simple {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("file.txt");
            //Correct order — specific to general
        } catch (FileNotFoundException e) {   // subclass of IOException
            System.out.println("File not found");
        } catch (IOException e) {             // superclass
            System.out.println("IO error");
        } catch (Exception e) {               // root of all checked
            System.out.println("Some exception");
        }catch (Throwable e) {               // root of all everything
            System.out.println("Some exception");
        }

        //Doesn't compile
//        try {
//            FileReader fr = new FileReader("file.txt");
//            //Correct order — specific to general
//        } catch (Exception e) {   // Superclass
//            System.out.println("File not found");
//        } catch (IOException e) {  // subclass
//            System.out.println("IO error");
//        }

        //Combined catch should have unrelated exceptions
        //below doesn't compile
//        try {
//            throw new IOException();
//        } catch (FileNotFoundException | IOException p) {} // DOES NOT COMPILE
        // }

        //try-finally possible
        try {
            System.out.println("ohh");
        } finally {
            System.out.println("hmm");
        }
    }
}

class Ok{
    public static int getNum(int x){
        try{
            if(x>6) {
                throw new IOException();
            }
            System.out.print("1 ");
            return 1;
        }catch (IOException e){
            System.out.print("2 ");
            return 2;
        }finally {
            System.out.print("3 ");
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println("Returned : "+getNum(5)); //  1 3 Returned : 3
        System.out.println("Returned : "+getNum(7)); // 2 3 Returned : 3
    }
}


