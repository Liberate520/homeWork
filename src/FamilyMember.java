package assignment.pkg2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Family member class which allows for the construction of a single family member.
 * Each member then has their specified relative housed within their own class
 *
 */
public class FamilyMember implements Serializable{

    @Override
    public String toString() {
        //displays a nice string representation of a perosn. the () means they have
        //a maiden name and it uses the gender symols to identify them
        String s = null;
        if (this.gender == Gender.MALE){
            s = "♂ ";
        }else if (this.gender == Gender.FEMALE){
            s = "♀ ";
        }
        s += this.getFirstName() + " " + this.getLastName();
        if (this.has(Attribute.MAIDENNAME)){
            s += " (" + this.getMaidenName() + ")";
        }
        return s;
    }

    /**
     * Constructs a family tree by using the internal set methods. This allows
     * for validation in a central location making any constructed family member object valid
     * @param firstName
     * @param lastName
     * @param gender
     * @param address
     * @param lifeDescription
     */
    public FamilyMember(String firstName, String lastName, Gender gender, Address address, String lifeDescription) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.maidenName = "";
        this.setGender(gender);
        this.setAddress(address);
        this.setLifeDescription(lifeDescription);

        this.mother = null;
        this.father = null;
        this.spouse = null;
        this.children = new ArrayList<>();
    }
    private String firstName;
    private String lastName;
    private String maidenName;
    private Gender gender;
    private Address address;
    private String lifeDescription;
    //regex to match for a valid name. allows any unicode characters with some
    //special cases such as King Henry Jr. or L'ourve D'Marche
    private final String nameRegex = "^[\\p{L} .'-]+$";

    private FamilyMember mother;
    private FamilyMember father;
    private FamilyMember spouse;
    private ArrayList<FamilyMember> children;

    /**
     * Attribute types used to check if a family member has any of these attributes
     */
    public enum Attribute {
        FATHER,
        MOTHER,
        CHILDREN,
        SPOUSE,
        MAIDENNAME,
        PARENTS;
    }

    /**
     * Relative types used to add relatives to a family member
     */
    public enum RelativeType {
        FATHER,
        MOTHER,
        CHILD,
        SPOUSE;
    }

    /**
     * Gender types to ensure only two genders
     */
    public enum Gender {
        MALE,
        FEMALE;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public final void setFirstName(String firstName) {
        if (firstName.trim().matches(nameRegex)) {
            this.firstName = firstName.trim();
        }else{
            throw new IllegalArgumentException("Invalid First Name");
        }

    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name and validates against the regex
     * @param lastName the lastName to set
     */
    public final void setLastName(String lastName) {
        if (lastName.trim().matches(nameRegex)) {
            this.lastName = lastName.trim();
        }else{
            throw new IllegalArgumentException("Invalid Last Name");
        }
    }

    /**
     * @return the maidenName
     */
    public String getMaidenName() {
        return maidenName;
    }

    /**
     * ensures only females have maiden names and validates it
     * @param maidenName the maidenName to set
     */
    public void setMaidenName(String maidenName) {
        if (maidenName.trim().matches(nameRegex)) {
            if (this.gender == Gender.FEMALE){
                this.maidenName = maidenName.trim();
            }else{
                throw new IllegalArgumentException("Mainden name is only for females");
            }

        }else if (maidenName.isEmpty()){
            this.maidenName = "";
        }else{
            throw new IllegalArgumentException("Invalid Maiden Name");
        }
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public final void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public final void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the lifeDescription
     */
    public String getLifeDescription() {
        return lifeDescription;
    }

    /**
     * @param lifeDescription the lifeDescription to set
     */
    public final void setLifeDescription(String lifeDescription) {
//        if (!lifeDescription.trim().isEmpty()) {
//            this.lifeDescription = lifeDescription;
//        }else{
//            throw new IllegalArgumentException("Description cant be empty");
//        }
// Decided to keep this field optional as there really is no need for a description to be mandatory
        this.lifeDescription = lifeDescription;

    }

    /**
     * adds a child to the family member. Consequently adding the spouse and the current
     * family member as the parents if they exist
     * @param child the child to add to set of children
     */
    public void addChild(FamilyMember child) {
        //father
        if (this.gender == Gender.MALE) {
            //if the child doesnt have a father set it
            if (!child.has(Attribute.FATHER)) {
                child.setFather(this);
            }
            //if the family member has a spouse set it as the mother
            if (this.has(Attribute.SPOUSE)) {
                if (!child.has(Attribute.MOTHER)) {
                    child.setMother(this.getSpouse());
                }
            }
            //mother
        }else if (this.gender == Gender.FEMALE){
            //if the child doesnt have a mother set it
            if (!child.has(Attribute.MOTHER)) {
                child.setMother(this);
            }
            //if the family member has a spouse set it as the father
            if (this.has(Attribute.SPOUSE)) {
                if (!child.has(Attribute.FATHER)) {
                    child.setFather(this.getSpouse());
                }
            }
        }
        //make sure no dupicate children objects
        if(!this.getChildren().contains(child)){
            this.getChildren().add(child);
        }

    }

    /**
     * retuns the number of children for this member
     * @return
     */

    public int numChildren(){
        return this.getChildren().size();
    }

    /**
     * @return the mother
     */
    public FamilyMember getMother() {
        return mother;
    }

    /**
     * sets the mother and makes sure it is a female. it also adds the current m
     * member as a child to the mother
     * A member can only have one mother
     * @param mother the mother to set
     */
    public void setMother(FamilyMember mother) {
        if (!this.has(Attribute.MOTHER)) {
            if (mother.getGender() == Gender.FEMALE) {
                if (!mother.getChildren().contains(this)){
                    mother.getChildren().add(this);
                }
                this.mother = mother;


            }else{
                throw new IllegalArgumentException("Mother can only be female");
            }

        }else{
            throw new IllegalArgumentException("Mother already added");
        }

    }

    /**
     * @return the father
     */
    public FamilyMember getFather() {
        return father;
    }

    /**
     * sets the father and makes sure it is a male. it also adds the current
     * member as a child to the father
     * A member can only have one father
     * @param father the father to set
     */
    public void setFather(FamilyMember father) {
        if (!this.has(Attribute.FATHER)) {
            if (father.getGender() == Gender.MALE) {
                if (!father.getChildren().contains(this)){
                    father.getChildren().add(this);
                }
                this.father = father;


            }else{
                throw new IllegalArgumentException("Father can only be male");
            }

        }else{
            throw new IllegalArgumentException("Father already added");
        }

    }

    /**
     * @return the spouse
     */
    public FamilyMember getSpouse() {
        return spouse;
    }

    /**
     * sets the spouse of the member. a spouse must be the opposite gender and a
     * member can have only one spouse
     * @param spouse the spouse to set
     */
    public void setSpouse(FamilyMember spouse) {
        if (!this.has(Attribute.SPOUSE)) {
            if(spouse.getGender() != this.getGender()){
                spouse.setChildren(this.getChildren());
                this.spouse = spouse;
                if (!this.getSpouse().has(Attribute.SPOUSE)) {
                    spouse.setSpouse(this);
                }

            }else{
                throw new IllegalArgumentException("Spouse can only be opposite gender");
            }
        }else{
            throw new IllegalArgumentException("Spouse already exists");
        }

    }

    /**
     * @return the children
     */
    public ArrayList<FamilyMember> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<FamilyMember> children) {
        this.children = children;
    }

    /**
     * checks if the member has a specific type of attribute
     * @param type the attribute type to check
     * @return true if the conditions are met
     */
    public boolean has(FamilyMember.Attribute type){
        switch(type){
            case FATHER:
                return this.getFather() != null;
            case CHILDREN:
                return !this.getChildren().isEmpty();
            case MOTHER:
                return this.getMother() != null;
            case SPOUSE:
                return this.getSpouse() != null;
            case MAIDENNAME:
                return !this.getMaidenName().isEmpty();
            case PARENTS:
                return this.has(Attribute.FATHER) || this.has(Attribute.MOTHER);
        }
        return false;
    }

    /**
     * adds a relative based on the specified type variable. Basically a convenience method
     * @param type the type of the added member
     * @param member the member to add
     */
    public void addRelative(FamilyMember.RelativeType type, FamilyMember member){
        switch(type){
            case FATHER:
                this.setFather(member);
                return;
            case CHILD:
                this.addChild(member);
                return;
            case MOTHER:
                this.setMother(member);
                return;
            case SPOUSE:
                this.setSpouse(member);
                return;
        }
    }
}
