package semanticprocessing;

/**
 * Thrown when a Page is constructed with a URL that points to something other
 * than a Page, such as a JPG image.
 * @author hussamkaka
 */
public class NotAnHtmlUrlException extends Exception {

    /**
     * Creates a new instance of <code>NotAnHtmlUrlException</code>
     * without detail message.
     */
    public NotAnHtmlUrlException() {
    }

    /**
     * Constructs an instance of <code>NotAnHtmlUrlException</code> with
     * the specified detail message.
     * @param msg the detail message.
     */
    public NotAnHtmlUrlException(final String msg) {
        super(msg);
    }
}
