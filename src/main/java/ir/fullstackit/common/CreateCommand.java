package ir.fullstackit.common;

import org.joda.time.DateTime;

/**
 * @author Mehdi Chitforoosh
 */
public interface CreateCommand {

    String getCreatorId();

    DateTime getCreationDate();

}
