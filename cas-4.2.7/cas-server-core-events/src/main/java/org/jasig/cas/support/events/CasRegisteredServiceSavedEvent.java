package org.jasig.cas.support.events;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jasig.cas.services.RegisteredService;

/**
 * This is {@link CasRegisteredServiceSavedEvent} that is signaled
 * when a registered service is saved into the CAS registry.
 *
 * @author Misagh Moayyed
 * @since 4.2.0
 */
public class CasRegisteredServiceSavedEvent extends AbstractCasEvent {

    private static final long serialVersionUID = 291168299766263298L;
    private final RegisteredService registeredService;

    /**
     * Instantiates a new cas sso event.
     *
     * @param source            the source
     * @param registeredService the registered service
     */
    public CasRegisteredServiceSavedEvent(final Object source, final RegisteredService registeredService) {
        super(source);
        this.registeredService = registeredService;
    }

    public RegisteredService getRegisteredService() {
        return registeredService;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("registeredService", registeredService)
                .toString();
    }
}
[ZoneTransfer]
ZoneId=3
