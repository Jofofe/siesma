package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UF")
public class Uf implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_UF")
	private Long idUf;
	
	@Column(name = "NOME_UF")
	private String nomeUf;
	
	@Column(name = "SG_UF")
	private String sgUf;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Aluno.class, mappedBy="uf")
	private List<Aluno> alunos;

	public Long getIdUf() {
		return idUf;
	}

	public void setIdUf(Long idUf) {
		this.idUf = idUf;
	}

	public String getNomeUf() {
		return nomeUf;
	}

	public void setNomeUf(String nomeUf) {
		this.nomeUf = nomeUf;
	}

	public String getSgUf() {
		return sgUf;
	}

	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
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
		result = prime * result + ((idUf == null) ? 0 : idUf.hashCode());
		result = prime * result + ((nomeUf == null) ? 0 : nomeUf.hashCode());
		result = prime * result + ((sgUf == null) ? 0 : sgUf.hashCode());
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
		Uf other = (Uf) obj;
		if (idUf == null) {
			if (other.idUf != null)
				return false;
		} else if (!idUf.equals(other.idUf))
			return false;
		if (nomeUf == null) {
			if (other.nomeUf != null)
				return false;
		} else if (!nomeUf.equals(other.nomeUf))
			return false;
		if (sgUf == null) {
			if (other.sgUf != null)
				return false;
		} else if (!sgUf.equals(other.sgUf))
			return false;
		return true;
	}

}
