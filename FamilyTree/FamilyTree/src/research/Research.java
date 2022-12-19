package research;

import people.Humans;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Research {

    public Research() {
    }

    public void getFormatTxt(List<List> people, String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        for (List str : people) {
            writer.write(str+System.getProperty("line.separator") + "\n");
        }

        writer.close();
    }

}
