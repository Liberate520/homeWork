package write_read;

import java.io.Serializable;

public interface Saveable<E> {
	boolean save(Serializable serializable, String filePath);
	Object load(String filePath);
}
