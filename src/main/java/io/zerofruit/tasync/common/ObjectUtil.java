package io.zerofruit.tasync.common;

public class ObjectUtil {
    private ObjectUtil() {}

    public static <T> T checkNotNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }
}
