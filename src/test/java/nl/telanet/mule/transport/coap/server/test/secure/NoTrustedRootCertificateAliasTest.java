package nl.telanet.mule.transport.coap.server.test.secure;


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isA;
import static org.junit.internal.matchers.ThrowableCauseMatcher.hasCause;
import static org.junit.internal.matchers.ThrowableMessageMatcher.hasMessage;

import org.mule.api.ConnectionException;
import org.mule.api.lifecycle.LifecycleException;

import nl.teslanet.mule.transport.coap.server.error.EndpointConstructionException;
import nl.teslanet.mule.transport.coap.server.test.config.AbstractMuleStartTestCase;


public class NoTrustedRootCertificateAliasTest extends AbstractMuleStartTestCase
{
    @Override
    protected void expectException()
    {
        exception.expect( isA( LifecycleException.class ) );
        exception.expect( hasMessage( containsString( "nl.teslanet.mule.transport.coap.server" ) ) );
        exception.expect( hasCause( isA( ConnectionException.class ) ) );
        exception.expect( hasCause( hasMessage( containsString( "CoAP configuration error" ) ) ) );
        exception.expect( hasCause( hasCause( isA( EndpointConstructionException.class ) ) ) );
        exception.expect( hasCause( hasCause( hasMessage( containsString( "cannot load truststore" ) ) ) ) );
        exception.expect( hasCause( hasCause( hasMessage( containsString( "certs/trustStore.jks" ) ) ) ) );
        exception.expect( hasCause( hasCause( hasCause( isA( EndpointConstructionException.class ) ) ) ) );
        exception.expect( hasCause( hasCause( hasCause( hasMessage( containsString( "certificate chain with alias" ) ) ) ) ) );
        exception.expect( hasCause( hasCause( hasCause( hasMessage( containsString( "rootNONEXISTENT" ) ) ) ) ) );
        exception.expect( hasCause( hasCause( hasCause( hasMessage( containsString( "not found in truststore" ) ) ) ) ) );
    }

    @Override
    protected String getConfigResources()
    {
        return "mule-config/secure/testserver7.xml";
    };
}