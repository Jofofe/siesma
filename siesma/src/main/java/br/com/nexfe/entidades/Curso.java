package br.com.nexfe.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@NamedQueries(value = { 
		@NamedQuery(name="Curso.selectAllNoDistinction", query="select e from Curso e order by e.nome"), 
		@NamedQuery(name="Curso.selectAll", query="select e from Curso e where e.inExcluido = 'N' order by e.nome"),
		@NamedQuery(name="Curso.selectCursosMatriculados", query="select e from Curso e join e.matriculas m where e.inExcluido = 'N' "
				+ "and m.aluno.idUsuario in (:idAluno) order by e.nome")
} )
@Table(name = "CURSO")
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 5664191229458738516L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CURSO")
	private Long idCurso;
	
	@Column(name = "NOME_CURSO", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "CARGA_HORARIA", nullable = false)
	private Integer cargaHoraria;
	
	@Column(name = "VALOR_CURSO", nullable = false)
	private BigDecimal valorCurso;
	
	@Column(name = "IN_EXCLUIDO", nullable = false)
	private String inExcluido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TURNO")
	private Turno turno;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Modulo.class, mappedBy="curso")
	private List<Modulo> modulos;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Matricula.class, mappedBy="curso")
	private List<Matricula> matriculas;
	
	@Column(name = "DT_INICIO", nullable = false)
	private Date dtInicio;
	
	@Column(name = "DT_FIM")
	private Date dtFim;

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public BigDecimal getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(BigDecimal valorCurso) {
		this.valorCurso = valorCurso;
	}
	
	public String getInExcluido() {
		return inExcluido;
	}

	public void setInExcluido(String inExcluido) {
		this.inExcluido = inExcluido;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargaHoraria == null) ? 0 : cargaHoraria.hashCode());
		result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
		result = prime * result + ((dtInicio == null) ? 0 : dtInicio.hashCode());
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
		result = prime * result + ((inExcluido == null) ? 0 : inExcluido.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		result = prime * result + ((valorCurso == null) ? 0 : valorCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (cargaHoraria == null) {
			if (other.cargaHoraria != null)
				return false;
		} else if (!cargaHoraria.equals(other.cargaHoraria))
			return false;
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
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		if (inExcluido == null) {
			if (other.inExcluido != null)
				return false;
		} else if (!inExcluido.equals(other.inExcluido))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		if (valorCurso == null) {
			if (other.valorCurso != null)
				return false;
		} else if (!valorCurso.equals(other.valorCurso))
			return false;
		return true;
	}
	
}
