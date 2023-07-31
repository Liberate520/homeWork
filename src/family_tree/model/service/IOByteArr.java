package family_tree.model.service;


import family_tree.model.familytree.FamilyTree;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class IOByteArr implements Writable {
    @Override
    //Сериализация с помощью класса ByteArrayOutputStream
    public boolean save(Serializable serializable) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
        String fileName = format.format(date);
        String filePath = "src/family_tree/model/in_out_files/"+fileName+".txt";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(serializable);
            byte[] bytes = baos.toByteArray();
            String bytesStr = Arrays.toString(bytes);
            FileWriter fw = new FileWriter(filePath, false);
            fw.write(bytesStr);
            fw.flush();
            oos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    // Десериализация с помощью класса ByteArrayInputStream
    public Object read(String fileName) {
        String filePath = "src/family_tree/model/in_out_files/"+fileName;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String[] strArr = br.readLine().replaceAll("\\[|\\]", "").split(",");
            byte[] bytes = new byte[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                bytes[i] = Byte.parseByte(strArr[i].trim());
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            FamilyTree tree = (FamilyTree) ois.readObject();
            ois.close();
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
