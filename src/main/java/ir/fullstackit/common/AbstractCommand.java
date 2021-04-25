package ir.fullstackit.common;

/**
 * @author Mehdi Chitforoosh
 */
public class AbstractCommand {

    private final String id;

    public AbstractCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
