public class Activities {
    private String Activity;
    private int status = 0; // 0 represent undone: 1 represents done

    public Activities(String activity) {
        Activity = activity;
    }
    public static Activities newActivity(String activity){
        return new Activities(activity);
    }

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
