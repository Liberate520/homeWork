package OOP_DZ.DZ5.notebook.storage;

import OOP_DZ.DZ5.notebook.records.Record;
import OOP_DZ.DZ5.notebook.records.RecordsList;

import java.io.*;

public class File implements Storage {
    public RecordsList recordsList;

    public File(RecordsList recordsList) {
        this.recordsList = recordsList;
    }


    @Override
    public RecordsList read() {
        try {
            String pathProject = System.getProperty("user.dir");
            String taskPath = "\\src\\OOP_DZ\\DZ5\\files\\";
            String pathFile = pathProject.concat(taskPath + "file2.txt");
            FileReader fr = new FileReader(pathFile);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                recordsList.addRecord(new Record(line, count));
                line = reader.readLine();
                count++;
            }
            for (Record item : recordsList.getRecords()) {
                item.setCreateTime("");
            }
            return recordsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void write() {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("\\src\\OOP_DZ\\DZ5\\files\\file2.txt");
            java.io.File file = new java.io.File(pathFile);
            FileWriter fileWriter = new FileWriter(file, false);
            StringBuilder sb = new StringBuilder();
            for (Record item : recordsList.getRecords()) {
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
