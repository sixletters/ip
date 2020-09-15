import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    public static void main(String[] args) throws DukeException, IOException {
        System.out.println("Hello! I'm Duke\n" +
                " What can I do for you?");
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        ArrayList<Activities> toDoList = new ArrayList<>();
        int totalActivities = 0;
        File f = new File("List.txt");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        }catch(IOException e){
            System.out.println("sorry this file already exists");
        }
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()) {
            String previousTasks = fileScanner.nextLine();
            int temp = Integer.parseInt(previousTasks.split(" ", 2)[0]);
            previousTasks = previousTasks.split(" ", 2)[1];
            switch (previousTasks.split(" ")[0]) {
            case "todo":
                Activities temp0 = new Todo(previousTasks.split(" ", 2)[1]); // temp is an instance of todos
                if(temp == 1){
                    temp0.doIt();
                }
                totalActivities++;
                toDoList.add(temp0);
                break;

            case "deadline":
                Activities temp1 = new Deadline(previousTasks.split(" ", 2)[1]);// temp1 is an instance of Deadline
                if(temp == 1){
                    temp1.doIt();
                }
                totalActivities++;
                toDoList.add(temp1);
                break;

            case "event":
                Activities temp2 = new Event(previousTasks.split(" ", 2)[1]);// temp2 is an instance of Deadline
                if(temp == 1){
                    temp2.doIt();
                }
                totalActivities++;
                toDoList.add(temp2);
                break;
            }
        }
        while(exit == 0) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                try {
                    FileWriter fw = new FileWriter("list.txt");
                    for(Activities  Element: toDoList){
                        String activityDescription = "";
                        if(Element instanceof Todo){
                            if(Element.isDone() == 1){
                                activityDescription += "1 ";
                            }
                            else{
                                activityDescription += "0 ";
                            }
                            activityDescription += "todo ";
                            activityDescription += Element.getActivity();

                        }
                        else if(Element instanceof Event){
                            if(Element.isDone() == 1){
                                activityDescription += "1 ";
                            }
                            else{
                                activityDescription += "0 ";
                            }
                            activityDescription += "event ";
                            activityDescription += Element.getActivity() + " /by " + ((Event) Element).atWhen();

                        }else if(Element instanceof Deadline){
                            if(Element.isDone() == 1){
                                activityDescription += "1 ";
                            }
                            else{
                                activityDescription += "0 ";
                            }
                            activityDescription += "deadline ";
                            activityDescription += Element.getActivity() + "/at " + ((Deadline) Element).byWhen();

                        }
                        fw.write( activityDescription + System.lineSeparator());
                    }
                    fw.close();
                    exit = 1;
                    System.out.println("Bye. Hope to see you again soon!");
                } catch(IOException e){
                    System.out.println("File does not exist");
                }
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
                try {
                    switch (command.split(" ")[0]) {
                        case "todo" :
                            Activities temp0 = new Todo(command.split(" ", 2)[1]); // temp is an instance of todos
                            totalActivities++;
                            toDoList.add(temp0);
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + temp0.toString());
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
