public class ExitCommand extends Command {


    public ExitCommand(String command) {
        super(command);
    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.store(tasks);
        ui.showGoodBye();
    }
}
