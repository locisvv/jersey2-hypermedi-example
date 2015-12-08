package com.example.jaxrs;

/**
 * Created by vsabadosh on 17/11/15.
 */

import com.example.services.MusicRepositoryService;
import com.example.dto.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vasyl Spachynskyi
 * @version $Id:
 * @since 04.12.2015
 */
@Component
@Path("/albums")
public class AlbumJaxrsService {

    @Autowired
    private MusicRepositoryService musicRepositoryService = new MusicRepositoryService();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "application/hal+json", "application/hal+xml"})
    public Response getAllAlbums(@DefaultValue("false") @QueryParam("embedded") boolean embedded) {
        Collection<Album> albums = musicRepositoryService.getAllAlbums();
        List<HalResource<Album>> resources = new ArrayList<>();
        for (Album album : albums) {
            resources.add(getAlbumResource(album, embedded));
        }
        return Response.ok(resources).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "application/hal+json", "application/hal+xml"})
    public Response getAlbum(@PathParam("id") String id, @DefaultValue("false") @QueryParam("embedded") boolean embedded) {
        Album album = musicRepositoryService.getAlbum(id);
        return Response.ok(getAlbumResource(album, embedded)).build();
    }

    private HalResource<Album> getAlbumResource(Album album, boolean embedded) {
        HalResource<Album> resource = new HalResource<>();
        resource.setEntity(album);
        if (embedded) {
            resource.putEmbedded("artist", musicRepositoryService.getArtist(album.getArtistId()));
        }
        return resource;
    }

}
