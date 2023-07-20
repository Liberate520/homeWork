package GenerationTree.View.MenuRender;

import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;

public class MenuRender {

    private final int HEADER_LINE_COUNT = 2;
    private final int LINE_MAX_CHARACTER_COUNT = 190;

    public String headerText;
    public String footerText;

    private Map<String, List<String>> menuData;
    private int consoleLines;
    private int largestLine;
    private int helpTextLines = 0;
    private boolean isEscActive;
    private boolean showHelpControl;
    private String prefix;
    private String prefixMark;
    private ConsoleManager cm = new ConsoleManager();
    private Set<PageData> pagesMap;

    public MenuRender(Map<String, List<String>> menuData, int consoleLines,
            boolean isEscActive, boolean showHelpControl, String headerText, String footerText, String prefix,
            String prefixMark) {
        this.headerText = headerText == null ? "" : headerText;
        this.footerText = footerText == null ? "" : footerText;

        this.menuData = menuData;
        this.consoleLines = consoleLines;
        this.isEscActive = isEscActive;
        this.showHelpControl = showHelpControl;
        this.prefix = prefix == null || prefix.isEmpty() ? "> " : prefix;
        this.prefixMark = prefixMark == null ? "" : prefixMark;
        this.largestLine = getLargestLineLength();
        this.pagesMap = splitDataToPages(this.menuData, this.consoleLines, HEADER_LINE_COUNT);
    }

