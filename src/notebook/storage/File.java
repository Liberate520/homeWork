package notebook.storage;

import notebook.Record;
import notebook.RecordsList;
import notebook.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File implements Storage {
    private Service service;

    public File() {
        this.service = new RecordsList();
    }

    @Override
    public Service read() {
        try {
            String pathProject = System.getProperty("user.dir");
            String taskPath = "\\src\\files\\";
            String pathFile = pathProject.concat(taskPath + "file2.txt");
            File file = new File();
            FileReader fr = new FileReader(pathFile);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                service.addRecord(new Record(line, count));
                line = reader.readLine();
                count++;
            }
            for (Record item : service.getRecords()) {
                item.setCreateTime("");
            }
            return service;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RecordsList();
    }

    @Override
    public void write(Service service) {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("\\src\\files\\file2.txt");
            java.io.File file = new java.io.File(pathFile);
            FileWriter fileWriter = new FileWriter(file, false);
            StringBuilder sb = new StringBuilder();
            for (Record item : service.getRecords()) {
                sb.append(item.getRecord()).append("\n");
            }
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not a plan(((");
        }
    }
}
