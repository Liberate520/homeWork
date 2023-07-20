package GenerationTree.ui.MenuRender;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageData {
    private int pageId;
    private int startLineIndex;
    private int currentLineIndex;
    private Map<String, List<String>> pageData;
    private int linesCount;

    public PageData(int pageId, int startLineIndex, Map<String, List<String>> pageData, int currentLineIndex) {
        setClassData(pageId, startLineIndex, pageData);
        this.currentLineIndex = currentLineIndex;
    }

    public PageData(int pageId, int startLineIndex, Map<String, List<String>> pageData) {
        setClassData(pageId, startLineIndex, pageData);
        this.currentLineIndex = 0;
    }

    public int getPageId() {
        return pageId;
    }

    public int getStartLineIndex() {
        return startLineIndex;
    }

    public int getCurrentLineIndex() {
        return currentLineIndex;
    }

    public int getLinesCount() {
        return linesCount;
    }

    public int getLineCount() {
        int count = 0;
        for (String key : pageData.keySet()) {
            count += pageData.get(key).size();
        }
        return count;
    }

    public Set<String> getDataKeySet() {
        return this.pageData.keySet();
    }

    public List<String> getDataByKey(String key) {
        return new ArrayList<>(pageData.get(key));
    }

    public int dataSize() {
        return this.pageData.size();
    }

    public void setCurrentLineIndex(int index) {
        this.currentLineIndex = index;
    }

    public void changeCurrentLineIndex(int step) {
        this.currentLineIndex += step;
    }

    private void setClassData(int pageId, int startLineIndex, Map<String, List<String>> pageData) {
        this.pageId = pageId;
        this.startLineIndex = startLineIndex;
        this.pageData = new LinkedHashMap<>(pageData);
        this.linesCount = tasksCount();
    }

    private int tasksCount() {
        int count = 0;
        for (String keyWork : pageData.keySet()) {
            count += pageData.get(keyWork).size();
        }
        return count;
    }
}