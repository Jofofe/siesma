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
@NamedQueries(value = { @NamedQuery(name="Presenca.selectAll", query="select e from Presenca e") } )
@Table(name = "PRESENCA")
public class Presenca implements Serializable {
	
	private static final long serialVersionUID = 7645164975625551773L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRESENCA")
	private Long idPresenca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DISCIPLINA")
	private Disciplina disciplina;
	
	@Column(name = "DATA_PRESENCA", nullable = false)
	private Date dtPresenca;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, 
			targetEntity = PresencaMatricula.class, mappedBy="presenca")
	private List<PresencaMatricula> presencasMatriculas;

	public Long getIdPresenca() {
		return idPresenca;
	}

	public void setIdPresenca(Long idPresenca) {
		this.idPresenca = idPresenca;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDtPresenca() {
		return dtPresenca;
	}

	public void setDtPresenca(Date dtPresenca) {
		this.dtPresenca = dtPresenca;
	}

	public List<PresencaMatricula> getPresencasMatriculas() {
		return presencasMatriculas;
	}

	public void setPresencasMatriculas(List<PresencaMatricula> presencasMatriculas) {
		this.presencasMatriculas = presencasMatriculas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((dtPresenca == null) ? 0 : dtPresenca.hashCode());
		result = prime * result + ((idPresenca == null) ? 0 : idPresenca.hashCode());
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
		Presenca other = (Presenca) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (dtPresenca == null) {
			if (other.dtPresenca != null)
				return false;
		} else if (!dtPresenca.equals(other.dtPresenca))
			return false;
		if (idPresenca == null) {
			if (other.idPresenca != null)
				return false;
		} else if (!idPresenca.equals(other.idPresenca))
			return false;
		return true;
	}
	
}