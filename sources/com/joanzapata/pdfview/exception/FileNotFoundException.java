package com.joanzapata.pdfview.exception;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String str) {
        super(str);
    }

    public FileNotFoundException(String str, Throwable th) {
        super(str, th);
    }
}
