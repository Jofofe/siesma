package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.Date;

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
@NamedQueries(value = { @NamedQuery(name="Matricula.selectAll", query="select e from Matricula e where e.dtCancelamento is null"
		+ " and e.dtFimEfetivo is null and e.aluno.dtFimVinculo is null order by e.aluno.nome") } )
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

	public Long getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
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
	
}