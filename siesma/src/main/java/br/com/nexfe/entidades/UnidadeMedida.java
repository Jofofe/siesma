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
@NamedQueries(value = { @NamedQuery(name="UnidadeMedida.selectAll", query="select e from UnidadeMedida e order by e.nomeUnidadeMedida") } )
@Table(name = "UNIDADE_MEDIDA")
public class UnidadeMedida implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_UNIDADE_MEDIDA")
	private Long idUnidadeMedida;
	
	@Column(name = "NOME_UNIDADE_MEDIDA")
	private String nomeUnidadeMedida;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = TipoLancamento.class, mappedBy="unidadeMedida")
	private List<TipoLancamento> tiposLancamentos;

	public Long getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(Long idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public String getNomeUnidadeMedida() {
		return nomeUnidadeMedida;
	}

	public void setNomeUnidadeMedida(String nomeUnidadeMedida) {
		this.nomeUnidadeMedida = nomeUnidadeMedida;
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
		result = prime * result + ((idUnidadeMedida == null) ? 0 : idUnidadeMedida.hashCode());
		result = prime * result + ((nomeUnidadeMedida == null) ? 0 : nomeUnidadeMedida.hashCode());
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
		UnidadeMedida other = (UnidadeMedida) obj;
		if (idUnidadeMedida == null) {
			if (other.idUnidadeMedida != null)
				return false;
		} else if (!idUnidadeMedida.equals(other.idUnidadeMedida))
			return false;
		if (nomeUnidadeMedida == null) {
			if (other.nomeUnidadeMedida != null)
				return false;
		} else if (!nomeUnidadeMedida.equals(other.nomeUnidadeMedida))
			return false;
		return true;
	}
	
}
