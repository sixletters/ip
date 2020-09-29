
/**
 * Represents a Task with an Activity name e.g., Read Book and a boolean to dictate whether it has been done.
 * It is an abstract class that cannot be instantiated.
 */

abstract class Task {
    protected String Activity;
    private boolean status = false; // 0 represent undone: 1 represents done

    /**
     * Changes the done status of Task to true;
     */
    public void doIt() {
        status = true;
    }
    /**
     * Returns the name of the Task.
     * @return Actvity The name of the Task of type String.
     */
    public String getActivity(){
        return Activity;
    }
    /**
     * Returns a boolean that is the done status of the Task.
     * @return isDone The done status of the Task.
     */
    public boolean isDone(){
        return status;
    }
    /**
     * Returns a String with the Listchecker and the name of the activity e.g., [x] Harris
     * @return FinalString the String with the name and the status of the Task.
     */

    @Override
    public String toString() {
        String listChecker;
        if (status) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        String finalString = listChecker + " " + getActivity();
        return finalString;
    }

}
