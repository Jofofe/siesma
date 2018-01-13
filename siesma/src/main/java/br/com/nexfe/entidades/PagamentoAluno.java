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
@NamedQueries(value = { @NamedQuery(name="PagamentoAluno.selectAll", query="select e from PagamentoAluno e order by e.aluno.nome") } )
@Table(name = "PAGAMENTO_ALUNO")
public class PagamentoAluno implements Serializable {
	
	private static final long serialVersionUID = 6582019387438966425L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAGAMENTO_ALUNO")
	private Long idPagamentoAluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ALUNO")
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LANCAMENTO_COMERCIAL")
	private LancamentoComercial lancamentoComercial;

	public Long getIdPagamentoAluno() {
		return idPagamentoAluno;
	}

	public void setIdPagamentoAluno(Long idPagamentoAluno) {
		this.idPagamentoAluno = idPagamentoAluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LancamentoComercial getLancamentoComercial() {
		return lancamentoComercial;
	}

	public void setLancamentoComercial(LancamentoComercial lancamentoComercial) {
		this.lancamentoComercial = lancamentoComercial;
	}
	
}
