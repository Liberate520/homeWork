package model.handlers;

public abstract class Handler {
    private final String filePathOut;
    private final String fileNameOut;

    public Handler() {
        this.filePathOut = "tree\\model\\handlers\\fileLogs\\";
        this.fileNameOut = "input.out";
    }

    public String getFileNameOut() {
        return fileNameOut;
    }

    public String getFilePathOut() {
        return filePathOut;
    }

}
