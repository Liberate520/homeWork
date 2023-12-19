package io;

import model.GenealogyTree;
import model.FamilyMember;

import java.io.IOException;

// Интерфейс для записи и чтения из файла
public interface FileHandler {
    <T extends FamilyMember> void writeToFile(String filename, GenealogyTree<T> genealogyTree) throws IOException;
    <T extends FamilyMember> GenealogyTree<T> readFromFile(String filename) throws IOException;
}