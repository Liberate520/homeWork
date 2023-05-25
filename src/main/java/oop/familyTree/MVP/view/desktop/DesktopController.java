package oop.familyTree.MVP.view.desktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import oop.familyTree.MVP.presenter.Presenter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DesktopController implements Action {

    private static final Presenter PRESENTER = new Presenter();
    @FXML
    private AnchorPane root;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button addNewHuman;
    @FXML
    private Button addNewTree;
    @FXML
    private Button allHumans;
    @FXML
    private Button allTrees;
    @FXML
    private Button dates;
    @FXML
    private Button exit;
    @FXML
    private Button fullName;
    @FXML
    private Button gender;
    @FXML
    private Label info;
    @FXML
    private ListView<String> infoFamilyTree;
    @FXML
    private Button infoPartners;
    @FXML
    private Button infoSelectedFT;
    @FXML
    private Label lbAllTrees;
    @FXML
    private ListView<String> listAllHuman;
    @FXML
    private ListView<String> listAllTrees;
    @FXML
    private ListView<String> listInformationAboutHuman;
    @FXML
    private TextField nameNewTree;
    @FXML
    private TextField newChildren;
    @FXML
    private DatePicker newDateOfBirth;
    @FXML
    private DatePicker newDateOfDeath;
    @FXML
    private TextField newFatherName;
    @FXML
    private TextField newFullName;
    @FXML
    private TextField newGender;
    @FXML
    private Button newHuman;
    @FXML
    private TextField newMatherName;
    @FXML
    private TextField newSpouse;
    @FXML
    private Button newTree;
    @FXML
    private Pane paneInfoHuman;
    @FXML
    private Pane paneNewHuman;
    @FXML
    private Pane paneNewTree;
    @FXML
    private Button save;
    @FXML
    private Button selectHuman;
    @FXML
    private Label titleFT;
    @FXML
    private Label titleFT1;
    @FXML
    private Label titleHuman;

    // #Методы из интерфейса Action
    @Override
    public void getListFX(ListView<String> listView, List<String> list){
        listView.setItems(FXCollections.observableArrayList(list));
    }

    @Override
    public void showHideLayout(Pane pane){
        boolean showOrHide = pane.isVisible();
        pane.setVisible(!showOrHide);
    }
    @Override
    public void showHideControl(Control control){
        boolean showOrHide = control.isVisible();
        control.setVisible(!showOrHide);
    }

    @Override
    public void monitoringChangeList(ListView<String> list, Label label){
        MultipleSelectionModel<String> selectionModel = list.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(
            (observableValue, oldV, newV) -> {
                if (!label.getText().isEmpty()){
                    label.setText("");
                }
                label.setText(newV);
            });
    }

    // #Конец

    // # Методы для контролов формы

    /**
     * Отображение списка всех древ
     */
    @FXML
    public void showNameFamilyTree(){
        this.getListFX(listAllTrees, PRESENTER.getNameFamilyTree());
        this.monitoringChangeList(listAllTrees, titleFT1);
        this.showHideControl(allTrees);
    }

    /**
     * По нажатию кнопки визуализируется окно
     * для создания нового древа
     */
    @FXML
    public void btnNewTreeClick(){
        if(!paneNewTree.isVisible()) this.newTree.setText("В процессе...");
        else this.newTree.setText("Создать новое");
        this.showHideLayout(paneNewTree);
    }

    /**
     * По нажатию кнопки добавляется новое древо
     */
    @FXML
    public void addNewTree(){
        if (!nameNewTree.getText().isEmpty()) {
            PRESENTER.createNewTree(nameNewTree.getText());
            List<String> col = PRESENTER.getNameFamilyTree();
            ObservableList<String> observableList = FXCollections.observableArrayList(col);
            listAllTrees.setItems(observableList);
            this.monitoringChangeList(listAllTrees, titleFT1);
            paneNewTree.setVisible(false);
            allTrees.setDisable(false);
            nameNewTree.setText("");
            newTree.setText("Создать новое");
        }
        else {
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setTitle("Информация");
            message.setHeaderText("Ничего не добавлено");
            message.setContentText("Введите имя древа");
            message.showAndWait();
        }
    }

    /**
     * По нажатию кнопки отображается информация
     * о выбранном древе
     */
    public void infoAboutSelectedTree(){
        if (!titleFT1.getText().isEmpty()) {
            String treeName = titleFT1.getText();
            this.getListFX(infoFamilyTree, PRESENTER.showFamilyTree(treeName));
            infoFamilyTree.setVisible(true);
            info.setText("Файл загружен");
        }
        else {
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setTitle("Информация");
            message.setHeaderText("Не выбрано древо");
            message.setContentText("Выберите имя древа");
            message.showAndWait();
            info.setText("");
        }
    }

    /**
     * По нажатию кнопки визуализируется окно
     * для добавления нового человека
     */
    public void btnNewHumanClick(){
        info.setText("");
        this.showHideControl(info);
        this.showHideControl(infoFamilyTree);
        this.showHideLayout(paneNewHuman);
    }

    /**
     * По нажатию кнопки добавляется новый человек
     */
    public void addNewHuman(){
        PRESENTER.addNewHuman(titleFT1.getText(),
                newFullName.getText(), newGender.getText(),
                newDateOfBirth.getValue(), newDateOfDeath.getValue(),
                newMatherName.getText(), newFatherName.getText(),
                newSpouse.getText(), newChildren.getText());
        this.infoAboutSelectedTree();
        this.showHideLayout(paneNewHuman);
    }

    // #Конец
}
