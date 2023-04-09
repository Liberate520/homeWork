package io;

import geotree.GeoTree;

import java.io.IOException;

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
}
