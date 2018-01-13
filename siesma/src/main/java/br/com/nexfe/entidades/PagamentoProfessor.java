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
@NamedQueries(value = { @NamedQuery(name="PagamentoProfessor.selectAll", query="select e from PagamentoProfessor e order by e.empregado.nome") } )
@Table(name = "PAGAMENTO_PROFESSOR")
public class PagamentoProfessor implements Serializable {
	
	private static final long serialVersionUID = -8896955351488829799L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAGAMENTO_PROFESSOR")
	private Long idPagamentoProfessor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROFESSOR")
	private Empregado empregado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LANCAMENTO_COMERCIAL")
	private LancamentoComercial lancamentoComercial;

	public Long getIdPagamentoProfessor() {
		return idPagamentoProfessor;
	}

	public void setIdPagamentoProfessor(Long idPagamentoProfessor) {
		this.idPagamentoProfessor = idPagamentoProfessor;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public LancamentoComercial getLancamentoComercial() {
		return lancamentoComercial;
	}

	public void setLancamentoComercial(LancamentoComercial lancamentoComercial) {
		this.lancamentoComercial = lancamentoComercial;
	}
	
}
