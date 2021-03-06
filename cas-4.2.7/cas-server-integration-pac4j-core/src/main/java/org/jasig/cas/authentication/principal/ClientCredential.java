package org.jasig.cas.authentication.principal;

import org.jasig.cas.authentication.Credential;
import org.pac4j.core.profile.UserProfile;

import java.io.Serializable;

/**
 * This class represents client credentials and (after authentication) a user profile.
 *
 * @author Jerome Leleu
 * @since 3.5.0
 */
public final class ClientCredential implements Credential, Serializable {

    /**
     * The servialVersionUID.
     */
    private static final long serialVersionUID = -7883301304291894763L;

    private boolean typedIdUsed = true;

    /**
     * The user profile after authentication.
     */
    private UserProfile userProfile;

    /**
     * The internal credentials provided by the authentication at the provider.
     */
    private final org.pac4j.core.credentials.Credentials credentials;

    /**
     * Define the credentials.
     *
     * @param theCredentials The authentication credentials
     */
    public ClientCredential(final org.pac4j.core.credentials.Credentials theCredentials) {
        this.credentials = theCredentials;
    }

    /**
     * Return the credentials.
     *
     * @return the credentials
     */
    public org.pac4j.core.credentials.Credentials getCredentials() {
        return credentials;
    }

    /**
     * Return the profile of the authenticated user.
     *
     * @return the profile of the authenticated user
     */
    public UserProfile getUserProfile() {
        return userProfile;
    }

    /**
     * Define the user profile.
     *
     * @param theUserProfile The user profile
     */
    public void setUserProfile(final UserProfile theUserProfile) {
        this.userProfile = theUserProfile;
    }

    @Override
    public String getId() {
        if (this.userProfile != null) {
            if (this.typedIdUsed) {
                return this.userProfile.getTypedId();
            }
            return this.userProfile.getId();
        }
        return null;
    }

    public void setTypedIdUsed(final boolean typedIdUsed) {
        this.typedIdUsed = typedIdUsed;
    }
}
[ZoneTransfer]
ZoneId=3
