package human;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Human  implements Serializable, Comparable<Human> {
    private String name;
    private Gender gender;
    private Date dateBirth;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, Date dateBirth, Human mother, Human father){
        this.name = name;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();

  }
  public Human(String name, Gender gender, Date dateBirth){
        this.name = name;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.children = new ArrayList<>();

  }

//    public human.Human(String name, human.Gender gender, Data dateBirth) {
//        this.name = name;
//        this.gender = gender;
//        this.dateBirth = dateBirth;
//    }

    public void save() throws IOException, ClassNotFoundException{
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(
              new FileOutputStream("human.out")
      );

      objectOutputStream.writeObject(this);
  }
  public Human read() throws IOException, ClassNotFoundException{
      ObjectInputStream objectInputStream = new ObjectInputStream(
              new FileInputStream("human.out")
      );
      Human humanRestored = (Human) objectInputStream.readObject();

      objectInputStream.close();
      return humanRestored;
  }
  public String getAllInfo(){
        StringBuilder info = new StringBuilder();
        info.append(this.name + " ");
        info.append(this.gender + " ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        info.append(simpleDateFormat.format(this.dateBirth) + " ");
        info.append(this.getMotherInfo() + " ");
        info.append(this.getFatherInfo() + " ");
        info.append(this.getChildrenInfo());

        return info.toString();
    }
    public String getMotherInfo(){
        String mom = "Mother: ";
        if (this.mother != null) {
            mom += mother.getName();
        } else {
            mom += "None";
        }
        return  mom;
    }
    public String getFatherInfo(){
        String pap = "Father: ";
        if (this.father != null) {
            pap += father.getName();
        } else {
            pap += "None";
        }
        return pap;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(this.name + ",");
        res.append(this.gender + ",");
        if (this.mother != null) {
            res.append(this.mother.getName() + ",");
        } else {
            res.append(null + ",");
        }
        if (this.father != null) {
            res.append(this.father.getName() + "");
        } else {
            res.append(null + "");
        }
    return res.toString();
    }
    public boolean addChild(Human child){
       if (!children.contains(child)) {
           children.add(child);
           return true;
       }
       return  false;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return  true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return  human.getName().equals(getName());
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Children: ");
        if (this.children.isEmpty()) {
            res.append("None");
            return res.toString();
        }
        else {

            for (Human child: this.children
                 ) {
                res.append(child.getName());
                res.append(", ");

            }
            return  res.toString();
        }
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }


}
