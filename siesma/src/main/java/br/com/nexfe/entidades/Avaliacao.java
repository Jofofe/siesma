package br.com.nexfe.entidades;

import java.io.Serializable;

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
import javax.persistence.Table;

@Entity
@NamedQueries(value = { @NamedQuery(name="Avaliacao.selectAll", query="select e from Avaliacao e order by e.nome") } )
@Table(name = "AVALIACAO")
public class Avaliacao implements Serializable {
	
	private static final long serialVersionUID = 5203700797322414197L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AVALIACAO")
	private Long idAvaliacao;
	
	@Column(name = "NOME_AVALIACAO", nullable = false)
	private String nome;
	
	@Column(name = "OBS_AVALIACAO", nullable = false)
	private String obsAvaliacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_AVALIACAO")
	private TipoAvaliacao tipoAvaliacao;

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObsAvaliacao() {
		return obsAvaliacao;
	}

	public void setObsAvaliacao(String obsAvaliacao) {
		this.obsAvaliacao = obsAvaliacao;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}
	
}