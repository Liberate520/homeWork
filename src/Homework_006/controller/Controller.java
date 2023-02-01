package Homework_006.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Homework_006.view.*;
import Homework_006.model.*;

public class Controller<T extends BaseType> {
    private View view;
    private FamilyTreeService service;

    public Controller(View view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
        view.setController(this);
    }

    public View getView() {
        return this.view;
    }

    public void execRead() throws ClassNotFoundException, IOException {
        view.answer(service.read());
    }

    public void execShow() {
        view.answer(service.show());
    }

    public void execSortById() {
        view.answer(service.sortById());
    }

    public void execSortByDate() {
        view.answer(service.sortByDate());
    }

    public void execSave() throws ClassNotFoundException, IOException {
        service.save();
    }

    public void execCommandExit() {
        return;
    }

    public void execCreateNode(ArrayList<String> prop) {
        service.createNode(prop);
    }

    public void execSetParent(int[] ids) {
        boolean check0 = service.checkId(ids[0]);
        boolean check1 = service.checkId(ids[1]);
        if (check0 == true && check1 == true) {
            service.svSetParent(ids);
        } else if (check0 == false && check1 == true) {
            view.answerIdAbsent(ids[0]);
        } else if (check0 == true && check1 == false) {
            view.answerIdAbsent(ids[1]);
        } else {
            view.answerIdAbsent(-1);
        }
    }

    public void execShowParents(int id) {
        boolean check = service.checkId(id);
        if (check == true) {
            List<T> parents = service.showParents(id);
            if (parents.size() == 0) {
                view.answerNoData();
            } else {
                view.answer(parents);
            }
        } else {
            view.answerIdAbsent(id);
        }
    }

    public void execShowBrothersAndSisters(int id) {
        boolean check = service.checkId(id);
        if (check == true) {
            List<T> broAndSis = service.showBrothersAndSisters(id);
            if (broAndSis.size() == 0) {
                view.answerNoData();
            } else {
                view.answer(broAndSis);
            }
        } else {
            view.answerIdAbsent(id);
        }
    }

}
