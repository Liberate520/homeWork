package model.handlers;

public abstract class Handler {
    private final String filePath;
    private final String fileNameOut;

    public Handler() {
        this.filePath = "tree\\src\\model\\handlers\\fileLogs\\";
        this.fileNameOut = "input.out";
    }

    public String getFileNameOut() {
        return fileNameOut;
    }

    public String getFilePath() {
        return filePath;
    }

}
