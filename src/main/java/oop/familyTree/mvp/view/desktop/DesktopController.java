package oop.familyTree.mvp.view.desktop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oop.familyTree.MainDesktop;
import oop.familyTree.mvp.presenter.Presenter;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class DesktopController extends Application implements Action {

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
    private Label lbInfo;
    @FXML
    private ListView<String> listInfoFamilyTree;
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
    private TextField txFNameNewTree;
    @FXML
    private TextField txFNewChildren;
    @FXML
    private DatePicker dpNewDateOfBirth;
    @FXML
    private DatePicker dpNewDateOfDeath;
    @FXML
    private TextField txFNewFatherName;
    @FXML
    private TextField txFNewFullName;
    @FXML
    private TextField txFNewGender;
    @FXML
    private Button newHuman;
    @FXML
    private TextField txFNewMatherName;
    @FXML
    private TextField txFNewSpouse;
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
    private Label lbTitleFT;
    @FXML
    private Label lbTitleFT1;
    @FXML
    private Label lbTitleHuman;

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
            (observableValue, oldV, newV) -> label.setText(newV));
    }

    // #Конец

    // # Методы для контролов формы

    /**
     * Отображение списка всех древ
     */
    @FXML
    public void showNameFamilyTree(){
        this.getListFX(listAllTrees, PRESENTER.getNameFamilyTree());
        this.monitoringChangeList(listAllTrees, lbTitleFT1);
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
        if (!txFNameNewTree.getText().isEmpty()) {
            PRESENTER.createNewTree(txFNameNewTree.getText());
            List<String> col = PRESENTER.getNameFamilyTree();
            ObservableList<String> observableList = FXCollections.observableArrayList(col);
            listAllTrees.setItems(observableList);

            this.monitoringChangeList(listAllTrees, lbTitleFT1);
            paneNewTree.setVisible(false);
            allTrees.setDisable(false);
            txFNameNewTree.setText("");
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
        if (!lbTitleFT1.getText().isEmpty()) {
            String treeName = lbTitleFT1.getText();
            this.getListFX(listInfoFamilyTree, PRESENTER.showFamilyTree(treeName));
            this.showHideControl(listInfoFamilyTree);
            if (paneNewHuman.isVisible()){
                this.showHideLayout(paneNewHuman);
            }
            lbInfo.setText("Файл загружен");
        }
        else {
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setTitle("Информация");
            message.setHeaderText("Не выбрано древо");
            message.setContentText("Выберите имя древа");
            message.showAndWait();
            lbInfo.setText("");
        }
    }

    /**
     * По нажатию кнопки визуализируется окно
     * для добавления нового человека
     */
    public void btnNewHumanClick(){
        lbInfo.setText("");
        this.showHideControl(lbInfo);
        this.showHideControl(listInfoFamilyTree);
        this.showHideLayout(paneNewHuman);
    }

    /**
     * По нажатию кнопки добавляется новый человек
     */
    public void addNewHuman(){
        PRESENTER.addNewHuman(lbTitleFT1.getText(),
                txFNewFullName.getText(), txFNewGender.getText(),
                dpNewDateOfBirth.getValue(), dpNewDateOfDeath.getValue(),
                txFNewMatherName.getText(), txFNewFatherName.getText(),
                txFNewSpouse.getText(), txFNewChildren.getText());
        this.infoAboutSelectedTree();
        txFNewFullName.setText(""); txFNewGender.setText("");
        dpNewDateOfBirth.setValue(null); dpNewDateOfDeath.setValue(null);
        txFNewMatherName.setText(""); txFNewFatherName.setText("");
        txFNewSpouse.setText(""); txFNewChildren.setText("");
    }

    // #Конец

    // #Методы абстрактного класса Application

    public void start(Stage stage) {
        try {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(
                    MainDesktop.class.getResource("familyTreeView.fxml")));
            stage.setTitle("Семейное древо");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void appStart(){
        Application.launch();
    }

    // #Конец
}
