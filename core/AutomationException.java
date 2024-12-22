package core;

public class AutomationException extends Exception {
    public AutomationException(String message) {
        super(message);
    }

    public AutomationException(String message, Object... strings) {
        super(String.format(message, strings));
    }

    public AutomationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public AutomationException(String message, Throwable throwable, Object... strings) {
        super(String.format(message, strings), throwable);
    }

    public AutomationException(Throwable throwable) {
        super(throwable);
    }
}
