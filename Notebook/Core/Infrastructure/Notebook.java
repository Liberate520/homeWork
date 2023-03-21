package Notebook.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Notebook.Core.Models.Recording;

public class Notebook {
    private List<Recording> records;

    public Notebook() {
        records = new ArrayList<>();
    }
}
