package org.jasig.cas.services;

import java.io.Serializable;
import java.security.PublicKey;

/**
 * Represents a public key for a CAS registered service.
 * @author Misagh Moayyed
 * @since 4.1
 */
public interface RegisteredServicePublicKey extends Serializable {

    /**
     * Gets location to the public key file.
     *
     * @return the location
     */
    String getLocation();

    /**
     * Gets algorithm for the public key.
     *
     * @return the algorithm
     */
    String getAlgorithm();

    /**
     * Create instance.
     *
     * @return the public key
     * @throws Exception the exception thrown if the public key cannot be created
     */
    PublicKey createInstance() throws Exception;
}
[ZoneTransfer]
ZoneId=3
