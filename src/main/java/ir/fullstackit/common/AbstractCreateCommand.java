package ir.fullstackit.common;

import org.joda.time.DateTime;

/**
 * @author Mehdi Chitforoosh
 */
public abstract class AbstractCreateCommand extends AbstractCommand implements CreateCommand {

    private final String creatorId;
    private final DateTime creationDate;

    public AbstractCreateCommand(String id, String creatorId, DateTime creationDate) {
        super(id);
        this.creatorId = creatorId;
        this.creationDate = creationDate;
    }

    @Override
    public String getCreatorId() {
        return creatorId;
    }

    @Override
    public DateTime getCreationDate() {
        return creationDate;
    }

}
