package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { @NamedQuery(name="ClassePagamento.selectAll", query="select e from ClassePagamento e order by e.nomeClassePagamento") } )
@Table(name = "CLASSE_PAGAMENTO")
public class ClassePagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CLASSE_PAGAMENTO")
	private Long idClassePagamento;
	
	@Column(name = "NOME_CLASSE_PAGAMENTO")
	private String nomeClassePagamento;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = FormaPagamento.class, mappedBy="classePagamento")
	private List<FormaPagamento> formasPagamento;

	public Long getIdClassePagamento() {
		return idClassePagamento;
	}

	public void setIdClassePagamento(Long idClassePagamento) {
		this.idClassePagamento = idClassePagamento;
	}

	public String getNomeClassePagamento() {
		return nomeClassePagamento;
	}

	public void setNomeClassePagamento(String nomeClassePagamento) {
		this.nomeClassePagamento = nomeClassePagamento;
	}

	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClassePagamento == null) ? 0 : idClassePagamento.hashCode());
		result = prime * result + ((nomeClassePagamento == null) ? 0 : nomeClassePagamento.hashCode());
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
		ClassePagamento other = (ClassePagamento) obj;
		if (idClassePagamento == null) {
			if (other.idClassePagamento != null)
				return false;
		} else if (!idClassePagamento.equals(other.idClassePagamento))
			return false;
		if (nomeClassePagamento == null) {
			if (other.nomeClassePagamento != null)
				return false;
		} else if (!nomeClassePagamento.equals(other.nomeClassePagamento))
			return false;
		return true;
	}

}
