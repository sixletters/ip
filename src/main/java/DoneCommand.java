/**
 * An extension of Command used to declare tasks in Tasklist as Done.
 * Takes in the command once called and changes the status of the Task at a specific Index as done.
 */
public class DoneCommand extends Command{

    /**
     * Initializes a newly created instance of the DoneCommand.
     * @param command  The command typed in by the user of type String.
     */
    public DoneCommand(String command) {
        this.command = command;
    }

    /**
     * Changes the status of a Task at a specified index to done.
     * If index is out of range, prints a message that tells the user the task being done does not exist.
     * prints a done message followed by Task that has been done
     *
     * @param tasks  The Task-list for the command to be executed on.
     * @param ui The ui of type UI that prints and interacts the intended messages.
     * @param storage The storage of type Storage that handles the storing of data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (Integer.parseInt(command.split(" ")[1]) <= tasks.getTasks().size()) {
            tasks.get(Integer.parseInt(command.split(" ")[1]) - 1).doIt();
            ui.showDone(tasks,Integer.parseInt(command.split(" ")[1]) - 1 );
        } else {
            ui.showDoesNotExist();
        }

    }
}
