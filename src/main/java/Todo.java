public class Todo extends Task {
    public Todo(String activity) {
        this.Activity = activity;
    }

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
