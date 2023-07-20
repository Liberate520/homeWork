package GenerationTree.ui.MenuRender;

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

    private Map<String, List<String>> _menuData;
    private int _consoleLines;
    private int _largestLine;
    private int _helpTextLines = 0;
    private boolean _isEscActive;
    private boolean _showHelpControl;
    private String _prefix;
    private String _prefixMark;
    private ConsoleManager _cm = new ConsoleManager();
    private Set<PageData> _pagesMap;

    public MenuRender(Map<String, List<String>> menuData, int consoleLines,
            boolean isEscActive, boolean showHelpControl, String headerText, String footerText, String prefix,
            String prefixMark) {
        this.headerText = headerText == null ? "" : headerText;
        this.footerText = footerText == null ? "" : footerText;

        this._menuData = menuData;
        this._consoleLines = consoleLines;
        this._isEscActive = isEscActive;
        this._showHelpControl = showHelpControl;
        this._prefix = prefix == null || prefix.isEmpty() ? "> " : prefix;
        this._prefixMark = prefixMark == null ? "" : prefixMark;
        this._largestLine = GetLargestLineLength();
        this._pagesMap = SplitDataToPages(_menuData, _consoleLines, HEADER_LINE_COUNT);
    }

    public int StartRenderMenu(int index) {
        int largestKey = GetLargestKeyTasks();
        _consoleLines = largestKey > _consoleLines ? largestKey + 1 : _consoleLines;
        PageData page = null;
        try {
            page = GetCheckCoordinates(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageCount = _pagesMap.size();

        ConsoleManager.hideCursor(true);
        DrawMenu(page);
        while (true) {
            int key = _cm.getKeyEvent();
            switch (key) {
                case KeyEvent.VK_ENTER:
                    ConsoleManager.hideCursor(false);
                    ClearConsoleText();
                    return page.currentLineIndex + page.startLineIndex + 1;
                case KeyEvent.VK_UP:
                    if (page.currentLineIndex > 0) {
                        page.currentLineIndex -= 1;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (page.currentLineIndex < LineCount(page.pageData) - 1) {
                        page.currentLineIndex += 1;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (page.pageId > 1) {
                        page = GetNexPage(page, _pagesMap, -1, _prefix.length());
                        ClearConsoleText();
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (page.pageId < pageCount) {
                        page = GetNexPage(page, _pagesMap, 1, _prefix.length());
                        ClearConsoleText();
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    if (_isEscActive) {
                        ConsoleManager.hideCursor(false);
                        ClearConsoleText();
                        return 0;
                    }
                    break;
            }
            SetCursorStartPossition();
            DrawMenu(page);
        }
    }

    private int GetLargestKeyTasks() {
        int largestKeyTasks = 0;
        for (String key : _menuData.keySet()) {
            int lengthKeyTasks = _menuData.get(key).size();
            largestKeyTasks = lengthKeyTasks > largestKeyTasks ? lengthKeyTasks : largestKeyTasks;
        }
        return largestKeyTasks + HEADER_LINE_COUNT + 1;
    }

    private PageData GetCheckCoordinates(int index) throws Exception {
        for (PageData page : _pagesMap) {
            if (index >= page.startLineIndex && index < page.startLineIndex + page.linesCount) {
                page.currentLineIndex = index - page.startLineIndex;
                return page;
            }
        }
        throw new Exception("Page not found!");
    }

    private void DrawMenu(PageData page) {
        int blockIdCount = 0;
        _cm.PrintText(this.headerText);
        for (String key : page.pageData.keySet()) {
            if (blockIdCount > 0) {
                _cm.printText();
            }
            _cm.PrintText(key);
            List<String> pageData = page.pageData.get(key);
            for (int i = 0; i < pageData.size(); i++) {
                ClearLine();
                boolean isSelected = i + blockIdCount == page.currentLineIndex;
                String prToConsole;
                String lineText = pageData.get(i).replace("\n", " ");
                if (_prefixMark.equals("")) {
                    prToConsole = isSelected ? _prefix : " ".repeat(_prefix.length());
                    prToConsole += lineText;
                } else {
                    prToConsole = isSelected ? lineText.replace(_prefixMark, _prefix)
                            : lineText.replace(_prefixMark, " ".repeat(_prefixMark.length()));
                }
                if (prToConsole.length() > LINE_MAX_CHARACTER_COUNT) {
                    prToConsole = prToConsole.substring(0, LINE_MAX_CHARACTER_COUNT - 3) + "...";
                }
                _cm.PrintText(prToConsole);
            }
            blockIdCount += pageData.size();
        }
        if (_showHelpControl) {
            DrawHelpText(page);
        }
        if (!footerText.isEmpty()) {
            _cm.PrintText(this.footerText);
        }
    }

    private void DrawHelpText(PageData page) {
        int pagesCount = _pagesMap.size();

        String strPageNumbers = "";
        if (pagesCount > 1) {
            strPageNumbers = "-".repeat(pagesCount);
            String strPageId = String.valueOf(page.pageId);
            for (int i = 0; i < strPageId.length(); i++) {
                strPageNumbers = strPageNumbers.substring(0, page.pageId - 1 + i) + strPageId.charAt(i)
                        + strPageNumbers.substring(page.pageId + i);
            }
        }
        String indent = " ".repeat(50);
        if (pagesCount > 2) {
            if (page.pageId > 1) {
                strPageNumbers = "< " + strPageNumbers;
            } else {
                strPageNumbers = "  " + strPageNumbers;
            }
            if (page.pageId < pagesCount) {
                strPageNumbers += " >";
            } else {
                strPageNumbers += "  ";
            }
        }
        String pagesSwitchInfo = pagesCount > 1 ? "Стрелки право/лево - переключать страницы. " : "";
        String helpInfo = "Стрелки вверх/вниз - перемещаться между строками. " + pagesSwitchInfo
                + "Enter - выбрать задачу. Для выхода нажмите Esc.";
        _largestLine = helpInfo.length() > _largestLine ? helpInfo.length() : _largestLine;
        String pagesInfo = indent + strPageNumbers + "\n" + "=".repeat(_largestLine);

        String padding = "\n".repeat(_consoleLines - page.linesCount - page.pageData.size() * HEADER_LINE_COUNT);
        padding += pagesInfo + "\n" + helpInfo;

        _cm.printText(padding, "\n\n");
        _helpTextLines = 6;
    }

    private int GetLargestLineLength() {
        int largestLineLength = 0;
        for (String key : _menuData.keySet()) {
            if (largestLineLength < key.length()) {
                largestLineLength = key.length();
            }
            List<String> value = _menuData.get(key);
            if (value.size() == 0) {
                continue;
            }
            int maxLength = Collections.max(value, Comparator.comparing(String::length)).length();
            if (largestLineLength < maxLength) {
                largestLineLength = maxLength;
            }
        }

        int prLength = _prefix.length();
        int prMarkLength = _prefixMark.length();
        largestLineLength += (prLength > prMarkLength ? prLength : prMarkLength);
        return largestLineLength > LINE_MAX_CHARACTER_COUNT ? LINE_MAX_CHARACTER_COUNT : largestLineLength;
    }

    private static int LineCount(Map<String, List<String>> menuData) {
        int count = 0;
        for (String key : menuData.keySet()) {
            count += menuData.get(key).size();
        }
        return count;
    }

    private static Set<PageData> SplitDataToPages(Map<String, List<String>> menuData, int linesPage,
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
                pageFirstIndex += page.linesCount;
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

    private static PageData GetNexPage(PageData page, Set<PageData> pagesMap,
            int step,
            int prefixLength) {
        int currentIndex = page.currentLineIndex;
        final int pageId = page.pageId;
        page = pagesMap.stream().filter(p -> p.pageId == pageId + step).findFirst().get();
        page.currentLineIndex = currentIndex < page.linesCount ? currentIndex : page.linesCount - 1;
        return page;
    }

    private void ClearConsoleText() {
        GoToStartPossition(this::ClearLine);
    }

    private void SetCursorStartPossition() {
        GoToStartPossition(null);
    }

    private void GoToStartPossition(Runnable methodForLines) {
        int backCount = _consoleLines - 1;
        for (int i = 1; i < backCount + _helpTextLines; i++) {
            if (methodForLines != null) {
                methodForLines.run();
            }
            _cm.printText("\033[F", "");
        }
    }

    private void ClearLine() {
        _cm.printText(" ".repeat(_largestLine), "");
        _cm.printText("\b".repeat(_largestLine), "");
    }
}