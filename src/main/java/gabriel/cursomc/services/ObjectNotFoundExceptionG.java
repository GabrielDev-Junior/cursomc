package gabriel.cursomc.services;

public class ObjectNotFoundExceptionG extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExceptionG(String msg) {
		super(msg);
	}
	public ObjectNotFoundExceptionG(String msg, Throwable cause) {
		super(msg,cause);
	}
}
