package ch_5.method_access.pkg1;

public class Android {
    public static void main(String[] args) {
        MainIphone iphone = new MainIphone();
        System.out.println("Accessing fields:");
        System.out.println("Public Name: " + iphone.publicName);
        System.out.println("Protected Name: " + iphone.protectedName);
        System.out.println("Default Name: " + iphone.defaultName);
        //System.out.println("Private Name: " + iphone.privateName); // Not accessible -
        System.out.println("\nAccessing methods:");
        iphone.publicMethod();
        iphone.protectedMethod();
        iphone.defaultMethod();
        //iphone.privateMethod(); // Not accessible - will cause a compile-time error
    }
}
