package com.example.dto;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by vsabadosh on 17/11/15.
 */
@XmlRootElement(name = "artist")
public class Artist {
    private String id;
    private String name;

    @XmlElement(nillable = true, name = "_link")
    private Link link;

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setLink(Link link) { this.link = link; }

    public Link getLink() { return link; }
}