    public int startRenderMenu(int index) {
        int largestKey = getLargestKeyTasks();
        this.consoleLines = largestKey > this.consoleLines ? largestKey + 1 : this.consoleLines;
        PageData page = null;
        try {
            page = getCheckCoordinates(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageCount = this.pagesMap.size();

        ConsoleManager.hideCursor(true);
        drawMenu(page);
        while (true) {
            int key = this.cm.getKeyEvent();
            switch (key) {
                case KeyEvent.VK_ENTER:
                    ConsoleManager.hideCursor(false);
                    clearConsoleText();
                    return page.getCurrentLineIndex() + page.getStartLineIndex() + 1;
                case KeyEvent.VK_UP:
                    if (page.getCurrentLineIndex() > 0) {
                        page.changeCurrentLineIndex(-1);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (page.getCurrentLineIndex() < page.getLineCount() - 1) {
                        page.changeCurrentLineIndex(1);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (page.getPageId() > 1) {
                        page = getNexPage(page, this.pagesMap, -1, this.prefix.length());
                        clearConsoleText();
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (page.getPageId() < pageCount) {
                        page = getNexPage(page, this.pagesMap, 1, this.prefix.length());
                        clearConsoleText();
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    if (this.isEscActive) {
                        ConsoleManager.hideCursor(false);
                        clearConsoleText();
                        return 0;
                    }
                    break;
            }
            setCursorStartPossition();
            drawMenu(page);
        }
    }

    private int getLargestKeyTasks() {
        int largestKeyTasks = 0;
        for (String key : this.menuData.keySet()) {
            int lengthKeyTasks = this.menuData.get(key).size();
            largestKeyTasks = lengthKeyTasks > largestKeyTasks ? lengthKeyTasks : largestKeyTasks;
        }
        return largestKeyTasks + HEADER_LINE_COUNT + 1;
    }

    private PageData getCheckCoordinates(int index) throws Exception {
        for (PageData page : this.pagesMap) {
            if (index >= page.getStartLineIndex() && index < page.getStartLineIndex() + page.getLinesCount()) {
                page.setCurrentLineIndex(index - page.getStartLineIndex());
                return page;
            }
        }
        throw new Exception("Page not found!");
    }

    private void drawMenu(PageData page) {
        int blockIdCount = 0;
        this.cm.PrintText(this.headerText);
        for (String key : page.getDataKeySet()) {
            if (blockIdCount > 0) {
                this.cm.printText();
            }
            this.cm.PrintText(key);
            List<String> pageData = page.getDataByKey(key);
            for (int i = 0; i < pageData.size(); i++) {
                clearLine();
                boolean isSelected = i + blockIdCount == page.getCurrentLineIndex();
                String prToConsole;
                String lineText = pageData.get(i).replace("\n", " ");
                if (this.prefixMark.equals("")) {
                    prToConsole = isSelected ? this.prefix : " ".repeat(this.prefix.length());
                    prToConsole += lineText;
                } else {
                    prToConsole = isSelected ? lineText.replace(this.prefixMark, this.prefix)
                            : lineText.replace(this.prefixMark, " ".repeat(this.prefixMark.length()));
                }
                if (prToConsole.length() > LINE_MAX_CHARACTER_COUNT) {
                    prToConsole = prToConsole.substring(0, LINE_MAX_CHARACTER_COUNT - 3) + "...";
                }
                this.cm.PrintText(prToConsole);
            }
            blockIdCount += pageData.size();
        }
        if (this.showHelpControl) {
            drawHelpText(page);
        }
        if (!footerText.isEmpty()) {
            this.cm.PrintText(this.footerText);
        }
    }

    private void drawHelpText(PageData page) {
        int pagesCount = this.pagesMap.size();

        String strPageNumbers = "";
        if (pagesCount > 1) {
            strPageNumbers = "-".repeat(pagesCount);
            String strPageId = String.valueOf(page.getPageId());
            for (int i = 0; i < strPageId.length(); i++) {
                strPageNumbers = strPageNumbers.substring(0, page.getPageId() - 1 + i) + strPageId.charAt(i)
                        + strPageNumbers.substring(page.getPageId() + i);
            }
        }
        String indent = " ".repeat(50);
        if (pagesCount > 2) {
            if (page.getPageId() > 1) {
                strPageNumbers = "< " + strPageNumbers;
            } else {
                strPageNumbers = "  " + strPageNumbers;
            }
            if (page.getPageId() < pagesCount) {
                strPageNumbers += " >";
            } else {
                strPageNumbers += "  ";
            }
        }
        String pagesSwitchInfo = pagesCount > 1 ? "Стрелки право/лево - переключать страницы. " : "";
        String helpInfo = "Стрелки вверх/вниз - перемещаться между строками. " + pagesSwitchInfo
                + "Enter - выбрать задачу. Для выхода нажмите Esc.";
        this.largestLine = helpInfo.length() > this.largestLine ? helpInfo.length() : this.largestLine;
        String pagesInfo = indent + strPageNumbers + "\n" + "=".repeat(this.largestLine);

        String padding = "\n"
                .repeat(this.consoleLines - page.getLinesCount() - page.dataSize() * HEADER_LINE_COUNT);
        padding += pagesInfo + "\n" + helpInfo;

        this.cm.printText(padding, "\n\n");
        this.helpTextLines = 6;
    }

    private int getLargestLineLength() {
        int largestLineLength = 0;
        for (String key : this.menuData.keySet()) {
            if (largestLineLength < key.length()) {
                largestLineLength = key.length();
            }
            List<String> value = this.menuData.get(key);
            if (value.size() == 0) {
                continue;
            }
            int maxLength = Collections.max(value, Comparator.comparing(String::length)).length();
            if (largestLineLength < maxLength) {
                largestLineLength = maxLength;
            }
        }

        int prLength = this.prefix.length();
        int prMarkLength = this.prefixMark.length();
        largestLineLength += (prLength > prMarkLength ? prLength : prMarkLength);
        return largestLineLength > LINE_MAX_CHARACTER_COUNT ? LINE_MAX_CHARACTER_COUNT
                : largestLineLength;
    }

    private static Set<PageData> splitDataToPages(Map<String, List<String>> menuData, int linesPage,
            int headerLineCount) {
        int pageLineCount = 0;
        int pageFirstIndex = 0;
        int pageId = 1;
        Map<String, List<String>> pageData = new LinkedHashMap<String, List<String>>();
        Set<PageData> pagesMap = new HashSet<>();
        int i = 0;
        for (String key : menuData.keySet()) {
            int countLinesKeyTasks = menuData.get(key).size();
            if (countLinesKeyTasks + headerLineCount + pageLineCount >= linesPage) {
                PageData page = new PageData(pageId, pageFirstIndex, pageData);
                pagesMap.add(page);
                pageLineCount = 0;
                pageId += 1;
                pageFirstIndex += page.getLinesCount();
                pageData.clear();
            }
            pageLineCount += countLinesKeyTasks + headerLineCount;
            pageData.put(key, menuData.get(key));
            if (i == menuData.keySet().size() - 1) {
                pagesMap.add(new PageData(pageId, pageFirstIndex, pageData));
            }
            i++;
        }
        return pagesMap;
    }

    private static PageData getNexPage(PageData page, Set<PageData> pagesMap,
            int step,
            int prefixLength) {
        int currentIndex = page.getCurrentLineIndex();
        final int pageId = page.getPageId();
        page = pagesMap.stream().filter(p -> p.getPageId() == pageId + step).findFirst().get();
        page.setCurrentLineIndex(currentIndex < page.getLinesCount() ? currentIndex : page.getLinesCount() - 1);
        return page;
    }

    private void clearConsoleText() {
        goToStartPossition(this::clearLine);
    }

    private void setCursorStartPossition() {
        goToStartPossition(null);
    }

    private void goToStartPossition(Runnable methodForLines) {
        int backCount = this.consoleLines - 1;
        for (int i = 1; i < backCount + this.helpTextLines; i++) {
            if (methodForLines != null) {
                methodForLines.run();
            }
            this.cm.printText("\033[F", "");
        }
    }

    private void clearLine() {
        this.cm.printText(" ".repeat(this.largestLine), "");
        this.cm.printText("\b".repeat(this.largestLine), "");
    }
}