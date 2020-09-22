public class Deadline extends Task {
    private String deadlineTime;
    public Deadline(String activity) {
        this.Activity = activity.substring(0,activity.indexOf("/"));
        this.deadlineTime = activity.substring(activity.indexOf("/") + 4);
    }

    public String getBy(){
        return deadlineTime;
    }

    @Override
    public String toString() {
        String listChecker;
        if (this.isDone()) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return "[D]" + listChecker + " " + getActivity() + "(by: " + deadlineTime + ")";
    }
}
