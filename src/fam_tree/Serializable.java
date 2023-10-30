package fam_tree;

public class Serializable {
    private String login;
    private transient String password;

    public void Logon(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Logon{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logon igor = new Logon("IgorIvanovich", "Khoziain");
        Logon renat = new Logon("Renat", "2500RUB");
        System.out.println("Before: \n" + igor);
        System.out.println(renat);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Externals.out"));
        out.writeObject(igor);
        out.writeObject(renat);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Externals.out"));
        igor = (Logon) in.readObject();
        renat = (Logon) in.readObject();

        System.out.println("After: \n" + igor);
        System.out.println(renat);
    }
}
