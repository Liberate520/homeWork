package write_read;

import java.io.*;
import java.io.Serializable;

public class FileHandler implements Saveable {
	
	@Override
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
	}
}
