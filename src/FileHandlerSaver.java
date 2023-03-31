import java.io.*;

public class FileHandlerSaver implements DataSave {
    private void saveDataToText(String familyTree, String fileName) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(familyTree);
        writer.close();
    }

    private void saveDataToXml(String familyTree, String fileName) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(familyTree);
        writer.close();
    }


    @Override
    public void saveData(FamilyTree familyTree, String fileName) throws Exception {
        if (fileName.endsWith(".txt")) {
            saveDataToText(familyTree.toString(), fileName);
        } else if (fileName.endsWith(".xml")) {
            saveDataToXml(familyTree.toString(), fileName);
        } else {
            throw new Exception("Неподдерживаемый формат");
        }
        }
    }


