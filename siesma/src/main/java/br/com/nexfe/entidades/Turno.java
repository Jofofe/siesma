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
@NamedQueries(value = { @NamedQuery(name="Turno.selectAll", query="select e from Turno e order by e.nomeTurno") } )
@Table(name = "TURNO")
public class Turno implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TURNO")
	private Long idTurno;
	
	@Column(name = "NOME_Turno")
	private String nomeTurno;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Curso.class, mappedBy="turno")
	private List<Curso> cursos;

	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public String getNomeTurno() {
		return nomeTurno;
	}

	public void setNomeTurno(String nomeTurno) {
		this.nomeTurno = nomeTurno;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurno == null) ? 0 : idTurno.hashCode());
		result = prime * result + ((nomeTurno == null) ? 0 : nomeTurno.hashCode());
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
		Turno other = (Turno) obj;
		if (idTurno == null) {
			if (other.idTurno != null)
				return false;
		} else if (!idTurno.equals(other.idTurno))
			return false;
		if (nomeTurno == null) {
			if (other.nomeTurno != null)
				return false;
		} else if (!nomeTurno.equals(other.nomeTurno))
			return false;
		return true;
	}

}
