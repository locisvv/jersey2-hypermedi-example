package com.example.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.ws.rs.core.Link;
import java.io.IOException;

/**
 * @author Vasyl Spachynskyi
 * @version $Id:
 * @since 04.12.2015
 */

public class JsonLinkSerializer extends JsonSerializer<Link> {

    @Override
    public void serialize(Link link, JsonGenerator jg, SerializerProvider sp)
            throws IOException, JsonProcessingException {

        jg.writeStartObject();
        jg.writeStringField("href", link.getUri().toString());
        jg.writeEndObject();
    }

}