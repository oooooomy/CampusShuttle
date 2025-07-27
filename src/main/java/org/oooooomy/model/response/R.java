package org.oooooomy.model.response;

public record R<T>(boolean success, T data, String msg) {

    public static final String SUCCESS_MSG = "success";

    public static <T> R<T> successful(T data) {
        return new R<>(true, data, SUCCESS_MSG);
    }

    public static R<Void> successful() {
        return new R<>(true, null, SUCCESS_MSG);
    }

    public static R<Void> failed(String msg) {
        return new R<>(false, null, msg);
    }

}
