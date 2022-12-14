namespace GeekBrains;

public class SaveToDoc: Saveable {

    private String path = "321.doc";
    
    public void saveAs(String human){
        File.WriteAllText(path, human);
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
