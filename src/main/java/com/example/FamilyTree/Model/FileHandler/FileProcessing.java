package com.example.FamilyTree.Model.FileHandler;

import com.example.FamilyTree.DataForTree.FamilyTree;

import java.io.Serializable;

public interface FileProcessing {
    void save(String path, Serializable object);
    FamilyTree read(String path);
}
