import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public interface Writable {

    void output(Person man);
    Person input ();
}
