import java.util.List;

public class Interactions {
    private List<Actionable> activities;

    public Interactions(List<Actionable> activities){
        this.activities = activities;
    }
    public void interactAll(){
        for (Actionable activities: activities){
            activities.interact();
        }
    }
}
