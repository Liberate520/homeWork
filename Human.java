
public class Human {

        private int age;
        private String name;
        private String gender;
        private int id;
    
        public Human(int age, String name, String gender, int id) {
            this.age = age;
            this.name = name;
            this.gender = gender;
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public int getAge() {
            return age;
        }
    
        public int getId() {
            return id;
        }
    
        public String getGender() {
            return gender;
        }
    
        @Override
        public String toString() {
            return "name: " + name + ",age: " + age + ",id: " + id + ",gender: " + gender;
        }
    }   
