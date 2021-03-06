package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentSnapshotModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceTaxTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.InvoiceTaxTotalEntity;

/**
 * @author carlosthe19916@sistcoop.com
 */

public class InvoiceTaxTotalAdapter implements InvoiceTaxTotalModel, JpaModel<InvoiceTaxTotalEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceTaxTotalAdapter.class);

    protected InvoiceModel invoice;
    protected InvoiceTaxTotalEntity taxTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceTaxTotalAdapter(OpenfactSession session, InvoiceModel invoice, EntityManager em,
            InvoiceTaxTotalEntity taxTotal) {
        this.session = session;
        this.em = em;
        this.invoice = invoice;
        this.taxTotal = taxTotal;
    }

    @Override
    public InvoiceTaxTotalEntity getEntity() {
        return taxTotal;
    }

    @Override
    public String getId() {
        return taxTotal.getId();
    }

    @Override
    public DocumentSnapshotModel getDocument() {
        return new DocumentSnapshotAdapter(session, em, taxTotal.getDocument());
    }

    @Override
    public BigDecimal getAmount() {
        return taxTotal.getAmount();
    }

    @Override
    public void setAmount(BigDecimal amount) {
        taxTotal.setAmount(amount);
    }

    @Override
    public BigDecimal getValue() {
        return taxTotal.getValue();
    }

    @Override
    public void setValue(BigDecimal value) {
        taxTotal.setValue(value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taxTotal == null) ? 0 : taxTotal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceTaxTotalAdapter other = (InvoiceTaxTotalAdapter) obj;
        if (taxTotal == null) {
            if (other.taxTotal != null)
                return false;
        } else if (!taxTotal.equals(other.taxTotal))
            return false;
        return true;
    }

}
