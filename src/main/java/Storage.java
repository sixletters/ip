import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public String filePath;
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> toDoList = new ArrayList<>();
        File f = new File("List.txt");
        try {
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                String previousTasks = fileScanner.nextLine();
                int isDoneIndicator = Integer.parseInt(previousTasks.split(" ", 2)[0]);
                previousTasks = previousTasks.split(" ", 2)[1];
                switch (previousTasks.split(" ")[0]) {
                case "todo":
                    Task todoItem = new Todo(previousTasks.split(" ", 2)[1]); // temp is an instance of todos
                    if (isDoneIndicator == 1) {
                        todoItem.doIt();
                    }
                    toDoList.add(todoItem);
                    break;

                case "deadline":
                    Task deadlineItem = new Deadline(previousTasks.split(" ", 2)[1]);// temp1 is an instance of Deadline
                    if (isDoneIndicator == 1) {
                        deadlineItem.doIt();
                    }
                    toDoList.add(deadlineItem);
                    break;

                case "event":
                    Task eventItem = new Event(previousTasks.split(" ", 2)[1]);// temp2 is an instance of Deadline
                    if (isDoneIndicator == 1) {
                        eventItem.doIt();
                    }
                    toDoList.add(eventItem);
                    break;
                }
            }
        }catch (FileNotFoundException e){
            throw new DukeException();
        }
        return toDoList;
    }

    public void store(TaskList Tasks){
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Task Element : Tasks.getTasks()) {
                String activityDescription = "";
                if (Element instanceof Todo) {
                    if (Element.isDone()) {
                        activityDescription += "1 ";
                    } else {
                        activityDescription += "0 ";
                    }
                    activityDescription += "todo ";
                    activityDescription += Element.getActivity();

                } else if (Element instanceof Event) {
                    if (Element.isDone()) {
                        activityDescription += "1 ";
                    } else {
                        activityDescription += "0 ";
                    }
                    activityDescription += "event ";
                    activityDescription += Element.getActivity() + " /by " + ((Event) Element).getWhen();

                } else if (Element instanceof Deadline) {
                    if (Element.isDone()) {
                        activityDescription += "1 ";
                    } else {
                        activityDescription += "0 ";
                    }
                    activityDescription += "deadline ";
                    activityDescription += Element.getActivity() + "/at " + ((Deadline) Element).getBy();

                }
                fw.write(activityDescription + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error, Disconnected");
        }

    }
}
