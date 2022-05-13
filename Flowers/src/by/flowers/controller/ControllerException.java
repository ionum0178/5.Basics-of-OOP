package by.flowers.controller;

public class ControllerException extends Exception{
    
    private static final long serialVersionUID = 1L;
    public ControllerException() {
	super();
    }
    public ControllerException(Exception e) {
	super(e);
    }
    public ControllerException(String message) {
	super(message);
    }
    public ControllerException(String message, Exception e) {
	super(message, e);
    }
}
