package org.jasig.cas.support.events;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * Base Spring {@code ApplicationEvent} representing a abstract single sign on action executed within running CAS server.
 * This event encapsulates {@link org.jasig.cas.authentication.Authentication} that is associated with an SSO action
 * executed in a CAS server and an SSO session
 * token in the form of ticket granting ticket id.
 * More concrete events are expected to subclass this abstract type.
 *
 * @author Dmitriy Kopylenko
 * @since 4.2
 */
public abstract class AbstractCasEvent extends ApplicationEvent implements Serializable {

    private static final long serialVersionUID = 8059647975948452375L;

    /**
     * Instantiates a new Abstract cas sso event.
     *
     * @param source                 the source
     */
    public AbstractCasEvent(final Object source) {
        super(source);
    }

}
[ZoneTransfer]
ZoneId=3
