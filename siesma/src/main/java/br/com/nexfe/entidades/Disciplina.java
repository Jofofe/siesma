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
@NamedQueries(value = { @NamedQuery(name="Disciplina.selectAll", query="select e from Disciplina e order by e.nome") } )
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Empregado empregado;
	
	@Column(name = "NOME_DISCIPLINA", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "DT_INICIO", nullable = false)
	private Date dtInicio;
	
	@Column(name = "DT_FIM", nullable = false)
	private Date dtFim;

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public Modulo getModulo() {
		return modulo;
	}
	
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
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

}
