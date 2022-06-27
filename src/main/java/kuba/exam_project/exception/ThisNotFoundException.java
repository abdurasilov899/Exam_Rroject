package kuba.exam_project.exception;

public class ThisNotFoundException extends RuntimeException{
    public ThisNotFoundException() {
        super();
    }

    public ThisNotFoundException(String message) {
        super(message);
    }
}
