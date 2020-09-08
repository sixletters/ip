public class Todo extends Activities {
    public Todo(String activity) {
        this.Activity = activity;
    }

    @Override
    public String toString() {
        String listChecker;
        if (this.isDone() == 1) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return "[T]" + listChecker + " " + getActivity();
    }

}
