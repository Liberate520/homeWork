import java.io.*;

public class WriteFile {
	public static  void main (String[] args) throws IOException {
		FamilyTree ft = new FamilyTree();
		ft.add(new Human("Ivanov", "Ivan", Gender.Male));
		ft.add(new Human("Ivanova", "Irina", Gender.Female));
		ft.add(new Human("Ivanov", "Ignat", Gender.Male,ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));
		ft.add(new Human("Ivanov", "Ibrahim", Gender.Male,ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));
		ft.add(new Human("Ivanova", "Anastasia", Gender.Female,ft.getByName("Ivanov Ivan"), ft.getByName("Ivanova Irina")));
		try {

			String s = File.separator;
			FileOutputStream fos = new FileOutputStream("src" + s + "familyTree.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ft);
			oos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
