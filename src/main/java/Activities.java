abstract class Activities {
    protected String Activity;
    private int status = 0; // 0 represent undone: 1 represents done

    public void doIt() {
        status = 1;
    }

    public String getActivity(){
        return Activity;
    }
    public int isDone(){
        return status;
    }

    @Override
    public String toString() {
        String listChecker;
        if (status == 1) {
            listChecker = "[\u2713]";
        } else {
            listChecker = "[x]";
        }
        return listChecker + " " + getActivity();
    }

}
