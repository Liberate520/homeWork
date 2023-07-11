package family_tree;


import java.io.*;
import java.util.Arrays;

public class WRbyByteArrIOStream {
    //Сериализация с помощью класса ByteArrayOutputStream
    public void WriteByte(FamilyTree tree, String fileName) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(tree);
        byte[] bytes = baos.toByteArray();
        String bytesStr = Arrays.toString(bytes);
        FileWriter fw = new FileWriter(fileName, false);
        fw.write(bytesStr);
        fw.flush();
        oos.flush();
    }

    // Десериализация с помощью класса ByteArrayInputStream
    public FamilyTree ReadByte(String fileName) throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
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
    }
}
