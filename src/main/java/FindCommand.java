import java.util.ArrayList;

/**
 * An extension of Command used to Find and search for tasks inside the TaskList
 * Takes in the command once called and looks for Tasks that match the given word.
 */
public class FindCommand extends Command{
    /**
     * Initializes a newly created instance of the FindCommand
     * @param command  The command typed in by the user of type String
     */
    public FindCommand(String command) {
        this.command = command;
    }

    /**
     * Finds and searches the TaskList for Taks that matches the word inputted by user.
     * e.g. if "find Book" is being inputted, tasks with the word book inside the activity name will be printed.
     * @param tasks  The Task-list for the command to be executed on.
     * @param ui The ui of type UI that prints and interacts the intended messages.
     * @param storage The storage of type Storage that handles the storing of data.
     */
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
