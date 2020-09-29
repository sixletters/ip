public class DoneCommand extends Command{

    public DoneCommand(String command) {
        this.command = command;
    }

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
