import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                " What can I do for you?");
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        ArrayList<Activities> toDoList = new ArrayList<>();
        int totalActivities = 0;
        while(exit == 0) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                exit = 1;
                System.out.println("Bye. Hope to see you again soon!");
            } else if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                int k = 1;
                for (Activities  Element: toDoList) {
                    System.out.println(k + "." + Element.toString());
                    k++;
                }
            } else if (command.split(" ")[0].equals("done")) {
                if (Integer.parseInt(command.split(" ")[1]) <= toDoList.size()) {
                    toDoList.get(Integer.parseInt(command.split(" ")[1]) - 1).doIt();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(toDoList.get(Integer.parseInt(command.split(" ")[1]) - 1).toString());
                } else {
                    System.out.println("Sorry, this activity does not exist");
                }
            } else {
                totalActivities++;
                System.out.println("Got it. I've added this task:");
                switch (command.split(" ")[0]) {
                case "todo" -> {
                    Activities temp = new Todo(command.split(" ", 2)[1]); // temp is an instance of todos
                    toDoList.add(temp);
                    System.out.println("  " + temp.toString());
                    System.out.println("Now you have " + totalActivities + " tasks in the list");
                }
                case "deadline" -> {
                    Activities temp1 = new Deadline(command.split(" ", 2)[1]);// temp1 is an instance of Deadline
                    toDoList.add(temp1);
                    System.out.println("  " + temp1.toString());
                    System.out.println("Now you have " + totalActivities + " tasks in the list");
                }
                case "event" -> {
                    Activities temp2 = new Event(command.split(" ", 2)[1]);// temp2 is an instance of Deadline
                    toDoList.add(new Event(command.split(" ", 2)[1]));
                    System.out.println("  " + temp2.toString());
                    System.out.println("Now you have " + totalActivities + " tasks in the list.");
                }
                }
            }
        }
    }
}
