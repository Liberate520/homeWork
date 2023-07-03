package com.romanovcopy.gmail.Genealogy;

import java.time.LocalDate;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

    private static Scanner scanner;
    public static Service service;

    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        service = new Service(scanner);
        scanner.close();
    }


}
