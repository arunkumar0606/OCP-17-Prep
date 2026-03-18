package ch_3;

public class Chapter3 {
    public static void main(String[] args) {
        //Rule 1 : Only 1 line is possible without curly braces
        int a=5;
        int b=6;
        if(a<4)
            a++;
            b++;   //not part of if block
        System.out.println(b);  //7

        // 0 & 1 or not booleans
        //if(1){} -> DOES NOT COMPILE

        /*
        Pattern matching with if and instanceof - Java 16
        Cannot match with same type or super type
         */
         /*
        RULES:
        1) Scope is within block
        2) Cannot have expression in same if block with ||
         */
        Number num = 10; // can be Integer, Double, etc.
        if (num instanceof Integer i) {
            System.out.println(i.compareTo(17)); //-1
        }
    }
}

/*
Switch statement: RULES
1) Combine case using ',' operator
2) No duplicate cases
3) break is opt , without it all cases after the match will execute
4) default is opt , if not present switch is ignored on no match
5) default can be anywhere in the switch block
6) case values should be constant - final
7) Supported cases : byte, short, char, int, String, enum , var, wrapper classes of byte, short, char, int
 */
class SwitchStatement{
        public static void main(String[] args) {
            int day = 1;
            final int one =1;
            switch (day) {
                default:
                    System.out.println("Weekend");
                    break;
                case one:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 5:
                    System.out.println("Thursday or Friday");
                    break;
            }
        }
}


/*
Switch expression: RULES
1) default is required , only for enum opt (opt is value is not returned / stored in variable)
2) case values should be constant - final
3) Using blocks ? use yield to return value
4) No need of break as it does not fall through
5) Each case should return a value matching the return type
 */

class SwitchExpression{
    public static void main(String[] args) {
        int day = 3;
        final int one =1;
        String result = switch (day) {
            case (one)-> {yield "Monday";} //valid use yield when blocks are used
            case 2 -> "Tuesday";
            case 3 -> {if(3*2>5) yield "Wednesday"; else yield "Not Wednesday";}
            case 4,5 -> "Thursday or Friday";
            default -> "Weekend";
        };
        System.out.println(result); // Monday

    }
}

class Loops{
        public static void main(String[] args) {
            //for loop
            /*
            RULES:
            1)we cannot use same variable name in initialization and update part of for loop
            2) we cannot have 2 different variables in initialization and update part of for loop
             */
            for(int i=0;i<5;i++){
                System.out.println(i);
            }
            for(int i=0;i<5;++i){
                System.out.println(i);
            }
            //above loops are same as ++i and i++ have same effect in for loop



        }
}

/*
Labels:
break - used to exit from a loop or switch block
continue - used to skip current iteration of a loop
can be used with while, do-while, for loops and switch statements
 */
class Labels {
    public static void main(String[] args) {
        myBlock:
        {
            System.out.println("Inside block");

            if (true) break myBlock;

            System.out.println("This will NOT print");
        }

        System.out.println("Outside block");
    }
}