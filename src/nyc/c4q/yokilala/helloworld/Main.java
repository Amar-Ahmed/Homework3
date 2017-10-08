package nyc.c4q.yokilala.helloworld;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;




public class Main {

    private static List<Database> question = new ArrayList<>();

    public static void main(String[] args) {

        promptUser();

    }

    private static void quiz() {
        Database q = new Database("q1", "What is a parameter?" + "\nA. a method call" + "\nB. the input of a method" + "\nC. a subclass of string0");
        q.addans("A", true);
        q.addans("B", false);
        q.addans("C", false);
        question.add(q);
        Database q2= new Database("q2", "What is a Class?" + "\nA. describes a particular kind of object" + "\nB. the input of a method" + "\nC. a subclass of string0");
        q2.addans("A", true);
        q2.addans("B", false);
        q2.addans("C", false);
        question.add(q2);
        Database q3= new Database("q3", "What is to Instantiate?" + "\nA. To allocate storage for an object in memory " + "\nB. the input of a method" + "\nC. a subclass of string0");
        q3.addans("A", true);
        q3.addans("B", false);
        q3.addans("C", false);
        question.add(q3);
        Database q4= new Database("q4", "What is a Typecast" + "\nA. to demote a variable from a larger capacity data type to a smaller one" + "\nB. the input of a method" + "\nC. a subclass of string0");
        q4.addans("A", true);
        q4.addans("B", false);
        q4.addans("C", false);
        question.add(q4);
        Database q5= new Database("q5", "What is a Constructor" + "\nA. A special type of instance method that creates a new object" + "\nB. the input of a method" + "\nC. a subclass of string0");
        q5.addans("A", true);
        q5.addans("B", false);
        q5.addans("C", false);
        question.add(q5);
        checker();
        quit();
    }

    public static void start(Scanner scanner) {


        while (scanner.hasNext()) {
            int choice = 0;

            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println();
                promptUser();
            }


            if (choice > 0 && choice <= 3) {
                if (choice == 1) {
                    System.out.println("Selected Java-Trainer");
                    search();
                    break;
                } else if (choice == 2) {
                    System.out.println("Selected Java-Quiz");
                    quiz();
                    break;
                } else if (choice == 3) {
                    quit();
                }

            } else {
                System.out.println("");
                promptUser();
            }
        }
    }
    public static String search() {


    Scanner scanner = new Scanner(System.in);
    System.out.println("Hi, welcome to java-trainer 1.0. Type in a java term you would like to learn more about:");
    String userInput= scanner.nextLine();

    HashMap<String, String> dictionary = new HashMap<>();

    dictionary.put("JVM", "Java Virtual Machine, a virtual machine that interprets Java bytecode and enables your computer to run it as a program.");
    dictionary.put("bytecode", "The machine language of the Java Virtual Machine.");
    dictionary.put("Java", "Java is a programming language and computing platform that was released by Sun Microsystems (now Oracle) in 1995.");
    dictionary.put("String", "A sequences of character, in the java programming language, strings are objects.");
    dictionary.put("array", "A collection of data items, all of the same type, in which each item's position is uniquely designated by an integer.");
    dictionary.put("boolean", "Refers to an expression or variable that can have only a true or false value.");


    while (!userInput.contains("quit")){
        if (userInput.equals("quit")) quit();
        System.out.println(dictionary.getOrDefault(userInput, "Try something else."));
        userInput= scanner.nextLine();
    }
    quit();

    return userInput;
    }

    public static void quit() {
        System.out.println("");
        System.out.println("Thank you for playing.");
        System.out.println("Good luck, and as always; May the force be with you!");
        System.exit(0);
    }
    private static void promptUser () {
        System.out.println("Welcome to Javamaster 1.0. Please select one of the following ...");
        System.out.println("1: Java-Trainer: Input a term for its definition!");
        System.out.println("2. Java-Quiz: Answer 5 correct questions!");
        System.out.println("3. Quit");
        Scanner scanner= new Scanner(System.in);
        start(scanner);
    }

    public static void checker(){
        for (int i = 0; i < question.size(); i++) {
            Database x = question.get(i);
            System.out.println(x.getQuestionnumber() + " " + x.getQuestion());
            while (true) {
                Scanner scan = new Scanner(System.in);
                System.out.println("choose an answer");
                String F = scan.nextLine();
                String correctOrWrong = x.iscorrect(F);
                try {
                    if (correctOrWrong.equalsIgnoreCase("correct")) {
                        System.out.println("correct");
                        break;
                    } else
                        System.out.println("wrong");
                } catch (NullPointerException e) {
                }
            }
        }
    }



}
