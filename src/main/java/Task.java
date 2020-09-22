abstract class Task {
    protected String Activity;
    private boolean status = false; // 0 represent undone: 1 represents done

    public void doIt() {
        status = true;
    }

    public String getActivity(){
        return Activity;
    }
    public boolean isDone(){
        return status;
    }

    @Override
    public String toString() {
        String listChecker;
        if (status) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return listChecker + " " + getActivity();
    }

}
