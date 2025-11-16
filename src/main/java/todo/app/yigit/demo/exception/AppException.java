package todo.app.yigit.demo.exception;

public abstract class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}
