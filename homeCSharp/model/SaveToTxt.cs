namespace GeekBrains;


public class SaveToTxt: Saveable {

    private String path = "123.txt";
    
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
