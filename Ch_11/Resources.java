package Ch_11;


import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
/*
try-with-resources
1) should have semicolon between resources
2) catch and finally are optional
3) Parameter can accept final / effectively final
4) var is allowed
 */
public class Resources {
    public static void main(String[] args) throws Exception {
        try(var in = new FileReader("Ch_11/Hello.txt")){
            int c=0;
            while((c=in.read())!=-1){
               System.out.print((char)c);
           }
        }

    }
}

//3)Custom class should implement Closable / autoCloseable interface
class Omg implements Closeable {

    @Override
    public void close() {
        System.out.println("closed bro");
    }
}
class Samplee{
    public static void main(String[] args) {
        try(Omg a = new Omg()){
            System.out.println(a);
        }
    }
}

//order of closing : parameter to first
/* OP
Try Block
Closing: 2
Closing: 1
Catch Block
Finally Block
 */
class MyFileClass implements AutoCloseable {
    private final int num;
    public MyFileClass(int num) { this.num = num; }
    @Override public void close() {
        System.out.println("Closing: " + num);
    } }
class Hmm {
    public static void main(String... xyz) {
        try (MyFileClass bookReader = new MyFileClass(1);
             MyFileClass movieReader = new MyFileClass(2)) {
            System.out.println("Try Block");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Catch Block");
        } finally {
            System.out.println("Finally Block");
        }
    }
}

/*
Formatting
NumberFormat
DateTimeFormatter
 */
class Oho{
    public static void main(String[] args) {
        //Decimal format -> # -> put value or ignore
        // 0 -> put value  or 0
        NumberFormat f1= new DecimalFormat("####.00");
        NumberFormat f2= new DecimalFormat("$00,0000.00#");
        System.out.println(f1.format(1234.5)); //1234.50
        System.out.println(f2.format(1234)); // 00,1234.00

        //M->1 MM->01 MMM->jan MMMM->january
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("'This code was written at ' ha 'on' d'st' MMMM y");
        System.out.println(dt.format(dtf));  //both works
        System.out.println(dtf.format(dt));
        //DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("'This is YYYY'"); //doesn't print year
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("'This is 'YYYY' '"); // print year
        System.out.println(dtf2.format(dt));

    }
}

/*
CompactNumberFormat - java 17 introduced
 */
class International{
    public static void main(String[] args) throws ParseException {
        Locale locale = Locale.getDefault();
        System.out.println(locale); //en_IN [language(lowercase)_location(uppercase)]
        System.out.println(Locale.GERMAN); //de
        System.out.println(Locale.GERMANY); //de_DE

        //We can create custom locale
        Locale in = new Locale("TAMIL","India");
        Locale.setDefault(in);
        Locale newLocale = Locale.getDefault();
        System.out.println(newLocale); //tamil_INDIA

        //parse() method removes the extra characters
        String income = "$92,807.99";
        var cf = NumberFormat.getCurrencyInstance(Locale.US);
        double value = (Double) cf.parse(income);
        System.out.println(value); // 92807.99

        /*
        CompactNumberFormat
        Short mode or Long mode
        Long mode - full name
        Shot mode - K,M,B,T and rounding
         */
        NumberFormat normal = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat longf = NumberFormat.getCompactNumberInstance(Locale.US,NumberFormat.Style.LONG);
        NumberFormat shortf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(normal.format(300_900_000)); // $300,900,000.00
        System.out.println(longf.format(300_900_000)); // 301 million
        System.out.println(shortf.format(300_900_000)); // 301M


        //Category.DISPLAY -> name in original eg.spain->espanol
        //Category.FORMAT -> Numbers in original eg. $20 -> 20€

    }
}