import java.util.ArrayList;

public class Repository {
    private ArrayList <Family> myFamily;
    private int index = 0;

    public Repository(){
        myFamily = new ArrayList<Family>();
        //index++;
    }

    public ArrayList<Family> getMyFamily() {
        return myFamily;
    }

    public int getIndex() {
        return index;
    }
    public void addFamily(Family fam) {
        //Family fam = new Family(family, gender);
        myFamily.add(fam);
        index++;
    }
}
