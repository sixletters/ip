import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    public static void main(String[] args) throws DukeException {
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
            } else if(command.split(" ")[0].equals("delete")){
                if(Integer.parseInt(command.split(" ")[1]) <= totalActivities){
                    System.out.println(" Noted. I've removed this task: ");
                    System.out.println("  " + toDoList.get(Integer.parseInt(command.split(" ")[1]) - 1).toString());
                    totalActivities--;
                    System.out.println("Now you have " + totalActivities + " tasks in the list");
                    toDoList.remove(Integer.parseInt(command.split(" ")[1]) - 1);


                }
                else {
                    try {
                        throw new DukeException();
                    } catch (DukeException e) {
                        System.out.println("☹ OOPS!!! I'm sorry, that item does not exist");
                    }
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
                try {
                    switch (command.split(" ")[0]) {
                        case "todo" :
                            Activities temp = new Todo(command.split(" ", 2)[1]); // temp is an instance of todos
                            totalActivities++;
                            toDoList.add(temp);
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + temp.toString());
                            System.out.println("Now you have " + totalActivities + " tasks in the list");
                            break;

                        case "deadline" :
                            Activities temp1 = new Deadline(command.split(" ", 2)[1]);// temp1 is an instance of Deadline
                            totalActivities++;
                            toDoList.add(temp1);
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + temp1.toString());
                            System.out.println("Now you have " + totalActivities + " tasks in the list");
                            break;

                        case "event" :
                            Activities temp2 = new Event(command.split(" ", 2)[1]);// temp2 is an instance of Deadline
                            totalActivities++;
                            toDoList.add(new Event(command.split(" ", 2)[1]));
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + temp2.toString());
                            System.out.println("Now you have " + totalActivities + " tasks in the list.");
                            break;
                        default :
                            throw new DukeException();

                    }
                } catch (DukeException e){
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-()");
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! The description of a todo,event and deadline cannot be empty.");
                }
            }
        }
    }
}
