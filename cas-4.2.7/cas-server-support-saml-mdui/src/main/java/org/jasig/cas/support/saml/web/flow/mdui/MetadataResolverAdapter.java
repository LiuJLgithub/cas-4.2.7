package org.jasig.cas.support.saml.web.flow.mdui;

import org.opensaml.saml.saml2.metadata.EntityDescriptor;

/**
 * {@link MetadataResolverAdapter} is a facade on top of the existing
 * metadata resolution machinery that defines how metadata may be resolved.
 *
 * @author Misagh Moayyed
 * @since 4.1.0
 */
public interface MetadataResolverAdapter {
    /**
     * Gets entity descriptor for entity id.
     *
     * @param entityId the entity id
     * @return the entity descriptor for entity id
     */
    EntityDescriptor getEntityDescriptorForEntityId(String entityId);
}
[ZoneTransfer]
ZoneId=3
