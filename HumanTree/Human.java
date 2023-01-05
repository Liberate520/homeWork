import java.io.IOException;
import java.io.Serializable;

public class Human  implements Serializable {
    private String name;
    private String years_of_life;
    private String years_of_reign;
    private Human father;
    private Human mather;
    FileWorker fileWorker = new FileWorker();    
    
    public Human(String name, String years_of_life, String years_of_reign, Human father, Human mather) {
        this.name = name;
        this.years_of_life = years_of_life;
        this.years_of_reign = years_of_reign;
        this.father = father;
        this.mather = mather;
        
    }

    public String getName() {
        return name;
    }

    public void write() throws IOException, ClassNotFoundException{
        fileWorker.write(this);
    }

    public void read() throws IOException, ClassNotFoundException{
        fileWorker.read();
    }

    public String getYears_of_reign() {
        return years_of_reign;
    }

    public Human getFather() {
        return father;
    }

    public Human getMather() {
        return mather;
    }
    
    @Override
    public String toString() {
        return "Human{" +
                "Name: '" + name + '\'' +
                ", годы жизни: " + years_of_life +
                '}';
    }
}
