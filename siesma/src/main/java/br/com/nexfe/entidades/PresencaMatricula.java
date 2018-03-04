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
@NamedQueries(value = { @NamedQuery(name="PresencaMatricula.selectAll", query="select e from PresencaMatricula e") } )
@Table(name = "PRESENCA_MATRICULA")
public class PresencaMatricula implements Serializable {
	
	static final long serialVersionUID = -5858676501460136026L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRESENCA_MATRICULA")
	private Long idPresencaMatricula;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRESENCA")
	private Presenca presenca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATRICULA")
	private Matricula matricula;
	
	@Column(name = "PRESENCA_DIA", nullable = false)
	private boolean presencaDia;

	public Long getIdPresencaMatricula() {
		return idPresencaMatricula;
	}

	public void setIdPresencaMatricula(Long idPresencaMatricula) {
		this.idPresencaMatricula = idPresencaMatricula;
	}

	public Presenca getPresenca() {
		return presenca;
	}

	public void setPresenca(Presenca presenca) {
		this.presenca = presenca;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public boolean isPresencaDia() {
		return presencaDia;
	}

	public void setPresencaDia(boolean presencaDia) {
		this.presencaDia = presencaDia;
	}
	
}
