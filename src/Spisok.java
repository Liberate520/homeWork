public class Spisok {
    private String name;
    private String sername;

    public Spisok(String name, String sername) {
        this.name = name;
        this.sername = sername;
    }

    @Override
    public String toString() {
        return  name + " " +
                sername + " " ;
    }
}