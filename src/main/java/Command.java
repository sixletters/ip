/**
 * An abstract parent class of all the commands and functions available to the user.
 *
 */
abstract class Command{
    protected String command;

    /**
     * Abstract execute method to be implemented by each individual child of the command class.
     *
     * @param tasks  The Task-list for the command to be executed on.
     * @param ui The ui of type UI that prints and interacts the intended messages.
     * @param storage The storage of type Storage that handles the storing of data.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    /**
     * Method isExit that returns false that will be inherited by the rest of the command classes.
     * @return false The default is false, unless overriden
     */
    public boolean isExit(){
        return false;
    }
}
