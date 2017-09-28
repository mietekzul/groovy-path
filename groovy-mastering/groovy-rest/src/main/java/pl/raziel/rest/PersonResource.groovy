package pl.raziel.rest

import javax.ws.rs.*
import javax.ws.rs.core.*

@Path("/people")
class PersonResource {
    @Context
    private UriInfo uriInfo

    PersonDAO dao = JdbcPersonDAO.instance

    @GET
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response findAll() {
        def people = dao.findAll();
        Response.ok(people).link(uriInfo.requestUri, 'self').build()
    }

    @GET
    @Path("lastname/{like}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    List<Person> findByName(@PathParam("like") String like) {
        dao.findByLastName(like)
    }

    @GET
    @Path("{id}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response findById(@PathParam("id") long id) {
        Person p = dao.findById(id)
        getLinks(id).each { link ->
            p."${link.rel}" = link   // structural links
        }
        Response.ok(p)
                .links(getLinks(id))     // transitional links
                .build()
    }

    private Link[] getLinks(long id) {
        long minId = dao.minId
        long maxId = dao.maxId
        UriBuilder builder = UriBuilder.fromUri(uriInfo.requestUri)
        Link self = Link.fromUri(builder.build()).rel('self').build()
        String uri = builder.build().toString() - "/$id"
        switch (id) {
            case minId:
                Link next = Link.fromUri("${uri}/${id + 1}").rel('next').build()
                return [self, next]
                break
            case maxId:
                Link prev = Link.fromUri("${uri}/${id - 1}").rel('prev').build()
                return [prev, self]
                break
            default:
                Link next = Link.fromUri("${uri}/${id + 1}").rel('next').build()
                Link prev = Link.fromUri("${uri}/${id - 1}").rel('prev').build()
                return [prev, self, next]
        }
    }

    @POST
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response create(Person person) {
        dao.create(person)
        UriBuilder builder = UriBuilder.fromUri(uriInfo.requestUri).path("{id}")
        Response.created(builder.build(person.id))
                .entity(person)
                .build()
    }

    @PUT
    @Path("{id}")
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Person update(Person person) {
        dao.update(person)
        person;
    }

    @DELETE
    @Path("{id}")
    Response remove(@PathParam("id") long id) {
        dao.delete(id)
        Response.noContent().build()
    }
}
