import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public void showLoadingError(){
        System.out.println("Error loading file, a new file will be created");
    }
    public String readCommand(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void showWelcome(){
        System.out.println("Hello! I'm Duke\n" +
                " What can I do for you?");
    }

    public void showError(String message){
        System.out.println(message);
    }

    public void showGoodBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showList(TaskList Tasks){
        System.out.println("Here are the tasks in your list:");
        int k = 1;
        for (Task  Element: Tasks.getTasks()) {
            System.out.println(k + "." + Element.toString());
            k++;
        }
    }
    public void showDelete(TaskList Tasks,int index){
        System.out.println(" Noted. I've removed this task: ");
        System.out.println("  " + Tasks.get(index).toString());
        System.out.println("Now you have " + (Tasks.size() - 1) + " tasks in the list");
    }

    public void showDoesNotExist(){
        System.out.println("☹ OOPS!!! I'm sorry, that item does not exist");
    }

    public void showDone(TaskList tasks,int index){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.get(index).toString());
    }

    public void showAdd(TaskList tasks,int index){
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(index).toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list");

    }
    public void showFind(ArrayList<Task> tasks){
        if(tasks.size() > 0){
            System.out.println("Here are the matching tasks in your list:");
            int k = 1;
            for (Task  Element: tasks) {
                System.out.println(k + "." + Element.toString());
                k++;
            }
        }else{
            System.out.println("Sorry no such item exists in the current list");
        }
    }
}
