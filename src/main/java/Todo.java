
/**
 * Represents an indefinate task. For example "Team meeting"
 * Contains A string with the name of the activity inherited from the Task class.
 */
public class Todo extends Task {
    public Todo(String activity) {
        this.Activity = activity;
    }


    /**
     * Returns a String with the Listchecker and the name of the activity e.g., [x] Harris
     * @return FinalString the String with the name and the status of the Task.
     */
    @Override
    public String toString() {
        String listChecker;
        if (this.isDone()) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return "[T]" + listChecker + " " + getActivity();
    }

}
