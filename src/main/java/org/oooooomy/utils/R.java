package org.oooooomy.utils;

public record R<T>(boolean success, String msg, T data) {

    public static <T> R<T> ok() {
        return new R<>(true, null, null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(true, null, data);
    }

    public static <T> R<T> failed(String msg) {
        return new R<>(false, msg, null);
    }

}
