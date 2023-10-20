package Model.FamTreeModel.Human;

public class HumanBuilder {
    private Human human;

//    private long id;
//    private String firstName;
//    private String lastName;
//    private Gender sex;
//    private int age;

   public void createHuman(){
       human = new Human();
   }
   public Human getHuman(){
       return human;
   }
   public void buildFname(String fname){
        getHuman().setFirstName(fname);
   }
    public void buildLname(String lname){
        getHuman().setLastName(lname);
    }
    public void buildSex(Gender sex){
        getHuman().setSex(sex);
    }
    public void buildAge(int age){getHuman().setAge(age); }

    public Human build(String fname, String lname, Gender sex, int age){
       createHuman();
       buildFname(fname);
       buildLname(lname);
       buildSex(sex);
       buildAge(age);
       return getHuman();
    }
}
