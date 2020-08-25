import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                " What can I do for you?");
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        while(exit == 0) {
            String command = sc.next();
            if (command.equals("bye")) {
                exit = 1;
                System.out.println("Bye. Hope to see you again soon!");
            }
            else{
                System.out.println(command);
            }
        }

    }
}
