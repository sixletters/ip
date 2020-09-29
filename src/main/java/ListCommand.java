/**
 * An extension of Command used to print all the tasks in the TaskList.
 *
 */
public class ListCommand extends Command {

    /**
     * Initializes a newly created instance of the ListCommand
     * @param command  The command typed in by the user of type String
     */
    public ListCommand(String command) {
        this.command = command;
    }
    /**
     * Prints the current Items in the TaskList, their status and their type by numerical order with the first one to be added as index 1.
     *
     * @param tasks  The Task-list for the command to be executed on.
     * @param ui The ui of type UI that prints and interacts the intended messages.
     * @param storage The storage of type Storage that handles the storing of data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showList(tasks);
    }
}
