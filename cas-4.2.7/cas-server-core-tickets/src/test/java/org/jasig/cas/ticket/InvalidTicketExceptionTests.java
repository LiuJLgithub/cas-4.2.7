package org.jasig.cas.ticket;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Misagh Moayyed
 * @since 3.0.0
 */
public class InvalidTicketExceptionTests {

    @Test
    public void verifyCodeNoThrowable() {
        final AbstractTicketException t = new InvalidTicketException("InvalidTicketId");
        assertEquals("INVALID_TICKET", t.getCode());
    }
}
[ZoneTransfer]
ZoneId=3
