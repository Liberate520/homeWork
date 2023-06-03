package write_read;

import tree.FamilyTree;

import java.io.*;
import java.io.Serializable;

public class FileHandler implements Saveable {
	
	public FamilyTree loadFile(String str) {
		FamilyTree familyTree = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str))) {
			familyTree = (FamilyTree) ois.readObject();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return familyTree;
	}
	
	public void saveFile(FamilyTree familyTree, String str) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str))) {
			oos.writeObject(familyTree);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	/*@Override
	public boolean save(Serializable serializable, String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(serializable);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Object load(String filePath) {
		try (FileInputStream fis = new FileInputStream(filePath);
			 ObjectInputStream ois = new ObjectInputStream(fis)) {
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}*/
}
