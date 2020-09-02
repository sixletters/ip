public class Event extends Activities {
    private String at;
    public Event(String activity) {
        super(activity.substring(0,activity.indexOf("/")));
        this.at = activity.substring(activity.indexOf("/") + 4);
    }

    @Override
    public String toString() {
        String listChecker;
        if (this.isDone() == 1) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return "[E]" + listChecker + " " + getActivity() + "(at: " + at + ")";
    }
}
