package nl.teslanet.mule.transport.coap.server.test.properties;


import java.util.LinkedList;

import org.eclipse.californium.core.coap.OptionSet;

import nl.teslanet.mule.transport.coap.commons.options.ETag;
import nl.teslanet.mule.transport.coap.commons.options.InvalidETagException;


public class OptIfMatchListInbound1Test extends AbstractInboundPropertyTestcase
{
    @Override
    protected void addOption( OptionSet options ) throws InvalidETagException
    {
        options.addIfMatch( new ETag( "0011FF").asBytes() );         
    }

    @Override
    protected String getPropertyName()
    {
        return "coap.opt.if_match.list";
    }

    @Override
    protected Object getExpectedPropertyValue() throws InvalidETagException
    {
        LinkedList<ETag> list= new LinkedList<ETag>();
        list.add( new ETag("0011FF") );
        
        return list;
    }
}