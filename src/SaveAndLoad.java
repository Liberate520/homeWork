import java.io.Serializable;

public interface SaveAndLoad {
    
    void save(Serializable serializable);

    public void load() throws ClassNotFoundException;

}
