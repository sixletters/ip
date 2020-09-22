public class AddCommand extends Command {


    public AddCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            switch (command.split(" ")[0]) {
            case "todo" :
                Task todoItem = new Todo(command.split(" ", 2)[1]); // temp is an instance of todos
                tasks.getTasks().add(todoItem);
                ui.showAdd(tasks,tasks.getTasks().indexOf(todoItem));
                break;

            case "deadline" :
                Task deadlineItem = new Deadline(command.split(" ", 2)[1]);// temp1 is an instance of Deadline
                tasks.getTasks().add(deadlineItem);
                ui.showAdd(tasks,tasks.getTasks().indexOf(deadlineItem));
                break;

            case "event" :
                Task eventItem = new Event(command.split(" ", 2)[1]);// temp2 is an instance of Deadline
                tasks.getTasks().add(eventItem);
                ui.showAdd(tasks,tasks.getTasks().indexOf(eventItem));
                break;
            default :
                throw new DukeException();

            }
        } catch (DukeException e){
            ui.showError("I'm sorry, I dont know what that means");
        } catch (ArrayIndexOutOfBoundsException|StringIndexOutOfBoundsException e){
            ui.showError("☹ OOPS!!! The description of a todo,event and deadline cannot be empty.");
        }
    }
}
