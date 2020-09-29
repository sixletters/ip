abstract class Command{
    protected String command;

    public void execute(TaskList tasks,Ui ui,Storage storage){

    }

    public boolean isExit(){
        return false;
    }
}
