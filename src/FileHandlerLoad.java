import java.io.*;

public class FileHandlerLoad implements DataLoad {
    private String loadDataFromText(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();
        System.out.println("Данные восстановлены");
        return stringBuilder.toString();
    }

    private String loadDataFromXml(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();
        System.out.println("Данные восстановлены");
        return stringBuilder.toString();
    }

    @Override
    public String loadData(String fileName) throws Exception {
        if (fileName.endsWith(".txt")) {
            return loadDataFromText(fileName);
        } else if (fileName.endsWith(".xml")) {
            return loadDataFromXml(fileName);
        } else {
            throw new Exception("Неподдерживаемый формат");
        }

    }
}
