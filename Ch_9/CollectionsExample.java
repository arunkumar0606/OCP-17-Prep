package Ch_9;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        System.out.println("arun".compareTo("arun")); //0
        System.out.println("arun".compareTo("brun")); //-1
        System.out.println("brun".compareTo("arun")); //1
    }
}
//Comparable interface
class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override // by age then by name
    public int compareTo(Student o) {
        int ageSame = this.age - o.age;
        if(ageSame!=0){
            return ageSame;
        }
        return this.name.compareTo(o.name);
    }
    @Override
    public String toString(){
        return this.age+":"+this.name;
    }
}
class Test{
    public static void main(String[] args) {
        Student s1= new Student("Arun",25);
        Student s2 = new Student("AK", 22);
        Student s3 = new Student("BK", 22);

        List<Student> ls  = Arrays.asList(s1, s2,s3);  //[22:AK, 22:BK, 25:Arun]
        Collections.sort(ls);
        System.out.println(ls);
    }
}

/*
Comparator
 */

class Sample1{
    public static void main(String[] args) {
        Comparator<Student> compareByAge = (a,b) -> b.getAge() - a.getAge();
        Comparator<Student> compareByName = (a,b) -> a.getName().compareTo(b.getName());
        Comparator<Student> compareByAgeThenName = (a,b) ->{
            if(a.getAge() - b.getAge() ==0){
                return a.getName().compareTo(b.getName());
            }
            return  a.getAge() - b.getAge();
        };

        Student s1= new Student("Arun",25);
        Student s2 = new Student("AK", 22);
        Student s3 = new Student("BK", 22);

        List<Student> ls  = Arrays.asList(s1, s2,s3);
        Collections.sort(ls,compareByAge); //[25:Arun, 22:AK, 22:BK]
        Collections.sort(ls,compareByName); //[22:AK, 25:Arun, 22:BK]
        Collections.sort(ls,compareByAgeThenName); // [22:AK, 22:BK, 25:Arun]

        System.out.println(ls);
     }
}

