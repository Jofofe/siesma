package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name="TipoLancamento.selectAll", query="select e from TipoLancamento e where e.status = 'Ativo' order by e.descricao"),
		@NamedQuery(name="TipoLancamento.selectAllNoDistinction", query="select e from TipoLancamento e order by e.descricao") 
} )
@Table(name = "TIPO_LANCAMENTO")
public class TipoLancamento implements Serializable {
	
	private static final long serialVersionUID = 5865432441665436228L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_LANCAMENTO")
	private Long idTipoLancamento;
	
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UNIDADE_MEDIDA")
	private UnidadeMedida unidadeMedida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_PAGAMENTO")
	private TipoPagamento tipoPagamento;
	
	@Column(name = "OBS_LANCAMENTO", length = 100)
	private String obsLancamento;
	
	@Column(name = "STATUS", length = 20, nullable = false)
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = LancamentoComercial.class, mappedBy="tipoLancamento")
	private List<LancamentoComercial> lancamentosComerciais;

	public Long getIdTipoLancamento() {
		return idTipoLancamento;
	}

	public void setIdTipoLancamento(Long idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getObsLancamento() {
		return obsLancamento;
	}

	public void setObsLancamento(String obsLancamento) {
		this.obsLancamento = obsLancamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<LancamentoComercial> getLancamentosComerciais() {
		return lancamentosComerciais;
	}

	public void setLancamentosComerciais(List<LancamentoComercial> lancamentosComerciais) {
		this.lancamentosComerciais = lancamentosComerciais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idTipoLancamento == null) ? 0 : idTipoLancamento.hashCode());
		result = prime * result + ((obsLancamento == null) ? 0 : obsLancamento.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoPagamento == null) ? 0 : tipoPagamento.hashCode());
		result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
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
		TipoLancamento other = (TipoLancamento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idTipoLancamento == null) {
			if (other.idTipoLancamento != null)
				return false;
		} else if (!idTipoLancamento.equals(other.idTipoLancamento))
			return false;
		if (obsLancamento == null) {
			if (other.obsLancamento != null)
				return false;
		} else if (!obsLancamento.equals(other.obsLancamento))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoPagamento == null) {
			if (other.tipoPagamento != null)
				return false;
		} else if (!tipoPagamento.equals(other.tipoPagamento))
			return false;
		if (unidadeMedida == null) {
			if (other.unidadeMedida != null)
				return false;
		} else if (!unidadeMedida.equals(other.unidadeMedida))
			return false;
		return true;
	}
	
}
