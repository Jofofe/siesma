package br.com.nexfe.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { @NamedQuery(name="Curso.selectAll", query="select e from Curso e order by e.nome") } )
@Table(name = "CURSO")
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 5664191229458738516L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CURSO")
	private Long idCurso;
	
	@Column(name = "NOME_CURSO")
	private String nome;
	
	@Column(name = "CARGA_HORARIA")
	private Integer cargaHoraria;
	
	@Column(name = "VALOR_CURSO")
	private BigDecimal valorCurso;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Modulo.class, mappedBy="curso")
	private List<Modulo> modulos;

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

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargaHoraria == null) ? 0 : cargaHoraria.hashCode());
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valorCurso == null) {
			if (other.valorCurso != null)
				return false;
		} else if (!valorCurso.equals(other.valorCurso))
			return false;
		return true;
	}
	
}
