module oop.familyTree {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens oop.familyTree to javafx.fxml;
    exports oop.familyTree;
    exports oop.familyTree.MVP.view.desktop;
    opens oop.familyTree.MVP.view.desktop to javafx.fxml;
    exports oop.familyTree.MVP.presenter;
    opens oop.familyTree.MVP.presenter to javafx.fxml;
    exports oop.familyTree.human;
    opens oop.familyTree.human to javafx.fxml;
    exports oop.familyTree.tree;
    opens oop.familyTree.tree to javafx.fxml;
}