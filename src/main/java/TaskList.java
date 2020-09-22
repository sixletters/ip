import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }
}
