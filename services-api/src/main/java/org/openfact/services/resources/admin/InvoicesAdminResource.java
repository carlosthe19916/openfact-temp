package org.openfact.services.resources.admin;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Consumes(MediaType.APPLICATION_JSON)
public interface InvoicesAdminResource {

    /**
     * @param invoiceId
     *            The invoiceId of the invoice
     */
    @Path("{invoiceId}")
    InvoiceAdminResource getInvoiceAdmin(@PathParam("invoiceId") final String invoiceId);

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    List<InvoiceRepresentation> getInvoices(@QueryParam("filterText") String filterText,
            @QueryParam("type") String type, @QueryParam("currencyCode") String currencyCode,
            @QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response createInvoice(@Valid final InvoiceRepresentation rep);

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    SearchResultsRepresentation<InvoiceRepresentation> search(final SearchCriteriaRepresentation criteria);

}
