public class Human {
    private String name; // Имя

    private int dob; //  дата рождения
    private int dod; //  дата смерти

    public Human(String name, int dob, int dod){
        this.name = name;

        this.dob = dob;
        this.dod = dod;
    }

    public Human(String name,int dob) {

        this.name = name;
        this.dob = dob;
    }

    public Human(){

    }

    public String getName(){

        return name;
    }

    public int getDob(){

        return dob;
    }
    public int getDod(){

        return dod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public void setDod(int dod) {
        this.dod = dod;
    }

    public String relativeLog(){  // метод показывает ордственную связь
        if(name == "Mary"){
            System.out.println("Дети Mary,Ivan и Anna");
        }
        else if (name == "Genry") {
            System.out.println("Дети Genry, Ivan и Anna");
        }
        else if (name == "Ivan") {
            System.out.println("Родители Ivan, Mary и Genry");
        }
        else if (name == "Anna") {
            System.out.println("Родители Anna, Mary и Genry");
        }
        else if (name == "Inga") {
            System.out.println("Родители Inga, Ivan");
        }
        else if (name == "David") {
            System.out.println("Дети David, Mary");
        }
        return null;

    }

    @Override
    public String toString(){

        return name + " " + dob + " " + dod;
    }
}
