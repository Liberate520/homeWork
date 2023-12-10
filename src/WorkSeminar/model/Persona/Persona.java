package WorkSeminar.model.Persona;

import WorkSeminar.model.Tree.TreeEtem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable, TreeEtem<Persona> {
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate dathday;
    private Persona partner;
    private Persona mather;
    private Persona father;
    private List<Persona> kids;
    private long id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public LocalDate getDathday() {
        return dathday;
    }
    public void setDathday(LocalDate dathday) {
        this.dathday = dathday;
    }
    public Persona getPartner() {
        return partner;
    }

    public void setPartner(Persona partner) {
        this.partner = partner;
    }
    public Persona getMather() {
        return mather;
    }
    public void setMather(Persona mather) {
        this.mather = mather;
    }
    public Persona getFather() {
        return father;
    }
    public void setFather(Persona father) {
        this.father = father;
    }
    public List<Persona> getKids() {
        return kids;
    }
    public void setKids(List<Persona> kids) {
        this.kids = kids;
    }
    public long getId() {
        return id;
    }


   


    public void setId(long id) {
        this.id = id;
    }

    public Persona(String name, String lastName, Gender gender, LocalDate birthday, LocalDate dathday,
                   Persona mather, Persona father){
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.dathday = dathday;
        this.mather = mather;
        this.father = father;
        kids = new ArrayList<>();
        id = -1;
    }
    public  Persona(String name, String lastName, Gender gender, LocalDate birthday) {
        this(name, lastName, gender, birthday, null, null, null);
    }
    public  Persona(String name, String lastName, Gender gender, LocalDate birthday, Persona mather, Persona father){
        this(name, lastName, gender, birthday, null, mather, father);
    }
    public  Persona() {
        this(null, null, null, null, null, null, null);
    }

    public void addKid(Persona kid){
        if (!kids.contains(kid)) {
            kids.add(kid);
        }
    }



    public  boolean addParent(Persona parent){
        if (parent.getGender().equals(Gender.Female)){
            setMather(parent);
        } else if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        return true;
    }

    public  boolean addParent(Persona parentF, Persona parentM){
        addParent(parentF);
        addParent(parentM);
        return true;
    }

    public List<Persona> addParents(){
        List<Persona> parentsList = new ArrayList<>(2);
        if(mather != null){
            parentsList.add(mather);
        }
        if (father != null){
            parentsList.add(father);
        }
        return parentsList;
    }

    public int addAge(){
        if(dathday == null){
            return Period.between(birthday, LocalDate.now()).getYears();
        } else {
            return Period.between(birthday, dathday).getYears();
        }
    }
    public String addAlive(){
        if(dathday == null){
            return "";
        } else {
            return "Умер в ";
        }
    }
    public String getInfo(){
        StringBuilder infoDate = new StringBuilder();
        infoDate.append("Имя: ");
        infoDate.append(name);
        infoDate.append(", Фамилия: ");
        infoDate.append(lastName);
        infoDate.append(", Пол: ");
        infoDate.append(getGender());
        infoDate.append(", Возраст: ");
        infoDate.append(addAlive());
        infoDate.append(addAge());
        infoDate.append(", ");
        infoDate.append(addSpouseInfo());
        infoDate.append(", ");
        infoDate.append(addMatherInfo());
        infoDate.append(", ");
        infoDate.append(addFatherInfo());
        infoDate.append(", ");
        infoDate.append(addKidsInfo());
        infoDate.append(", ID: ");
        infoDate.append(id);
        return infoDate.toString();
    }

    public String toString(){
        return  getInfo();
    }

    public  String addSpouseInfo(){
        if(partner != null){
            return "Супруг(а): " + partner.getName();
        } else {
            return "Супруг(а): не состоит в браке";
        }
    }

    public String addMatherInfo(){
        if(mather != null){
            return "Мать: " + mather.getName();
        } else {
            return "Мать: данных нет";
        }
    }

    public String addFatherInfo(){
        if(father != null){
            return "Отец: " + father.getName();
        } else {
            return "Отец: данных нет";
        }
    }

    public String addKidsInfo(){
        StringBuilder listKids = new StringBuilder();
        listKids.append("Дети: ");
        if(!kids.isEmpty()){
            for (int i = 0; i < kids.size(); i++){
                listKids.append(kids.get(i).getName());
                listKids.append("; ");
            }
        } else {
            listKids.append("нет");
        }
        return listKids.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Persona)){
            return false;
        }
        Persona persona = (Persona) obj;
        return  persona.getId() == getId();
    }


}

