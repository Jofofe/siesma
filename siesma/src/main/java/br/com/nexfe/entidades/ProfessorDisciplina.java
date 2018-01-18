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
@NamedQueries(value = { @NamedQuery(name="ProfessorDisciplina.selectAllDate", query="select e from ProfessorDisciplina e where :dataAtual between e.dtInicio and e.dtFim "
		+ " and :dataAtual between e.disciplina.dtInicio and e.disciplina.dtFim and :dataAtual between e.disciplina.modulo.dtInicio and e.disciplina.modulo.dtFim "
		+ " and e.disciplina.modulo.curso.inExcluido = 'N' and e.empregado.dtFimVinculo is null order by e.disciplina.nome") } )
@Table(name = "PROFESSOR_DISCIPLINA")
public class ProfessorDisciplina implements Serializable {
	
	private static final long serialVersionUID = -8680107554646482802L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROFESSOR_DISCIPLINA")
	private Long idProfessorDisciplina;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPREGADO")
	private Empregado empregado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DISCIPLINA")
	private Disciplina disciplina;
	
	@Column(name = "DT_INICIO", nullable = false)
	private Date dtInicio;
	
	@Column(name = "DT_FIM", nullable = false)
	private Date dtFim;

	public Long getIdProfessorDisciplina() {
		return idProfessorDisciplina;
	}

	public void setIdProfessorDisciplina(Long idProfessorDisciplina) {
		this.idProfessorDisciplina = idProfessorDisciplina;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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
	
}
