import java.util.List;

public class Human {
    private String name;
    private String gendor;
    private Human father;
    private Human mater;
    List<Human> chldren;

    public Human (String name, String gendor, Human farher, Human mater){
        this.name = name;
        this.gendor = gendor;
        this.father = farher;
        farher.chldren.add(this);
        mater.chldren.add(this);
    }
    
}