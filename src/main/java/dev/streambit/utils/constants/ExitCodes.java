package dev.streambit.utils.constants;

public class ExitCodes {

    public static final int SUCCESS = 0;
    public static final int ERROR = 1;
    public static final int INVALID_INPUT = 2;

    public static final String errorMsg(final int exitCode) {
        return String.format("Exited with status code %s", exitCode);
    }
}
