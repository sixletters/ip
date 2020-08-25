import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                " What can I do for you?");
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        ArrayList<String> toDoList = new ArrayList<String>();
        while(exit == 0) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                exit = 1;
                System.out.println("Bye. Hope to see you again soon!");
            }
            else if(command.equals("list")){
                int k = 1;
                for(String toDo:toDoList){
                    System.out.println(k + ". " + toDo);
                    k++;
                }
            }
            else{
                toDoList.add(command);
                System.out.println("added: " + command);
            }
        }

    }
}
