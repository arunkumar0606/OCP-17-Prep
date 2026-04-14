package ch_7;

public class Chapter7 {
}
//implicit modifier - ones that compiler automatically inserts
/*
Interface :
interface - > public abstract implicit , can be public/default
interface -> cannot be final
method -> public abstract implicit
constant -> public static final - implicit
Not mandatory to have at least one abstract method
If two default method are common , override using super keyword
Only interface can have 'default' keyword method , must have body
 */
interface Some{}  //valid

interface Company{  //default / public
    void recruit();  //public abstract - implicit
     int year=5; // public static final int year = 5; - implicit
}

class Comcast implements  Company{
    @Override
    public void recruit() {
        System.out.println("holaa!1");
    }
}
class Sample{
    public static void main(String[] args) {
        Comcast c= new Comcast();
        c.recruit();
        System.out.println(c.year);  // 5
        System.out.println(Comcast.year);  // 5
    }
}

//Extending interface
interface Backend{
    void backLang();
    void common();
    default void defaultCommon(){
        System.out.println("defaultCommon backend Java");
    }
}

interface Frontend{
    void frontLang();
    void common();
    default void defaultCommon(){
        System.out.println("defaultCommon frontend JS");
    }
}

interface FullStack extends Backend,Frontend{
    void fullStack();


    @Override
    default void defaultCommon() {
        Frontend.super.defaultCommon();
    }
}

class Arun implements FullStack{

    @Override
    public void fullStack() {
        System.out.println("Springboot React");
    }

    @Override
    public void backLang() {
        System.out.println("Springboot");
    }

    @Override
    public void common() {
        System.out.println("AWS is common");
    }

    @Override
    public void frontLang() {
        System.out.println("React");
    }

    public static void main(String[] args) {
        Backend b = new Arun();
        b.backLang();
        b.defaultCommon();
        System.out.println("-------");
        Frontend f = new Arun();
        f.frontLang();
        f.defaultCommon();
        System.out.println("-------");
        FullStack full = new Arun();
        full.fullStack();
        full.backLang();
        full.frontLang();
        full.defaultCommon();
        full.common();
        System.out.println("-------");
        Arun a = new Arun();
        a.backLang();
        a.frontLang();
        a.fullStack();
        a.common();
        a.defaultCommon();

    }
}

//All possible methods in interface
interface Interview {

    // ─── 1. ABSTRACT ───────────────────────────────────────────────────────────
    // WHY? Every company asks DIFFERENT technical questions.
    // Google asks DSA, Banks ask Spring Boot, Product companies ask System Design.
    // No common implementation possible — each company class MUST define its own.
    void askTechnicalQuestion();

    public void askHRQuestion();

    // ─── 2. DEFAULT ────────────────────────────────────────────────────────────
    // WHY? Every interview starts with the same intro — "Tell me about yourself".
    // No company needs to change this. But a company CAN override if they want
    // to add their own intro style.
    default void introduction() {
        log("Interview started");       // calls private helper
        System.out.println("Tell me about yourself.");
    }

    // ─── 3. STATIC ─────────────────────────────────────────────────────────────
    // WHY? Checking if a candidate is eligible has nothing to do with
    // a specific company instance. You check this BEFORE even scheduling
    // the interview. Call it as Interview.isEligible(2) not google.isEligible(2).
    static boolean isEligible(int experienceYears) {
        return isExperienceValid(experienceYears);  // calls private static helper
    }

    // ─── 4. PRIVATE ────────────────────────────────────────────────────────────
    // WHY? introduction() and sendResult() both need to log a message.
    // Instead of duplicating that line in every default method, we put it here.
    // GoogleInterview and CitiInterview should NOT see or call this.
    private void log(String message) {
        System.out.println("[LOG] " + message);
    }

    // ─── 5. PRIVATE STATIC ─────────────────────────────────────────────────────
    // WHY? isEligible() is static so it can only call static methods.
    // The experience check logic is extracted here to keep isEligible() clean.
    // Private because callers should use isEligible(), not this directly.
    private static boolean isExperienceValid(int years) {
        return years >= 1 && years <= 15;
    }

    // ─── 6. CONSTANT ───────────────────────────────────────────────────────────
    // WHY? Every interview on the planet has a fixed number of rounds typically.
    // Universal fact — no company needs to declare this separately.
    int MAX_ROUNDS = 5;
    int MIN_EXPERIENCE_YEARS = 1;
}

class Zoho implements Interview{

    @Override
    public void askTechnicalQuestion() {
        System.out.println("What is java ?");
    }

    @Override
    public void askHRQuestion() {
        System.out.println("Whats your salary exp?");
    }

}

class Candidate{
    public static void main(String[] args) {
        Interview z = new Zoho();
        System.out.println(Interview.isEligible(45));
        z.introduction();
        z.askTechnicalQuestion();
        z.askHRQuestion();
    }
}

//interface can be private if it used within a class/interface