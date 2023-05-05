import java.io.Serializable;

public interface Saveable {
	boolean save(Serializable serializable, String filePath);
	Object load(String filePath);
}
