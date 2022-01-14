package by.itacademy.mikhalevich.icourse.exception;

public class ControllerErrorException extends RuntimeException {

	public ControllerErrorException(String message) {
		super(message);
	}

	public ControllerErrorException(Throwable cause) {
		super(cause);
	}

	public ControllerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

}
