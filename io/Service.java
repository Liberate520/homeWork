package homeWork.io;

import java.io.IOException;

import homeWork.geotree.GeoTree;

public class Service {
    private GeoTreeIO gtio;
    private GeoTree gt;
     public Service(GeoTreeIO gtio, GeoTree gt){
        this.gtio = gtio;
        this.gt = gt;
    }
    public void saveTree() throws IOException {
        this.gtio.write(gt);
    }

    public GeoTree restoreTree() throws IOException, ClassNotFoundException {
        try {
            return this.gtio.read();
        } catch (IOException e) {
            saveTree();
            return this.gtio.read();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}