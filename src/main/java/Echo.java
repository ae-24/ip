import java.util.Scanner;


public class Echo {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Echo");
        System.out.println("What can I do for you?");
        System.out.println("Type 'bye' to exit.");
        System.out.println("____________________________________________________________");

        while (true) {
            line = in.nextLine();

            if (line.equalsIgnoreCase("bye")) {
                break;
            }
            System.out.println("____________________________________________________________");
            System.out.println(line);
            System.out.println("____________________________________________________________");

        }


        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
