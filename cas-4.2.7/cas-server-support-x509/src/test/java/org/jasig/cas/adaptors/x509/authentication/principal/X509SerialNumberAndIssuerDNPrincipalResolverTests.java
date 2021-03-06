package org.jasig.cas.adaptors.x509.authentication.principal;

import static org.junit.Assert.*;

import java.security.cert.X509Certificate;

import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.junit.Test;

/**
 * @author Scott Battaglia
 * @author Jan Van der Velpen
 * @since 3.0.0.6
 *
 */
public class X509SerialNumberAndIssuerDNPrincipalResolverTests extends AbstractX509CertificateTests {

    private final X509SerialNumberAndIssuerDNPrincipalResolver
        resolver = new X509SerialNumberAndIssuerDNPrincipalResolver();

    @Test
    public void verifyResolvePrincipalInternal() {
        final X509CertificateCredential c = new X509CertificateCredential(new X509Certificate[] {VALID_CERTIFICATE});
        c.setCertificate(VALID_CERTIFICATE);


        final String value = "SERIALNUMBER="
                + VALID_CERTIFICATE.getSerialNumber().toString()
                + ", " + VALID_CERTIFICATE.getIssuerDN().getName();

        assertEquals(value, this.resolver.resolve(c).getId());
    }

    @Test
    public void verifySupport() {
        final X509CertificateCredential c = new X509CertificateCredential(new X509Certificate[] {VALID_CERTIFICATE});
        assertTrue(this.resolver.supports(c));
    }

    @Test
    public void verifySupportFalse() {
        assertFalse(this.resolver.supports(new UsernamePasswordCredential()));
    }

}
[ZoneTransfer]
ZoneId=3
