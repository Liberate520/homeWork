import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Human implements IStream{


    protected int id;
    private String Name;
    private String Surname;


    public Human(int id) {
        this.id = id;
        Name = "";
        Surname = "";
    }

    public Human(int id, String name, String surname) {
        this(id);
        this.Name = name;
        this.Surname = surname;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + Name + " " + Surname;
    }

    //запись данных в поток
    public void save(DataOutputStream stream_out) throws IOException {
        stream_out.writeInt(id);
        stream_out.writeUTF(Name);
        stream_out.writeUTF(Surname);
    }

    //чтение для Human из потока
    public void load(DataInputStream stream_in) throws IOException {
        int id = stream_in.readInt();
        String name = stream_in.readUTF();
        String surname = stream_in.readUTF();

        this.id = id;
        this.Name = name;
        this.Surname = surname;
    }
}