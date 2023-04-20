package geotree;

import geotree.GeoTree;
import io.GeoTreeIO;
import person.Gender;
import person.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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

    public void restoreTree() throws IOException, ClassNotFoundException {
        try {
            this.gtio.read();
        } catch (IOException e) {
            saveTree();
            this.gtio.read();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public GeoTree getGt() {
        return gt;
    }
}
