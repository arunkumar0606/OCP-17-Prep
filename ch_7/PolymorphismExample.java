package ch_7;

public class PolymorphismExample {
}
/*
Reference object : decides which fields and methods are accessible
Object type : refers which object is in memory
 */
class Front {
    public void frontMethod(){
        System.out.println("front babs..");
    }
}

interface Back{
    void backMethod();
}

class Moo extends Front implements Back{

    int age=25;
    @Override
    public void backMethod() {
        System.out.println("back baby...");
    }

    public static void main(String[] args) {
        System.out.println("--moo reference --");
        Moo m = new Moo();
        m.backMethod();
        m.frontMethod();
        System.out.println(m.age);

        System.out.println("--front reference --");
        Front f= new Moo();
        f.frontMethod();

        System.out.println("--back reference ---");
        Back b = new Moo();
        b.backMethod();


        //Casting objects
        Moo moo = new Moo(); // normal cast
        Front front = moo;

        Moo moo2 = (Moo) front; // possible
        //Moo moo3 = front ;  - compile error
        Moo moo3 = (Moo) b; // possible



    }
}

//in case of interface it will throw error at run time
interface Canine {}
interface Dog {}
class Wolf implements Canine {}

class BadCasts {
public static void main(String[] args) {
       Wolf wolfy = new Wolf();
       Canine cn = (Canine) wolfy; // allowed
       Dog badWolf = (Dog)wolfy;  //unrelated -> compiles but exception at runtime
}
}

// instance of operator
class Bird {}
class Fish {
    public static void main(String[] args) {
        Fish fish = new Fish();
       // if (fish instanceof Bird b) { // DOES NOT COMPILE
// Do stuff
        }
    }


//output 3
class Penguin {
    public static int getHeight() { return 3; }
    public void printInfo() {
        System.out.println(this.getHeight());
    }
}
 class CrestedPenguin extends Penguin {
    public static int getHeight() { return 8; }
    public static void main(String... fish) {
        new CrestedPenguin().printInfo();
    }
}

//polymorphism example
//keep eye on static methods

class Sun{
    int temp = 2000;
    public void produces(){
        System.out.println("Heat");
    }
    public static void staticProduces(){
        System.out.println("HEAT");
    }
}
class Moon extends Sun{
    int degree=-1;
    public  void produces(){
        System.out.println("Coolness");
    }
    public static void staticProduces(){
        System.out.println("COOL");
    }

    public static void main(String[] args) {
        Sun s = new Sun();
        s.produces();//heat
        s.staticProduces(); //HEAT
        System.out.println(s.temp);

        Sun s1 = new Moon();
        s1.produces(); //coolness
        s1.staticProduces(); // HEAT
        System.out.println(s.temp); //polymorphed at runtime
        //System.out.println(s.degree); //not accesible

        Moon m = new Moon();
        m.produces(); //coolness
        System.out.println(m.degree);
        System.out.println(m.temp);
        m.staticProduces(); //COOL

    }
}