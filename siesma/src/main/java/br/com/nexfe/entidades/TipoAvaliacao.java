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
@NamedQueries(value = { @NamedQuery(name="TipoAvaliacao.selectAll", query="select e from TipoAvaliacao e order by e.nomeAvaliacao") } )
@Table(name = "TIPO_AVALIACAO")
public class TipoAvaliacao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TIPO_AVALIACAO")
	private Long idTipoAvaliacao;
	
	@Column(name = "NOME_TIPO_AVALIACAO")
	private String nomeAvaliacao;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Avaliacao.class, mappedBy="tipoAvaliacao")
	private List<Avaliacao> avaliacoes;

	public Long getIdTipoAvaliacao() {
		return idTipoAvaliacao;
	}

	public void setIdTipoAvaliacao(Long idTipoAvaliacao) {
		this.idTipoAvaliacao = idTipoAvaliacao;
	}

	public String getNomeAvaliacao() {
		return nomeAvaliacao;
	}

	public void setNomeAvaliacao(String nomeAvaliacao) {
		this.nomeAvaliacao = nomeAvaliacao;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoAvaliacao == null) ? 0 : idTipoAvaliacao.hashCode());
		result = prime * result + ((nomeAvaliacao == null) ? 0 : nomeAvaliacao.hashCode());
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
		TipoAvaliacao other = (TipoAvaliacao) obj;
		if (idTipoAvaliacao == null) {
			if (other.idTipoAvaliacao != null)
				return false;
		} else if (!idTipoAvaliacao.equals(other.idTipoAvaliacao))
			return false;
		if (nomeAvaliacao == null) {
			if (other.nomeAvaliacao != null)
				return false;
		} else if (!nomeAvaliacao.equals(other.nomeAvaliacao))
			return false;
		return true;
	}
	
}
