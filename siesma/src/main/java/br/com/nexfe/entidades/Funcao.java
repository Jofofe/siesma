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
@NamedQueries(value = { @NamedQuery(name="Funcao.selectAll", query="select e from Funcao e order by e.nomeFuncao") } )
@Table(name = "FUNCAO")
public class Funcao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_FUNCAO")
	private Long idFuncao;
	
	@Column(name = "NOME_FUNCAO")
	private String nomeFuncao;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Empregado.class, mappedBy="funcao")
	private List<Empregado> empregados;

	public Long getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(Long idFuncao) {
		this.idFuncao = idFuncao;
	}

	public String getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeAcesso(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncao == null) ? 0 : idFuncao.hashCode());
		result = prime * result + ((nomeFuncao == null) ? 0 : nomeFuncao.hashCode());
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
		Funcao other = (Funcao) obj;
		if (idFuncao == null) {
			if (other.idFuncao != null)
				return false;
		} else if (!idFuncao.equals(other.idFuncao))
			return false;
		if (nomeFuncao == null) {
			if (other.nomeFuncao != null)
				return false;
		} else if (!nomeFuncao.equals(other.nomeFuncao))
			return false;
		return true;
	}

}
