package familytree.model;

public class TreeEntity {
    private String name;
    private String dob;

    public TreeEntity(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return dob;
    }
}
