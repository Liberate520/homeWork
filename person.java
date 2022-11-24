import java.util.ArrayList;

class Person {
    static int id = 0;
    private String name;
    private int year;
    private int month;
    private int day;
    private int father_id;
    private int mother_id;
    private int partner;


    public static int getId() {
        return id;
    }




    public String getName() {
        return name;
    }




    public int getYear() {
        return year;
    }




    public int getMonth() {
        return month;
    }




    public int getDay() {
        return day;
    }




    public int getFather_id() {
        return father_id;
    }
    

    public int getMother_id() {
        return mother_id;
    }
    

    public int getPartner() {
        return partner;
    }




    public Person(String name, int year, int month, int day, int father_id, int mother_id, int partner) {
        id++;
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.father_id = father_id;
        this.mother_id = mother_id;
        this.partner = partner;
    }

  


    public Person(String [] data) {
        id++;
        this.name = data[1];
        if (data[2] =="" ) this.year = -1;
        else this.year = Integer.parseInt(data[2]);
        if (data[3] == "" ) this.month = -1;
        else this.month = Integer.parseInt(data[3]);
        if (data[4] =="" ) this.day = -1;
        else this.day = Integer.parseInt(data[4]);
        if (data[5] =="" ) this.father_id = -1 ;
        else this.father_id = Integer.parseInt(data[5]);
        if (data[6] =="" ) this.mother_id = -1;
        else this.mother_id = Integer.parseInt(data[6]);
        if (data[7] =="" ) this.partner = -1;
        else this.partner = Integer.parseInt(data[7]);
    }



    public static ArrayList<Person> find_child(Person parent, ArrayList<Person> base) {
        ArrayList<Person> children = new ArrayList<>();
        for (Person person : base) {
            if (person.father_id == parent.id) children.add(person);
        }
        return children;
    }
}


