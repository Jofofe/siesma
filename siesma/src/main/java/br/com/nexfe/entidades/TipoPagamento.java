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
@NamedQueries(value = { @NamedQuery(name="TipoPagamento.selectAll", query="select e from TipoPagamento e order by e.nomeTipoPagamento") } )
@Table(name = "TIPO_PAGAMENTO")
public class TipoPagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TIPO_PAGAMENTO")
	private Long idTipoPagamento;
	
	@Column(name = "NOME_TIPO_PAGAMENTO")
	private String nomeTipoPagamento;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = TipoLancamento.class, mappedBy="tipoPagamento")
	private List<TipoLancamento> tiposLancamentos;

	public Long getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(Long idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public String getNomeTipoPagamento() {
		return nomeTipoPagamento;
	}

	public void setNomeTipoPagamento(String nomeTipoPagamento) {
		this.nomeTipoPagamento = nomeTipoPagamento;
	}

	public List<TipoLancamento> getTiposLancamentos() {
		return tiposLancamentos;
	}

	public void setTiposLancamentos(List<TipoLancamento> tiposLancamentos) {
		this.tiposLancamentos = tiposLancamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoPagamento == null) ? 0 : idTipoPagamento.hashCode());
		result = prime * result + ((nomeTipoPagamento == null) ? 0 : nomeTipoPagamento.hashCode());
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
		TipoPagamento other = (TipoPagamento) obj;
		if (idTipoPagamento == null) {
			if (other.idTipoPagamento != null)
				return false;
		} else if (!idTipoPagamento.equals(other.idTipoPagamento))
			return false;
		if (nomeTipoPagamento == null) {
			if (other.nomeTipoPagamento != null)
				return false;
		} else if (!nomeTipoPagamento.equals(other.nomeTipoPagamento))
			return false;
		return true;
	}
	
}
