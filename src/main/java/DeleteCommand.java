/**
 * An extension of Command used to delete tasks from the TaskList.
 * Takes in the command once called and deletes the specified Task at a specific index.
 */
public class DeleteCommand extends Command {

    /**
     * Initializes a newly created instance of the DeleteCommand.
     * @param command  The command typed in by the user.
     */
    public DeleteCommand(String command) {
        this.command = command;
    }

    /**
     * Deletes a Task in the TaskList based on a specific Index.
     * If Index does no exist in TaskList, ArrayIndexOutOfBoundsException is thrown and handled.
     * Prints the task that has been deleted as well as the number of items left in the TaskList.
     *
     * @param tasks  The Task-list for the command to be executed on.
     * @param ui The ui of type UI that prints and interacts the intended messages.
     * @param storage The storage of type Storage that handles the storing of data.
     * @throws ArrayIndexOutOfBoundsException If an invalid index that is not in range is inputted.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            if (Integer.parseInt(command.split(" ")[1]) <= tasks.getTasks().size()) {
                ui.showDelete(tasks, Integer.parseInt(command.split(" ")[1]) - 1);
                tasks.remove(Integer.parseInt(command.split(" ")[1]) - 1);
            } else {
                ui.showDoesNotExist();
            }
        } catch (ArrayIndexOutOfBoundsException e){
            ui.showError("There are no elements in the list");
        }

    }
}
