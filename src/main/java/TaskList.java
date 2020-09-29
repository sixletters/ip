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

    public int size(){
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }
    public void remove(int index){
        tasks.remove(index);
    }
    public void add(Task newTask){
        tasks.add(newTask);
    }

}
