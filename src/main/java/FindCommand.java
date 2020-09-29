import java.util.ArrayList;

public class FindCommand extends Command{
    public FindCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        command = command.split(" ",2)[1];
        ArrayList<Task> foundItemsList = new ArrayList();
        for(int i = 0;i < tasks.size();i++){
            if(tasks.get(i).getActivity().indexOf(command) > -1){
                foundItemsList.add(tasks.getTasks().get(i));
            }
        }
        ui.showFind(foundItemsList);
    }
}
