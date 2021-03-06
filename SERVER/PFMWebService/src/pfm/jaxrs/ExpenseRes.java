package pfm.jaxrs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import pfm.model.Account;
import pfm.model.Category;
import pfm.model.Currency;
import pfm.model.Expense;

@Path("expense")
@Stateless
public class ExpenseRes {
    @Context
    private UriInfo context;

    @PersistenceContext
    EntityManager em;
    
    public ExpenseRes() {
    }
    
    @POST
	@Consumes("application/json")
	public Response postJson(Expense exp) {
		try {
			Account acc = em.find(Account.class, exp.getAccountId());
			Category cat = em.find(Category.class, exp.getCategoryId());
			Currency cur = em.find(Currency.class, exp.getCurrencyId());
			
			exp.setAccount(acc);
			exp.setCategory(cat);
			exp.setCurrency(cur);
			
			em.persist(exp);
			em.flush();
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
    
    @DELETE
    @Path("/{expenseId}")
    public Response deleteJson(@PathParam("expenseId") int id) {
    	try {
    		Expense exp = em.find(Expense.class, id);
        	em.remove(exp);
        	em.flush();
        	return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
    }
}
