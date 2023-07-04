import java.util.ArrayList;
import java.util.List;

public class Human {
        private int id;
        private static int count = 1;

        private String lastName;
        private String firstName;
        private String fullName;

        private List<Human> parents;

        private List<Human> children;
        private Gender gender;

        public Human(String lastName, String firstName, Gender gender, Human father, Human mother) {
                this.lastName = lastName;
                this.firstName = firstName;
                this.gender = gender;
                fullName = lastName + " " + firstName;
                parents = new ArrayList<>();
                if (father != null) {
                        parents.add(father);
                }
                if (mother != null) {
                        parents.add(mother);
                }
                children = new ArrayList<>();

        }
        public Human(String lastName, String firstName, Gender gender) {
                this(lastName, firstName, gender, null, null);
                id = count++;
                fullName = lastName + " " + firstName;
        }
        public int getId() {
                return id;
        }
        public String getLastName() {
                return lastName;
        }
        public String getFirstName() {
                return firstName;
        }

        public String getFullName() {
                return fullName;
        }

        public Gender getGender() { return gender; }

        public void addParent (Human parent){
                if(!parents.contains(parent)) parents.add(parent);
        }
        public void addChild(Human child){
                if (!children.contains(child)) children.add(child);
        }
        public List<Human> getParents(){
                return parents;
        }
        public List<Human> getChildren(){
                return children;
        }
        public Human getFather() {
                for (Human parent : parents) {
                        if (parent.getGender() == Gender.Male)
                                return parent;
                }
                return null;
        }
        public Human getMother() {
                for (Human parent: parents) {
                        if (parent.getGender() == Gender.Female){
                                return parent;
                        }
                }
                return null;
        }
        public String getInfo (){
                StringBuilder builder = new StringBuilder();
                builder.append("Name: ");
                builder.append(fullName);
                builder.append(" | ");
                builder.append(getFatherInfo());
                builder.append(" | ");
                builder.append(getMotherInfo());
                builder.append(" | ");
                builder.append(getChildrenInfo());
                return builder.toString();
        }

        public String getFatherInfo(){
                String dad;
                Human human = getFather();
                if (human != null){
                        dad = "dad: " + human.getFullName();
                }
                else {
                        dad = "dad: no";
                }
                return dad;
        }
        public String getMotherInfo(){
                String mom;
                Human mother = getMother();
                if (mother != null){
                        mom = "mom: " + mother.getFullName();
                }
                else {
                        mom = "mom: no";
                }
                return mom;
        }
        public String getChildrenInfo() {
                StringBuilder lst = new StringBuilder();
                lst.append("kids: ");
                if (children.size() != 0) {
                        for (int i = 0; i < children.size(); i++) {
                                if (i != children.size()-1) {
                                        lst.append(children.get(i).getFullName());
                                        lst.append(", ");
                                }
                                else lst.append(children.get(i).getFullName());
                        }
                }
                else lst.append("no");
                return lst.toString();
        }
        @Override
        public boolean equals(Object obj){
                if(this == obj){
                        return true;
                }
                if(!(obj instanceof Human)){
                        return false;
                }
                Human human = (Human) obj;
                return human.getFullName().equals(getFullName());
        }




}
