package redis.clients.collections;

public class IrregularKeyValue extends RuntimeException {

	private static final long serialVersionUID = 6161854579438859925L;

	IrregularKeyValue(String message) {
		super(message);
	}
}