package br.com.nexfe.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name="Empregado.selectAllNoDistinction", query="select e from Empregado e order by e.nome"),
		@NamedQuery(name="Empregado.selectAll", query="select e from Empregado e where e.dtFimVinculo is null order by e.nome") ,
		@NamedQuery(name="Empregado.listarProfessores", query="select e from Empregado e where e.funcao.idFuncao = 2 "
				+ "and e.dtFimVinculo is null order by e.nome") 
})
@Table(name = "EMPREGADO")
@PrimaryKeyJoinColumn(name="ID_EMPREGADO", referencedColumnName = "ID_USUARIO")
public class Empregado extends Usuario{

	private static final long serialVersionUID = 2128384515857966003L;
	
	@Column(name = "VALOR_HORA")
	private BigDecimal valorHora;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_FUNCAO")
	private Funcao funcao;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = ProfessorDisciplina.class, mappedBy="empregado")
	private List<ProfessorDisciplina> professoresDisciplinas;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = LancamentoComercial.class, mappedBy="empregado")
	private List<LancamentoComercial> lancamentosComerciais;
	
	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<ProfessorDisciplina> getProfessoresDisciplinas() {
		return professoresDisciplinas;
	}

	public void setProfessoresDisciplinas(List<ProfessorDisciplina> professoresDisciplinas) {
		this.professoresDisciplinas = professoresDisciplinas;
	}
	
	public List<LancamentoComercial> getLancamentosComerciais() {
		return lancamentosComerciais;
	}

	public void setLancamentosComerciais(List<LancamentoComercial> lancamentosComerciais) {
		this.lancamentosComerciais = lancamentosComerciais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((professoresDisciplinas == null) ? 0 : professoresDisciplinas.hashCode());
		result = prime * result + ((valorHora == null) ? 0 : valorHora.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empregado other = (Empregado) obj;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (professoresDisciplinas == null) {
			if (other.professoresDisciplinas != null)
				return false;
		} else if (!professoresDisciplinas.equals(other.professoresDisciplinas))
			return false;
		if (valorHora == null) {
			if (other.valorHora != null)
				return false;
		} else if (!valorHora.equals(other.valorHora))
			return false;
		return true;
	}

}
