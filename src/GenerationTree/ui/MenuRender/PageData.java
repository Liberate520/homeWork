package GenerationTree.ui.MenuRender;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PageData {
    public int pageId;
    public int startLineIndex;
    public int currentLineIndex;
    public Map<String, List<String>> pageData;
    public int linesCount;

    public PageData(int pageId, int startLineIndex, Map<String, List<String>> pageData, int currentLineIndex) {
        SetClassData(pageId, startLineIndex, pageData);
        this.currentLineIndex = currentLineIndex;
    }

    public PageData(int pageId, int startLineIndex, Map<String, List<String>> pageData) {
        SetClassData(pageId, startLineIndex, pageData);
        this.currentLineIndex = 0;
    }

    private void SetClassData(int pageId, int startLineIndex, Map<String, List<String>> pageData) {
        this.pageId = pageId;
        this.startLineIndex = startLineIndex;
        this.pageData = new LinkedHashMap<>(pageData);
        this.linesCount = TasksCount();
    }

    private int TasksCount() {
        int count = 0;
        for (String keyWork : pageData.keySet()) {
            count += pageData.get(keyWork).size();
        }
        return count;
    }
}