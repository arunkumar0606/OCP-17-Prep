package Ch_12;

/*
Modules
 */
public class Example {
    /*
    -m -> module name
    -p -> module path
     */

//    module zoo.animal.care {
//         exports zoo.animal.care.medical;
//         requires zoo.animal.feeding;
//         exports zoo.animal.talks.content to zoo.staff;
//         requires transitive zoo.animal.care;
//         opens zoo.animal.talks.schedule;   -> allows to use reflection
//         opens zoo.animal.talks.media to zoo.staff;
//         }

    /*
    A service is composed of an interface, any
classes the interface references, and a way of looking up implementations of the interface.
ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);

module zoo.tours.reservations {
exports zoo.tours.reservations;
requires zoo.tours.api;
uses zoo.tours.api.Tour;
}
     */


    /*
    Types of modules
    1)Named module
    A named module is one containing a module-info.java file.
    2)Automatic modules
    An automatic module appears on the module path but does not contain a module-info.java file.
    3)Unnamed module
    An unnamed module appears on the classpath. Like an automatic module, it is a regular JAR.
     */
}
