import java.util.ArrayList;

public class Human implements MethodsWorking{
    private int id;
    private String name;
    private int age;
    private ArrayList<Сommunications> son = new ArrayList<Сommunications>();
    private Gender gender;

    public void setId() {
        this.id = FamilyTree.getId();
        FamilyTree.setId(this.id + 1);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setSon(ArrayList<Сommunications> son) {
        this.son = son;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Gender getGender() {
        return gender;
    }
    public ArrayList<Сommunications> getSon() {
        return son;
    }

    public Human(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        setId();
    }
    public Human(String name, int age, ArrayList<Сommunications> son) {
        this.name = name;
        this.age = age;
        this.son = son;
        setId();
    }
    public Human(String name, ArrayList<Сommunications> son) {
        this.name = name;
        this.son = son;
        setId();
    }
    @Override
    public void getInfo() {
        printRelatives();
    }

    private void printRelatives(){
        ArrayList<Сommunications> tList = this.getSon();
        System.out.println("Родственники для " + this.name + ":");
        for (int i = 0; i < tList.size(); i++){
            System.out.print("ID:" + tList.get(i).getH2().getId() + ", Имя: " + tList.get(i).getH2().getName() + ", ");
            System.out.print("Возвраст: " + tList.get(i).getH2().getAge() + ", ");
            System.out.println("Степень родства: " + tList.get(i).getDegreeKinship2() + " (пол - " + tList.get(i).getH2().getGender() + ").");

        }
        System.out.println();
    }

    public void addСommunications(Human h2, TypeCommunications st1, TypeCommunications st2){
        this.son.add(new Сommunications(this, h2, st1, st2));
        h2.son.add(new Сommunications(h2, this, st2, st1));
    }

}
