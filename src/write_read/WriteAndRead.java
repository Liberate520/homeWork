package write_read;

import java.io.*;

public class WriteAndRead {
	public boolean writeFile(String path, Serializable serializable) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(serializable);
		oos.close();
		return true;
	}
	public Object readFile(String path) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		return  ois.readObject();

	}
}
