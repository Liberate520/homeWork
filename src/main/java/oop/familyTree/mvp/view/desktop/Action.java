package oop.familyTree.mvp.view.desktop;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.List;

public interface Action {

    /**
     * Коллекция списка ListView
     * @param listView контрол ListView
     * @param list передаваемый список
     */
    void getListFX(ListView<String> listView, List<String> list);

    /**
     * Отслеживание выбора в ListView
     * @param list ListView
     * @param label метка с отображением выбора
     */
    void monitoringChangeList(ListView<String> list, Label label);

    /**
     * Отображение или скрытие контейнера Pane
     * @param pane Pane
     */
    void showHideLayout(Pane pane);

    /**
     * Отображение или скрытие контрола
     * @param control Control
     */
    void showHideControl(Control control);
}
