package com.romanovcopy.gmail.Genealogy;

import java.util.Scanner;

public class Program {
    public static Service service;
    public static String path;
    public static void main(String[] args) {
        path="MyGraph.dat";
        service = new Service();
        service.close();
    }


}
