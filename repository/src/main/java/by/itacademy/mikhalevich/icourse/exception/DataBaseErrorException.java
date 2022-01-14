package by.itacademy.mikhalevich.icourse.exception;

public class DataBaseErrorException extends RuntimeException {

	public DataBaseErrorException(String message) {
		super(message);
	}

	public DataBaseErrorException(Throwable cause) {
		super(cause);
	}

	public DataBaseErrorException(String message, Throwable cause) {
		super(message, cause);
	}

}
