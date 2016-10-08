package com.palm.lingcai.util.upload;

/**
 * Created by nzhmac on 16/9/29.
 */
public class FileResult {
    private String fileName;
    private String filePath;
    private String fileSize;

    public FileResult() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
