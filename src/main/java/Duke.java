import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                " What can I do for you?");
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        ArrayList<Activities> toDoList = new ArrayList<Activities>();
        while(exit == 0) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                exit = 1;
                System.out.println("Bye. Hope to see you again soon!");
            }
            else if(command.equals("list")){
                System.out.println("Here are the tasks in your list:");
                int k = 1;
                for(Activities toDo:toDoList){
                    String listChecker;
                    if(toDo.doneChecker() == 1){
                        listChecker = "[\u2713]";
                    }
                    else{
                        listChecker = "[x]";
                    }
                    System.out.println(k + ". " + listChecker + " " + toDo.getActivity());
                    k++;
                }
            }
            else if(command.split(" ")[0].equals("done")){
                if(Integer.parseInt(command.split(" ")[1]) <= toDoList.size()){
                    toDoList.get(Integer.parseInt(command.split(" ")[1]) - 1).doIt();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[\u2713] " + toDoList.get(Integer.parseInt(command.split(" ")[1]) - 1).getActivity());
                }
                else{
                    System.out.println("Sorry, this activity does not exist");
                }
            }
            else{
                toDoList.add(Activities.newActivity(command));
                System.out.println("added: " + command);
            }
        }

    }
}
