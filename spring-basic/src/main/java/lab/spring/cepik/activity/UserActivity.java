package lab.spring.cepik.activity;

import java.util.ArrayList;
import java.util.List;

public class UserActivity {

    private List<Activity> activities;

    public UserActivity() {
        this.activities = new ArrayList<>();
    }

    public void registerActivity(String message) {
        activities.add(new Activity(message));
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void clear(){
        this.activities.clear();
    }
}
