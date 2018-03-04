package br.com.nexfe.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Transient;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name="LancamentoComercial.selectAllDate", query="select e from LancamentoComercial e where :dataAtual between e.formaPagamento.dtInicio and e.formaPagamento.dtFim "
		+ " order by e.formaPagamento.nome"),
		@NamedQuery(name="LancamentoComercial.selectAll", query="select e from LancamentoComercial e")
} )
@Table(name = "LANCAMENTO_COMERCIAL")
public class LancamentoComercial implements Serializable {
	
	private static final long serialVersionUID = 2110315437815080324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LANCAMENTO_COMERCIAL")
	private Long idLancamentoComercial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FORMA_PAGAMENTO")
	private FormaPagamento formaPagamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_LANCAMENTO")
	private TipoLancamento tipoLancamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATRICULA")
	private Matricula matricula;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DESCONTO")
	private Desconto desconto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPREGADO")
	private Empregado empregado;
	
	@Column(name = "VALOR_RECEBIMENTO", nullable = false)
	private BigDecimal vlRecebimento;
	
	@Column(name = "DT_PREVISTA")
	private Date dtPrevista;
	
	@Column(name = "DT_RECEBIMENTO")
	private Date dtRecebimento;
	
	@Column(name = "STATUS", length = 20, nullable = false)
	private String status;
	
	@Column(name = "OBS_RECEBIMENTO", length = 100)
	private String obsRecebimento;
	
	@Transient
	public String getNomeContemplado() {
		if(getMatricula() == null) {
			return getEmpregado().getNome();
		} else {
			return getMatricula().getAluno().getNome();
		}
	}

	public Long getIdLancamentoComercial() {
		return idLancamentoComercial;
	}

	public void setIdLancamentoComercial(Long idLancamentoComercial) {
		this.idLancamentoComercial = idLancamentoComercial;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public BigDecimal getVlRecebimento() {
		return vlRecebimento;
	}

	public void setVlRecebimento(BigDecimal vlRecebimento) {
		this.vlRecebimento = vlRecebimento;
	}

	public Date getDtPrevista() {
		return dtPrevista;
	}

	public void setDtPrevista(Date dtPrevista) {
		this.dtPrevista = dtPrevista;
	}

	public Date getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(Date dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObsRecebimento() {
		return obsRecebimento;
	}

	public void setObsRecebimento(String obsRecebimento) {
		this.obsRecebimento = obsRecebimento;
	}
	
	public String getTipoContemplado() {
		if(getMatricula() == null) {
			return "Empregado";
		} else {
			return "Aluno matriculado";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtPrevista == null) ? 0 : dtPrevista.hashCode());
		result = prime * result + ((dtRecebimento == null) ? 0 : dtRecebimento.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((idLancamentoComercial == null) ? 0 : idLancamentoComercial.hashCode());
		result = prime * result + ((obsRecebimento == null) ? 0 : obsRecebimento.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vlRecebimento == null) ? 0 : vlRecebimento.hashCode());
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
		LancamentoComercial other = (LancamentoComercial) obj;
		if (dtPrevista == null) {
			if (other.dtPrevista != null)
				return false;
		} else if (!dtPrevista.equals(other.dtPrevista))
			return false;
		if (dtRecebimento == null) {
			if (other.dtRecebimento != null)
				return false;
		} else if (!dtRecebimento.equals(other.dtRecebimento))
			return false;
		if (formaPagamento == null) {
			if (other.formaPagamento != null)
				return false;
		} else if (!formaPagamento.equals(other.formaPagamento))
			return false;
		if (idLancamentoComercial == null) {
			if (other.idLancamentoComercial != null)
				return false;
		} else if (!idLancamentoComercial.equals(other.idLancamentoComercial))
			return false;
		if (obsRecebimento == null) {
			if (other.obsRecebimento != null)
				return false;
		} else if (!obsRecebimento.equals(other.obsRecebimento))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (vlRecebimento == null) {
			if (other.vlRecebimento != null)
				return false;
		} else if (!vlRecebimento.equals(other.vlRecebimento))
			return false;
		return true;
	}
	
}