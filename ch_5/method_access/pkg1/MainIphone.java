package ch_5.method_access.pkg1;

public class MainIphone {

    private String privateName = "Arun";
    String defaultName = "Arun";
    protected String protectedName = "Arun";
    public String publicName = "Arun";


    //final int age; //must be initialized at declaration or in constructor
    final int age=5; //initialized at declaration
    final int age2;
    {age2=10;} //initialized in instance initializer block
    final int age3;

    public MainIphone() {
        age3=15; //initialized in constructor
    }



    //Accessible from anywhere
    public void publicMethod() {
        System.out.println("public Method 1");
    }
    //Accessible only within the class
     private void privateMethod() {
        System.out.println("private Method 2");
    }
    //Accessible within the package and by subclasses
     protected void protectedMethod() {
        System.out.println("protected Method 3");
    }

    //package-private" or "default access"
    void defaultMethod() {
        System.out.println("default Method 4");
    }

    //Not possible in classes, only in interfaces
//    default void defaultMethod2() {
//        System.out.println("default Method 5");
//    }


    // final static public - can be in any order

    final static public void main1(String[] args) {
        System.out.println("Hello");
    }
    static public final void main2(String[] args) {
        System.out.println("Hello");
    }
    public final static void main4(String[] args) {
        System.out.println("Hello");
    }
}
