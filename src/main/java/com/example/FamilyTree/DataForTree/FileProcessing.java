package com.example.FamilyTree.DataForTree;

import com.example.FamilyTree.FamilyTree;

import java.io.Serializable;

public interface FileProcessing {
    void save(String path, Serializable object);
    FamilyTree read(String path);
}
