// package ui;

// import java.io.IOException;

// import javax.swing.*;
// import java.awt.event.*;

// import presenter.Presenter;
// import ui.interfaces.View;

// public class Desktop extends JFrame implements View {

//     private JLabel lTree;
//     private JTextArea answer;
//     private JTextField familytree;
//     private JButton findInfo;
//     private Presenter presenter;

//     @Override
//     public void setPresenter(Presenter presenter) {
//         this.presenter = presenter;
//     }

//     @Override
//     public void start() throws IOException, ClassNotFoundException {
//         setSize(800, 800);
//         setLocationRelativeTo(null);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         lTree = new JLabel("Древо ");
//         answer = new JTextArea();
//         findInfo = new JButton("Показать семейное древо ");
//         familytree = new JTextField();
//         setLayout(null);
//         add(lTree);
//         add(familytree);
//         add(findInfo);
//         add(answer);
//         lTree.setBounds(20, 40, 50, 25);
//         familytree.setBounds(70, 45, 290, 20);
//         findInfo.setBounds(95, 80, 200, 50);
//         answer.setBounds(20, 140, 340, 160);

//         setVisible(true);

//     }

//     @Override
//     public void print(String text) {
//         answer.setText(text);
//     }
    
// }


// В работе!!!