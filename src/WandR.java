import java.io.Serializable;

public interface WandR {
	boolean writeFile(Serializable serializable, String path);
	Object readFile(String path);
}
