package ch_5.method_access.pkg2;

import ch_5.method_access.pkg1.MainIphone;

public class Windows {
    public static void main(String[] args) {
        MainIphone iphone = new MainIphone();
        // Accessing fields
        System.out.println("Accessing fields:");
        System.out.println("Public Name: " + iphone.publicName);
        // System.out.println("Protected Name: " + iphone.protectedName); // Not accessible
        // System.out.println("Default Name: " + iphone.defaultName); // Not accessible
        // System.out.println("Private Name: " + iphone.privateName); // Not accessible

        iphone.publicMethod();
       // iphone.defaultMethod(); //not in same package
    }
}

class Windows2 extends MainIphone {
    public static void main(String[] args) {
        Windows2 windows2 = new Windows2();
        // Accessing fields
        System.out.println("Accessing fields:");
        System.out.println("Public Name: " + windows2.publicName);
        System.out.println("Protected Name: " + windows2.protectedName); // Accessible because

        windows2.publicMethod();
        windows2.protectedMethod(); // Accessible because Windows2 is a subclass of Iphone
    }
}