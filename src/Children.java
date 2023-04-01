public class Children extends Human {
    private Parent mather, father;

    Children(String firstName, String secondName, int day, int month, int year, String sex, Parent p1, Parent p2) {
        super(firstName, secondName, day, month, year, sex);

        addParent(p1, p2);

        // if (p1.getSex() == "Female") {
        //     this.mather = p1;
        // }
        // else {
        //     this.mather = p1;
        // }

        // if (p2.getSex() == "Female") {
        //     this.mather = p2;
        // }
        // else {
        //     this.mather = p2;
        // }

    }

    Children(Human person, Parent mather, Parent father) {
        this(person.getFirstName(), person.getLastName(), person.getDay(),
            person.getMonth(), person.getYear(), person.getSex(), mather, father);
    }

    Children(Human person, Parent p) {
        this(person.getFirstName(), person.getLastName(), person.getDay(),
        person.getMonth(), person.getYear(), person.getSex(), p, p);
    }

    // Children(Human person) {
    //     this(person.getFirstName(), person.getSecondName(), person.getDay(),
    //         person.getMonth(), person.getYear(), person.getSex(), mather, father);
    // }

    public void addParent(Parent m, Parent f) {
        addParent(f);
        addParent(m);
    }

    public void addParent(Parent p) {
        if (p.getSex() == "Female") this.mather = p;
        if (p.getSex() == "Male") this.father = p;
    }

    public Parent getMather() {
        return mather;
    }

    public Parent getFather() {
        return father;
    }
    
}
