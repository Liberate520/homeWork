package io;

import geotree.GeoTree;

import java.io.IOException;

public interface Writable {
    void write(GeoTree geo) throws IOException;
}