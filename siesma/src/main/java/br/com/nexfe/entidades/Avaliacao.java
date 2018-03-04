package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
		@NamedQuery(name="Avaliacao.selectAllDate", query="select e from Avaliacao e where :dataAtual between e.disciplina.dtInicio and e.disciplina.dtFim "
		+ " and :dataAtual between e.disciplina.modulo.dtInicio and e.disciplina.modulo.dtFim and e.disciplina.modulo.curso.inExcluido = 'N' order by e.disciplina.nome"),
		@NamedQuery(name="Avaliacao.selectAllComNota", query="select distinct e from Avaliacao e INNER JOIN e.avaliacoesNotas an where :dataAtual between e.disciplina.dtInicio and e.disciplina.dtFim "
				+ " and :dataAtual between e.disciplina.modulo.dtInicio and e.disciplina.modulo.dtFim and e.disciplina.modulo.curso.inExcluido = 'N'") 
} )
@Table(name = "AVALIACAO")
public class Avaliacao implements Serializable {
	
	private static final long serialVersionUID = 5203700797322414197L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AVALIACAO")
	private Long idAvaliacao;
	
	@Column(name = "NOME_AVALIACAO", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "OBS_AVALIACAO", length = 100)
	private String obsAvaliacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_AVALIACAO")
	private TipoAvaliacao tipoAvaliacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DISCIPLINA")
	private Disciplina disciplina;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, 
			targetEntity = AvaliacaoNota.class, mappedBy="avaliacao")
	private List<AvaliacaoNota> avaliacoesNotas;

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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<AvaliacaoNota> getAvaliacoesNotas() {
		return avaliacoesNotas;
	}

	public void setAvaliacoesNotas(List<AvaliacaoNota> avaliacoesNotas) {
		this.avaliacoesNotas = avaliacoesNotas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((idAvaliacao == null) ? 0 : idAvaliacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((obsAvaliacao == null) ? 0 : obsAvaliacao.hashCode());
		result = prime * result + ((tipoAvaliacao == null) ? 0 : tipoAvaliacao.hashCode());
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
		Avaliacao other = (Avaliacao) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (idAvaliacao == null) {
			if (other.idAvaliacao != null)
				return false;
		} else if (!idAvaliacao.equals(other.idAvaliacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (obsAvaliacao == null) {
			if (other.obsAvaliacao != null)
				return false;
		} else if (!obsAvaliacao.equals(other.obsAvaliacao))
			return false;
		if (tipoAvaliacao == null) {
			if (other.tipoAvaliacao != null)
				return false;
		} else if (!tipoAvaliacao.equals(other.tipoAvaliacao))
			return false;
		return true;
	}
	
}