

/**
 * Represents a task with a deadline. For example "Read book /by 20th june"
 * Contains A string with the name of the activity inherited from the Task class and deadLineTime of type String which is the time of the deadline.
 */

public class Deadline extends Task {
    private String deadlineTime;

    /**
     * Initializes and creates an instance of Deadline with the activity name and the deadline time.
     * @param activity the name and the deadline of the activity preceded by a /by. e.g., Read book /by 20th june.
     */
    public Deadline(String activity) {
        this.Activity = activity.substring(0,activity.indexOf("/"));
        this.deadlineTime = activity.substring(activity.indexOf("/") + 4);
    }

    /**
     * Returns the deadline Time of the Task.
     * @return deadLineTime A string which is the time of the deadline.
     */
    public String getBy(){
        return deadlineTime;
    }

    /**
     * Returns a String with the Listchecker, the name of the activity and the deadline Time e.g., [x] Harris (by:20th june)
     * @return FinalString a String with the type of Task, the status of the task, the name of the task and the deadline of the task.
     */
    @Override
    public String toString() {
        String listChecker;
        if (this.isDone()) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        String FinalString = "[D]" + listChecker + " " + getActivity() + "(by: " + deadlineTime + ")";
        return FinalString;
    }
}
