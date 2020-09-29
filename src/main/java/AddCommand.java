/**
 * An extension of Command used to add tasks into the TaskList inside duke.
 * Takes in the command once called and creates a new Task appropriately and adds it inside the TaskList.
 */
public class AddCommand extends Command {

    /**
     * Initializes a newly created instance of the AddCommand.
     * @param command  The command typed in by the user.
     */
    public AddCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command of adding the Task into the TaskList.
     * Will throw DukeException if an invalid command has been inputted.
     * Will throw ArrayIndexOutOfBounds or StringIndexOutOfBounds if there is no date or an invalid time has been inputted.
     * Date and time for Event and Deadline must be preceded by /.
     *
     * @param tasks  The Task-list for the command to be executed on.
     * @param ui The ui of type UI that prints and interacts the intended messages.
     * @param storage The storage of type Storage that handles the storing of data.
     * @throws DukeException If an invalid command or task is being input.
     * @throws ArrayIndexOutOfBoundsException If no date is given for deadline and/or event.
     * @throws StringIndexOutOfBoundsException If no date is given for deadline and/or event.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            switch (command.split(" ")[0]) {
            case "todo" :
                Task todoItem = new Todo(command.split(" ", 2)[1]); // temp is an instance of todos
                tasks.add(todoItem);
                ui.showAdd(tasks,tasks.getTasks().indexOf(todoItem));
                break;

            case "deadline" :
                Task deadlineItem = new Deadline(command.split(" ", 2)[1]);// temp1 is an instance of Deadline
                tasks.add(deadlineItem);
                ui.showAdd(tasks,tasks.getTasks().indexOf(deadlineItem));
                break;

            case "event" :
                Task eventItem = new Event(command.split(" ", 2)[1]);// temp2 is an instance of Deadline
                tasks.add(eventItem);
                ui.showAdd(tasks,tasks.getTasks().indexOf(eventItem));
                break;
            default :
                throw new DukeException();

            }
        } catch (DukeException e){
            ui.showError("I'm sorry, I don't know what that means");
        } catch (ArrayIndexOutOfBoundsException|StringIndexOutOfBoundsException e){
            ui.showError("☹ OOPS!!! The description of a todo,event and deadline cannot be empty.");
        }
    }
}
