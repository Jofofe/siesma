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
@Table(name = "NIVEL_ACESSO")
public class NivelAcesso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_NIVEL_ACESSO")
	private Long idNivelAcesso;
	
	@Column(name = "NOME_ACESSO")
	private String nomeAcesso;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Usuario.class, mappedBy="nivelAcesso")
	private List<Usuario> usuarios;

	public Long getIdNivelAcesso() {
		return idNivelAcesso;
	}

	public void setIdNivelAcesso(Long idNivelAcesso) {
		this.idNivelAcesso = idNivelAcesso;
	}

	public String getNomeAcesso() {
		return nomeAcesso;
	}

	public void setNomeAcesso(String nomeAcesso) {
		this.nomeAcesso = nomeAcesso;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNivelAcesso == null) ? 0 : idNivelAcesso.hashCode());
		result = prime * result + ((nomeAcesso == null) ? 0 : nomeAcesso.hashCode());
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
		NivelAcesso other = (NivelAcesso) obj;
		if (idNivelAcesso == null) {
			if (other.idNivelAcesso != null)
				return false;
		} else if (!idNivelAcesso.equals(other.idNivelAcesso))
			return false;
		if (nomeAcesso == null) {
			if (other.nomeAcesso != null)
				return false;
		} else if (!nomeAcesso.equals(other.nomeAcesso))
			return false;
		return true;
	}

}
