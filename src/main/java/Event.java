
/**
 * Represents a task with a time. For example "Team meeting /at 20th june"
 * Contains A string with the name of the activity inherited from the Task class and eventTime of type String which is the time of the event
 */
public class Event extends Task {
    private String eventTime;

    /**
     * Initializes and creates an instance of Event with the activity name and the Event Time.
     * @param activity the name and the time of the activity preceded by a /at e.g., Team meeting /at 20th june.
     */
    public Event(String activity) {
        this.Activity = activity.substring(0,activity.indexOf("/"));
        this.eventTime = activity.substring(activity.indexOf("/") + 4);
    }

    /**
     * Returns the Event Time of the Task.
     * @return EvenTime A string which is the time of the Event.
     */
    public String getWhen(){
        return eventTime;
    }

    /**
     * Returns a String with the Listchecker, the name of the activity and the Event Time e.g., [x] Harris (at:20th june)
     * @return FinalString a String with the type of Task, the status of the task, the name of the task and the Event Time of the task.
     */
    @Override
    public String toString() {
        String listChecker;
        if (this.isDone()) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        String FinalString = "[E]" + listChecker + " " + getActivity() + "(at: " + eventTime + ")";
        return FinalString;
    }
}
