package org.example.model.editing.date;

import org.example.model.Human;
import org.example.model.Tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class DateDeath extends DateHuman{
    @Override
    public void dateCreator(String date, Integer index, Tree<Human> tree) {
        ArrayList<String> dateL = new ArrayList<>(Arrays.asList(date.split(" ")));
        tree.getBigFamily().get(index).setDateOfDeath(LocalDate.of(Integer.parseInt(dateL.get(2)),
                Integer.parseInt(dateL.get(1)), Integer.parseInt(dateL.get(0))));
    }
}
