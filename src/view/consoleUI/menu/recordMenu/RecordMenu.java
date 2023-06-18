package view.consoleUI.menu.recordMenu;

import model.members.Member;
import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.mainMenu.commands.ReturnBack;
import view.consoleUI.menu.recordMenu.commands.GetChildren;
import view.consoleUI.menu.recordMenu.commands.GetParents;

import java.util.Arrays;

public class RecordMenu extends Menu {
    Member member;

    public RecordMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new GetChildren(consoleUI),
                new GetParents(consoleUI),
                new ReturnBack(consoleUI)));
        member = null;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
