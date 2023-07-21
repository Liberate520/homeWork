import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private String dataOfBirth;
    private String dateOfDeath;
    private Gender gender;
    private int id;
    private Human mother;
    private Human father;
    private List<Human> cildrenList;
    private int idCildren;

    public Human(String name,Gender gender, String dataOfBirth, String dataOfDeath) {
        this.name = name;
        this.gender=gender;
        this.dataOfBirth = dataOfBirth;
        this.dateOfDeath = dataOfDeath;
        cildrenList=new ArrayList<>();
    }
    public Human(String name,Gender gender, String dataOfBirth) {
        this(name,gender, dataOfBirth,null);
    }

    public int getId() {
        return id;
    }
    public void addCildren(Human human){
        this.idCildren ++;
        cildrenList.add(human);
    }
    public void setId(int id) {
        this.id = id;
    }
    public void SetGender(Gender gender) {
        this.gender = gender;
    }
    public String getCildren(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( name +"\n");
        stringBuilder.append("Список детей:\n");
        //String str=null;
        for (Human cildren : cildrenList) {         
            stringBuilder.append(cildren);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        String str="мужской";
        if (this.gender==Gender.female) str="женский";
        if (dateOfDeath == null)
            return "ID: "+ id+" имя: " + name + ", пол: " + str + ", Дата рождения " + dataOfBirth;
        else
            return "ID: "+ id+" имя: " + name + ", пол: " + str + ", Дата рождения " + dataOfBirth + ", Дата смерти" + dateOfDeath;
    }
    

}
