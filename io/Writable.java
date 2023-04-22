package io;

import java.io.IOException;

import geotree.GeoTree;

public interface Writable {
    void write(GeoTree geo) throws IOException;
}