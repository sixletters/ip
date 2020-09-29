
/**
 * An extension of Command used exit the main loop and prints a goodbye message to the user.
 * Saves the Current TaskList in a file specified by the Storage class.
 *
 */
public class ExitCommand extends Command {

    /**
     * Initializes a newly created instance of the ExitCommand.
     * @param command  The command typed in by the user of type String.
     */
    public ExitCommand(String command) {
        this.command = command;
    }
    /**
     * Returns and overrides the isExit in Command to return true;
     * @return true
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /**
     * Command used to exit the main loop by returning true for the method isExit().
     * Saves the Tasks in TaskList in a specified file by using storage of Storage CLass.
     * Prints a goodbye message.
     *
     * @param tasks  The Task-list for the command to be executed on.
     * @param ui The ui of type UI that prints and interacts the intended messages.
     * @param storage The storage of type Storage that handles the storing of data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.store(tasks);
        ui.showGoodBye();
    }
}
