import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Human implements IStream {
    enum Gender {
        MALE,
        FEMALE
    }

    protected int id;
    private String Name;
    private String Surname;
    private Gender gender;

    public Human(int id, String name, String surname, Gender gender) {
        this.id = id;
        this.Name = name;
        this.Surname = surname;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + Name + " " + Surname + " " + gender;
    }

    @Override
    public void save(DataOutputStream stream_out) throws IOException {
        stream_out.writeInt(id);
        stream_out.writeUTF(Name);
        stream_out.writeUTF(Surname);
        int igender = 0;
        if (gender == Gender.FEMALE)
            igender = 1;
        stream_out.writeInt(igender);
    }

    @Override
    public void load(DataInputStream stream_in) throws IOException {
        int id = stream_in.readInt();
        String name = stream_in.readUTF();
        String surname = stream_in.readUTF();
        int igender = stream_in.readInt();
        Gender gender = Gender.MALE;
        if (igender == 1)
            gender = Gender.FEMALE;
    }
}