import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Spisok implements WriteRead {
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

    @Override
    public void write(Spisok name) {
        try(FileWriter writer = new FileWriter("Person list.txt", true))
        {
            writer.write(String.valueOf(name));
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }


    @Override
    public void read() {
        try(FileReader reader = new FileReader("Person list.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}