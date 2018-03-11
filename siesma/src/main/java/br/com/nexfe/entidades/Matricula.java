package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.Date;
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
		@NamedQuery(name="Matricula.selectAll", query="select e from Matricula e where e.dtCancelamento is null"
		+ " and e.dtFimEfetivo is null and e.aluno.dtFimVinculo is null order by e.aluno.nome"), 
		@NamedQuery(name="Matricula.selectAllNoDistinction", query="select e from Matricula e order by e.aluno.nome")	
})
@Table(name = "MATRICULA")
public class Matricula implements Serializable {
	
	private static final long serialVersionUID = 2751071098684390695L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MATRICULA")
	private Long idMatricula;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ALUNO")
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CURSO")
	private Curso curso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODULO")
	private Modulo modulo;
	
	@Column(name = "DT_MATRICULA", nullable = false)
	private Date dtMatricula;
	
	@Column(name = "DT_FIM_PREVISTO")
	private Date dtFimPrevisto;
	
	@Column(name = "DT_FIM_EFETIVA")
	private Date dtFimEfetivo;
	
	@Column(name = "DT_CANCELAMENTO")
	private Date dtCancelamento;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = LancamentoComercial.class, mappedBy="matricula")
	private List<LancamentoComercial> lancamentosComerciais;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = PresencaMatricula.class, mappedBy="matricula")
	private List<PresencaMatricula> presencasMatriculas;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = AvaliacaoNota.class, mappedBy="matricula")
	private List<AvaliacaoNota> avaliacoesNotas;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, 
			targetEntity = MatriculaDocumento.class, mappedBy="matricula")
	private List<MatriculaDocumento> matriculasDocumentos;

	public Long getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}
	
	public String getAlunoCurso() {
		return aluno.getNome() + " - " + curso.getNome();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDtMatricula() {
		return dtMatricula;
	}

	public void setDtMatricula(Date dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public Date getDtFimPrevisto() {
		return dtFimPrevisto;
	}

	public void setDtFimPrevisto(Date dtFimPrevisto) {
		this.dtFimPrevisto = dtFimPrevisto;
	}

	public Date getDtFimEfetivo() {
		return dtFimEfetivo;
	}

	public void setDtFimEfetivo(Date dtFimEfetivo) {
		this.dtFimEfetivo = dtFimEfetivo;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<LancamentoComercial> getLancamentosComerciais() {
		return lancamentosComerciais;
	}

	public void setLancamentosComerciais(List<LancamentoComercial> lancamentosComerciais) {
		this.lancamentosComerciais = lancamentosComerciais;
	}
	
	public List<PresencaMatricula> getPresencasMatriculas() {
		return presencasMatriculas;
	}

	public void setPresencasMatriculas(List<PresencaMatricula> presencasMatriculas) {
		this.presencasMatriculas = presencasMatriculas;
	}

	public List<AvaliacaoNota> getAvaliacoesNotas() {
		return avaliacoesNotas;
	}

	public void setAvaliacoesNotas(List<AvaliacaoNota> avaliacoesNotas) {
		this.avaliacoesNotas = avaliacoesNotas;
	}

	public List<MatriculaDocumento> getMatriculasDocumentos() {
		return matriculasDocumentos;
	}

	public void setMatriculasDocumentos(List<MatriculaDocumento> matriculasDocumentos) {
		this.matriculasDocumentos = matriculasDocumentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((dtCancelamento == null) ? 0 : dtCancelamento.hashCode());
		result = prime * result + ((dtFimEfetivo == null) ? 0 : dtFimEfetivo.hashCode());
		result = prime * result + ((dtFimPrevisto == null) ? 0 : dtFimPrevisto.hashCode());
		result = prime * result + ((dtMatricula == null) ? 0 : dtMatricula.hashCode());
		result = prime * result + ((idMatricula == null) ? 0 : idMatricula.hashCode());
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
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
		Matricula other = (Matricula) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (dtCancelamento == null) {
			if (other.dtCancelamento != null)
				return false;
		} else if (!dtCancelamento.equals(other.dtCancelamento))
			return false;
		if (dtFimEfetivo == null) {
			if (other.dtFimEfetivo != null)
				return false;
		} else if (!dtFimEfetivo.equals(other.dtFimEfetivo))
			return false;
		if (dtFimPrevisto == null) {
			if (other.dtFimPrevisto != null)
				return false;
		} else if (!dtFimPrevisto.equals(other.dtFimPrevisto))
			return false;
		if (dtMatricula == null) {
			if (other.dtMatricula != null)
				return false;
		} else if (!dtMatricula.equals(other.dtMatricula))
			return false;
		if (idMatricula == null) {
			if (other.idMatricula != null)
				return false;
		} else if (!idMatricula.equals(other.idMatricula))
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		return true;
	}
	
}