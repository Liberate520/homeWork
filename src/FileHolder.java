import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHolder implements Writable{
    @Override
    public void output(Person man) { //не понимаю как это работает, тупо скопировал, засунул в try with resources и все.
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("database.txt"))) {
            objectOutputStream.writeObject(man);
        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }

    @Override
    public Person input() { //не понял как эти потоки работают, мы такое не проходили. Надеюсь на третьем семинаре разобрали. Там буду смотреть.
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("database.txt"))) {
            Person man = (Person) objectInputStream.readObject();
            return man; //возвращать в 26 строчке не хочет.
        }catch (Exception e){
            System.out.println("Error" +e);
        }
        return null;
    }


}
