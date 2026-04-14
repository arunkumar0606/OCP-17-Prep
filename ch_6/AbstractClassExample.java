package ch_6;

public class AbstractClassExample {
}
/*
1) Cannot directly create using new keyword new Company() X
2) No Body just declaration
3) private abstract not possible
4) final abstract not possible
5) static abstract not possible
6) return type - covariant rule
7) Access specifiers follow same - top close , bottom wide
8) At least one abstract method is optional not mandatory
9) abstract class - public / default
10) abstract method -public/default/protected
11) abstract class can have constructors
 */
abstract class Company {

    int targetYear;

    public Company(int name){
        targetYear=name;
    }
    abstract CharSequence currentJob();

    public void getOpenings() {
        System.out.println(currentJob());
    }
}

class Zuci extends Company{
    public Zuci(int yr){
        super(yr);
    }
    @Override
     public String currentJob(){
        return "Java,Microservices";
    }
}

class Acc extends Company{
    public Acc(int yr){
        super(yr);
    }
    @Override
    public String currentJob(){
        return "React js , next js";
    }
}

class Something{
    public static void main(String[] args) {
        Zuci zuci = new Zuci(2026);
        zuci.getOpenings();
        System.out.println(zuci.targetYear);
        Acc acc=new Acc(2025);
        acc.getOpenings();
        System.out.println(acc.targetYear);

    }
}

//First non-concrete class should implement all abstract method
//here Tourist should implement both hola and hello
abstract class France{
    abstract void hola();
    abstract void hehe();
}
abstract class English extends France{
    abstract void hello();
    void hehe(){
        System.out.println("haha");
    }
}
class Tourist extends English{
    @Override
    void hello() {
        System.out.println("hello in english");
    }
    @Override
    void hola() {
        System.out.println("Hola in france");
    }
    public static void main(String[] args) {
        Tourist t= new Tourist();
        t.hello();
        t.hola();
        t.hehe();
    }
}


/*
Creating immutable class
Defensive copy
 */
class Balance {
    private int amount;

    public Balance(int amount){
        this.amount=amount;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

final class Account{
    private final String name;
    private final Balance balance;

    public Account(String name, Balance b){
        this.name=name;
       // this.balance = b; //eligible for #1  -> shallow copy
        this.balance=new Balance(b.getAmount()); // prevents #1   -> deep copy
    }

    public String getName() {
        return name;
    }

    public Balance getBalance() {
       // return balance; // eligible for #2
        return new Balance(balance.getAmount());  //prevents #2
    }

}

class Testing{
    public static void main(String[] args) {
        System.out.println("---Before modification---");
        Balance b= new Balance(1000);
        Account a= new Account("arun",b);
        System.out.println(a.getName());
        System.out.println(a.getBalance().getAmount());
        System.out.println("---After modification---");
        b.setAmount(0);  // #1 modification
        a.getBalance().setAmount(100); //#2 modification
        System.out.println(a.getName());
        System.out.println(a.getBalance().getAmount());
    }
}