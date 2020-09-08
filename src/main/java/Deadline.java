public class Deadline extends Activities {
    private String by;
    public Deadline(String activity) {
        this.Activity = activity.substring(0,activity.indexOf("/"));
        this.by = activity.substring(activity.indexOf("/") + 4);
    }

    @Override
    public String toString() {
        String listChecker;
        if (this.isDone() == 1) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return "[D]" + listChecker + " " + getActivity() + "(by: " + by + ")";
    }
}
