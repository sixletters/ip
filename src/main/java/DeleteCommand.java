public class DeleteCommand extends Command {
    public DeleteCommand(String command) {
        this.command = command;
    }

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
