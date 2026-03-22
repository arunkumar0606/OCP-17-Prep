package ch_7;


/*
 ; at end optional
 public / package access
 implicitly final - so protected not possible (no inheritance)
 cannot extend enum
 contains few methods - ordinal(), values(),valueOf()
 */
enum Skills{
    JAVA,SPRING_BOOT,REACT;
}
/*
public final class Skills extends Enum<Skills> {
    // name    = exact string you wrote ("JAVA", "SPRING_BOOT", "REACT")
    public static final Skills JAVA        = new Skills("JAVA", 0);
    public static final Skills SPRING_BOOT = new Skills("SPRING_BOOT", 1);
    public static final Skills REACT       = new Skills("REACT", 2);
    }
  */

//All enum should implement the abstract method
// Enum can implement from interface
interface Caller{
     void who();
}
enum Api implements Caller{

    SUCCESS("200") {

        @Override
        public String getStatus(){
            return "Success boy!";
        }
    },
    FAILURE("400"){

        @Override
        public String getStatus(){
            return "Oh no boy!";
        }
    };
    private final String code;
    Api(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public  abstract String getStatus();

    public void who(){
        System.out.println("Implemented from interface");
    };
}

public class EnumExample {
    public static void main(String[] args) {

        System.out.println(Api.SUCCESS.getCode());
        System.out.println(Api.FAILURE.getStatus());
        Api.SUCCESS.who();
        Api.FAILURE.who();

        for (var s : Skills.values()){
            System.out.println(s + " : "+s.name()+ " : "+ s.ordinal() );
        }
    }

}


/*
SEALED CLASSES
Extending class  - sealed , non-sealed , final
sealed keyword at start
abstract allowed
 */

final class Dummy extends Java{}

sealed abstract class Back_end permits Java,SpringBoot,Sql {}

// here permits is made optional - permits Dummy [mandatory when in different file]
sealed class Java extends Back_end {}

final class SpringBoot extends Back_end {}

non-sealed class Sql extends Back_end {}

//class React extends Backend{} - doesn't compile

/*
SEALED Interfaces
sub interfaces can be sealed / non-sealed only ... not final
 */

sealed interface Front_end permits React,Angular{}

non-sealed interface React extends Front_end{}

final class Angular implements Front_end{};
