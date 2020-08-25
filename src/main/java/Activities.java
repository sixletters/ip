public class Activities {
    private final String Activity;
    private int status = 0; // 0 represent undone: 1 represents done

    private Activities(String activity) {
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
    public int doneChecker(){
        return status;
    }


}
