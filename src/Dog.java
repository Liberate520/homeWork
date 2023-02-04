public class Dog extends Animal {
    private String name;
    private Dog mom;
    private Dog dad;
    private int breed;

    public Dog(String name,int breed, Dog mom, Dog dad) {
        this.name = name;
        this.mom = mom;
        this.dad = dad;
    }

    public Dog(String name, int breed) {
        this.name = name;
        this.breed = breed;
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMom(Dog mom) {
        this.mom = mom;
    }

    public Dog getMom() {
        return mom;
    }

    public Dog getDad() {
        return dad;
    }

    public void setDad(Dog dad) {
        this.dad = dad;
    }

        public String toString(){
                return "name:" + name + ", breed:" +
                        ", mom:" + mom + ", dad:" + dad;
        }
}
