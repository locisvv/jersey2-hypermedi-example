package com.example.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.ws.rs.core.Link;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vasyl Spachynskyi
 * @version $Id:
 * @since 04.12.2015
 */
public class JsonLinkListSerializer extends JsonSerializer<List<Link>> {

    @Override
    public void serialize(List<Link> list, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        Map<String, Link> linkMap = new HashMap<>(list.size());
        for (Link l : list) {
            linkMap.put(l.getRel(), l);
        }

        TypeFactory typeFactory = provider.getConfig().getTypeFactory();
        JavaType keyType = typeFactory.uncheckedSimpleType(String.class);
        JavaType valueType = typeFactory.constructType(Link.class);
        JavaType mapType = typeFactory.constructMapType(HashMap.class, keyType, valueType);

        MapSerializer serializer = MapSerializer.construct(new String[]{}, mapType, true, null,
                provider.findKeySerializer(keyType, null), provider.findValueSerializer(valueType, null), null);

        serializer.serialize(linkMap, jgen, provider);
    }
}
