public class DeleteCommand extends Command {
    public DeleteCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if(Integer.parseInt(command.split(" ")[1]) <= tasks.getTasks().size()){
            try {
                ui.showDelete(tasks, Integer.parseInt(command.split(" ")[1]) - 1);
                tasks.getTasks().remove(Integer.parseInt(command.split(" ")[1]) - 1);
            }catch (IndexOutOfBoundsException e){
                ui.showError("Sorry this task does not exist");
            }
        }
        else {
            try {
                throw new DukeException();
            } catch (DukeException e) {
                ui.showDoesNotExist();
            }
        }

    }
}
