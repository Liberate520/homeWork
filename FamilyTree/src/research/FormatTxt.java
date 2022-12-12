package research;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FormatTxt {

    public FormatTxt() {
    }

    /**
         * Создание текстого файла (вынести в отдельный класс)
         */
           public void getFormatTxt(List<List> people, String path) throws IOException {
                FileWriter writer = new FileWriter(path);
                for (List str : people) {
                    writer.write(str+System.getProperty("line.separator") + "\n");
                }

               writer.close();
            }



}
