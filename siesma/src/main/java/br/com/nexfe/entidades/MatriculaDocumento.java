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
@NamedQueries(value = { @NamedQuery(name="MatriculaDocumento.selectAll", query="select e from MatriculaDocumento e") } )
@Table(name = "MATRICULA_DOCUMENTO")
public class MatriculaDocumento implements Serializable {
	
	private static final long serialVersionUID = 1549556007971257400L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MATRICULA_DOCUMENTO")
	private Long idMatriculaDocumento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATRICULA")
	private Matricula matricula;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOCUMENTO")
	private Documento documento;
	
	@Column(name = "ENTREGUE", nullable = false)
	private boolean entregue;

	public Long getIdMatriculaDocumento() {
		return idMatriculaDocumento;
	}

	public void setIdMatriculaDocumento(Long idMatriculaDocumento) {
		this.idMatriculaDocumento = idMatriculaDocumento;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

}
