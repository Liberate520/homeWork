package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import presenter.Presenter;
import ui.Commands.Option;

public class DesktopUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private HashMap<String, String> data;
    private Frame window;

    public DesktopUI() {
        this.scanner = new Scanner(System.in, "CP866");
        this.menu = new Menu(this);
        this.data = new HashMap<String, String>();
        this.window = new JFrame("Семейное древо");
        window.setSize(400, 600);
        window.setLayout(null);
        window.setVisible(true);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        menu();
    }

    @Override
    public void menu() {
    data.put("selector", "");

        for (int i = 0; i < menu.size(); i++) {
            Option cmd = menu.getCommands().get(i);
            JButton button = new JButton(cmd.description());
            button.setBounds(80, 60 * i, 200, 40);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmd.execute();
                    try {
                        presenter.onClick(data);
                        //frame.revalidate();
                    } catch (ClassNotFoundException | IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            window.add(button);
        }       
    }

    @Override
    public void print(String text) {
        System.out.print(text);
        JList<String> b = new JList< >(text.split("\n"));
        window.add(b);
        ((JFrame) window).getContentPane().setVisible(false);
        ((JFrame) window).getContentPane().setVisible(true);
    }

    @Override
    public HashMap<String, String> getData() {
        return data;
    }

    @Override
    public String getName(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public String getSurname(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSurname'");
    }

    @Override
    public void сompleteDatEntry() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'сompleteDatEntry'");
    }
}
