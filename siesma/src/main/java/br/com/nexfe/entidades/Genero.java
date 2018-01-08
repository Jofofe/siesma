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
@NamedQueries(value = { @NamedQuery(name="Genero.selectAll", query="select e from Genero e order by e.nomeGenero") } )
@Table(name = "GENERO")
public class Genero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_GENERO")
	private Long idGenero;
	
	@Column(name = "NOME_GENERO")
	private String nomeGenero;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Aluno.class, mappedBy="genero")
	private List<Aluno> alunos;

	public Long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNomeGenero() {
		return nomeGenero;
	}

	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGenero == null) ? 0 : idGenero.hashCode());
		result = prime * result + ((nomeGenero == null) ? 0 : nomeGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (idGenero == null) {
			if (other.idGenero != null)
				return false;
		} else if (!idGenero.equals(other.idGenero))
			return false;
		if (nomeGenero == null) {
			if (other.nomeGenero != null)
				return false;
		} else if (!nomeGenero.equals(other.nomeGenero))
			return false;
		return true;
	}

}
