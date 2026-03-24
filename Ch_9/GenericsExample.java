package Ch_9;

public class GenericsExample {
}
/*
Generics
E -> element
K , V -> map key,value
T -> common generic type
N -> number
<T> is required in method return types
 */
class PrintAnything{
    public static <T> void printBro(T some){
        System.out.println(some);
    }
}
class Mmm{
    public static void main(String[] args) {
        PrintAnything.printBro(1);
        PrintAnything.printBro("arun");
        PrintAnything.printBro(100.0);

    }
}

class Truck<T>{
    private T load ;

    public void setLoad(T load){
        this.load = load;
    }

    public void startJourney(){
        System.out.println("Staring the truck with the load : "+load);
    }
}
class Concrete{
    @Override
    public String toString(){
        return "Concretes..";
    }

}
class Bricks{
    @Override
    public String toString(){
        return "Bricks..";
    }
}
class Customer{
    public static void main(String[] args) {
        Concrete concrete = new Concrete();
        Bricks bricks = new Bricks();
        Truck<Concrete> concreteTruck = new Truck<>();
        concreteTruck.setLoad(concrete);
        concreteTruck.startJourney();

        Truck<Bricks> bricksTruck = new Truck<>();
        bricksTruck.setLoad(bricks);
        bricksTruck.startJourney();

    }
}

//Generic interface also possible
interface  Some <T>{
    public T hello();
}

//Generics can be used with records
/*
Bounding generics
? - wildcard
? extends something -> ? subclass of something
? super something -> ? super class of something
 */