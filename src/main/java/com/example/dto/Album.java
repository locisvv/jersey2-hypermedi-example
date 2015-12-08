package com.example.dto;

import com.example.configuration.JsonLinkListSerializer;
import com.example.jaxrs.AlbumJaxrsService;
import com.example.jaxrs.ArtistJaxrsService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by vsabadosh on 17/11/15.
 */
public class Album {

    @InjectLinks({
            @InjectLink(
                    resource = ArtistJaxrsService.class,
                    style = InjectLink.Style.ABSOLUTE,
                    method = "get",
                    bindings = {
                            @Binding(name = "id", value = "${instance.artistId.id}")
                    },
                    rel = "artistId"
            ),
            @InjectLink(
                    resource = AlbumJaxrsService.class,
                    style = InjectLink.Style.ABSOLUTE,
                    method = "get",
                    bindings = {
                            @Binding(name = "id", value = "${instance.id}")
                    },
                    rel = "self"
            )})
    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @JsonProperty("_links")
    @JsonSerialize(using = JsonLinkListSerializer.class)
    private List<Link> links;

    private String id;
    private String title;
    private String artistId;
    private int stockLevel;

    public Album() {
    }

    public Album(String id, String title, String artistId, int stockLevel) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.stockLevel = stockLevel;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistId() {
        return artistId;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Album copyAlbum() {
        return new Album(id, title, artistId, stockLevel);
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}