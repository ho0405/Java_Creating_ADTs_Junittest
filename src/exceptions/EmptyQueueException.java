package exceptions;

/**
 * Exception to indicate that an operation on a queue cannot be performed
 * because the queue is empty.
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {

    /**
     * Constructs an EmptyQueueException with no detail message.
     */
    public EmptyQueueException() {
        super();
    }

    /**
     * Constructs an EmptyQueueException with the specified detail message.
     *
     * @param message the detail message.
     */
    public EmptyQueueException(String message) {
        super(message);
    }

    
}
