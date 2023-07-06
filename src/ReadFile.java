import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFile {
	public static  void main (String[] args) throws IOException, ClassNotFoundException {
		String s = File.separator;
		FileInputStream fis = new FileInputStream("src" + s + "familyTree.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		FamilyTree ft = (FamilyTree) ois.readObject();
		ois.close();
		System.out.println(ft);
	}
}
