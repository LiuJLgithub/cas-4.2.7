package org.jasig.cas.web.support;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Default cookie value builder that simply returns the given cookie value
 * and does not perform any additional checks.
 * @author Misagh Moayyed
 * @since 4.1
 */
@Component("noOpCookieValueManager")
public final class NoOpCookieValueManager implements CookieValueManager {

    @Override
    public String buildCookieValue(final String givenCookieValue, final HttpServletRequest request) {
        return givenCookieValue;
    }

    @Override
    public String obtainCookieValue(final Cookie cookie, final HttpServletRequest request) {
        return cookie.getValue();
    }
}
[ZoneTransfer]
ZoneId=3
