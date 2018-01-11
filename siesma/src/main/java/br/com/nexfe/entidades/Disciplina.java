package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.Date;
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
@NamedQueries(value = { @NamedQuery(name="Disciplina.selectAllDate", query="select e from Disciplina e where :dataAtual between e.dtInicio and e.dtFim "
		+ " and :dataAtual between e.modulo.dtInicio and e.modulo.dtFim and e.modulo.curso.inExcluido = 'N' order by e.nome") } )
@Table(name = "DISCIPLINA")
public class Disciplina implements Serializable {
	
	private static final long serialVersionUID = 742106924413082846L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DISCIPLINA")
	private Long idDisciplina;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODULO")
	private Modulo modulo;
	
	@Column(name = "NOME_DISCIPLINA", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "DT_INICIO", nullable = false)
	private Date dtInicio;
	
	@Column(name = "DT_FIM", nullable = false)
	private Date dtFim;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = ProfessorDisciplina.class, mappedBy="disciplina")
	private List<ProfessorDisciplina> professoresDisciplinas;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Avaliacao.class, mappedBy="disciplina")
	private List<Avaliacao> avaliacoes;

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public Modulo getModulo() {
		return modulo;
	}
	
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public List<ProfessorDisciplina> getProfessoresDisciplinas() {
		return professoresDisciplinas;
	}

	public void setProfessoresDisciplinas(List<ProfessorDisciplina> professoresDisciplinas) {
		this.professoresDisciplinas = professoresDisciplinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
		result = prime * result + ((dtInicio == null) ? 0 : dtInicio.hashCode());
		result = prime * result + ((idDisciplina == null) ? 0 : idDisciplina.hashCode());
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (dtFim == null) {
			if (other.dtFim != null)
				return false;
		} else if (!dtFim.equals(other.dtFim))
			return false;
		if (dtInicio == null) {
			if (other.dtInicio != null)
				return false;
		} else if (!dtInicio.equals(other.dtInicio))
			return false;
		if (idDisciplina == null) {
			if (other.idDisciplina != null)
				return false;
		} else if (!idDisciplina.equals(other.idDisciplina))
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}