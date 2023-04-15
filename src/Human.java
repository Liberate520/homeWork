import java.util.List;

public class Human {
    private Gender gender;
    private String mather;
    private String father;
    private List<String> children;
    private String firstName;
    private String lastName;

    public Human(Gender gender, String firstName, String lastName, String mather, String father ) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mather = mather;
        this.father = father;
//        this.children.add(children);
    }
    public String getInformation(){
        return gender + " " +lastName + " " + firstName + " " + mather + " " + father + " " + children;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMather(String mather) {
        this.mather = mather;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setChildren(String children) {
        this.children.add(children);
    }
}
