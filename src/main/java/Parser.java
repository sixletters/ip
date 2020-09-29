public class Parser {
    private static String command;
    public static Command parse(String fullCommand){
        command = fullCommand;
        if (command.equals("bye")) {
            return new ExitCommand(command);

        } else if(command.equals("list")){
            return new ListCommand(command);
        } else if(command.split(" ")[0].equals("delete")){
            return new DeleteCommand(command);

        } else if (command.split(" ")[0].equals("done")) {
            return new DoneCommand(command);

        } else if (command.split(" ")[0].equals("find")){
            return new FindCommand(command);
        }
        else {
            return new AddCommand(command);
        }


    }
}
