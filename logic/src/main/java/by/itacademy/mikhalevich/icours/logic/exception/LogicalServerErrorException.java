package by.itacademy.mikhalevich.icours.logic.exception;

public class LogicalServerErrorException extends RuntimeException {

	public LogicalServerErrorException(String message) {
		super(message);
	}

	public LogicalServerErrorException(Throwable cause) {
		super(cause);
	}

	public LogicalServerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

}
