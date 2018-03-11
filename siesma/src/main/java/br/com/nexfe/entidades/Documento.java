package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { @NamedQuery(name="Documento.selectAll", query="select e from Documento e order by e.nomeDocumento") } )
@Table(name = "DOCUMENTO")
public class Documento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_DOCUMENTO")
	private Long idDocumento;
	
	@Column(name = "NOME_DOCUMENTO")
	private String nomeDocumento;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, 
			targetEntity = MatriculaDocumento.class, mappedBy="documento")
	private List<MatriculaDocumento> matriculasDocumentos;

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}
	
	public List<MatriculaDocumento> getMatriculasDocumentos() {
		return matriculasDocumentos;
	}

	public void setMatriculasDocumentos(List<MatriculaDocumento> matriculasDocumentos) {
		this.matriculasDocumentos = matriculasDocumentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDocumento == null) ? 0 : idDocumento.hashCode());
		result = prime * result + ((nomeDocumento == null) ? 0 : nomeDocumento.hashCode());
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
		Documento other = (Documento) obj;
		if (idDocumento == null) {
			if (other.idDocumento != null)
				return false;
		} else if (!idDocumento.equals(other.idDocumento))
			return false;
		if (nomeDocumento == null) {
			if (other.nomeDocumento != null)
				return false;
		} else if (!nomeDocumento.equals(other.nomeDocumento))
			return false;
		return true;
	}
	
}
