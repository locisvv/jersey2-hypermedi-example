package com.example.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.ws.rs.core.Link;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * @author Vasyl Spachynskyi
 * @version $Id:
 * @since 04.12.2015
 */
@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public ObjectMapperContextResolver() {
        mapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Link.class, new JsonLinkSerializer());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(simpleModule);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}