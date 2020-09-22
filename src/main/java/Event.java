public class Event extends Task {
    private String eventTime;
    public Event(String activity) {
        this.Activity = activity.substring(0,activity.indexOf("/"));
        this.eventTime = activity.substring(activity.indexOf("/") + 4);
    }

    public String getWhen(){
        return eventTime;
    }
    @Override
    public String toString() {
        String listChecker;
        if (this.isDone()) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return "[E]" + listChecker + " " + getActivity() + "(at: " + eventTime + ")";
    }
}
