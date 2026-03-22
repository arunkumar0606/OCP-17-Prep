package ch_7;

public class NestedClasses {
}
/*
Four types
1. Inner class
2. Static nested class
 */

/*
1) Inner nested class
Inner class can be any access modifier
Inner class can access out class's variables
 */
class A {
    private int out=5;

    private class B{
        private int value=out+50;

        private void hello(){
            System.out.println("Im from inner class");
        }
    }
    private void getValue(){
        B b = new B();
        System.out.println(b.value);
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.out);
        a.getValue();

        //accessing inner class
        B b = new A().new B();
        b.hello();
    }
}

/*
2) Static nested class
 can call directly using inner class name
 no need of outer instance
 */
class C {
    private int age=45;
    private static String lastName= "kumar";
    static class D{
        private String name = "Arun " + lastName;
        private void some(){
            //System.out.println(age); // invalid
            System.out.println(lastName);
        }
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.name);
        d.some();
    }
}

/*
3) Local class
final or abstract
 */

class E {
    private final int base=5;
    public void cal(){
        final int mm = 5;
        class Omg{
            String name;
            public Omg(String name){
                this.name=name;
            }
            public void what(){
                System.out.println(base +name+ mm);
            }
        }
        Omg a = new Omg("Arun");
        a.what();
        Omg b= new Omg("kuamr");
        b.what();
    }

    public static void main(String[] args) {
        E e = new E();
        e.cal();
    }
}

/*
4) Anonymous inner class
 */
class Phone{
    abstract class Mobile{
        abstract void charge();
    }

    public void some(){
        Mobile m = new Mobile() {
            @Override
            void charge() {
                System.out.println("omg whats going on..");
            }
        };
        m.charge();
    }

    public static void main(String[] args) {
        Phone p = new Phone();
        p.some();
    }
}

interface Shit{
    void well();
}

class Ok{
    public static void main(String[] args) {
        Shit s= new Shit() {
            @Override
            public void well() {
                System.out.println("Holy shit!! ");
            }
        };
        s.well();
    }
}