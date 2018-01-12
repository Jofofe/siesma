package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { @NamedQuery(name="FormaPagamento.selectAllDate", query="select e from FormaPagamento e where :dataAtual between e.dtInicio and e.dtFim order by e.nome") } )
@Table(name = "FORMA_PAGAMENTO")
public class FormaPagamento implements Serializable {
	
	private static final long serialVersionUID = -1230554335503936347L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FORMA_PAGAMENTO")
	private Long idFormaPagamento;
	
	@Column(name = "NOME_PAGAMENTO", length = 50, nullable = false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLASSE_PAGAMENTO")
	private ClassePagamento classePagamento;
	
	@Column(name = "QTD_PARCELAS", nullable = false)
	private Integer qtdParcelas;
	
	@Column(name = "DT_INICIO", nullable = false)
	private Date dtInicio;
	
	@Column(name = "DT_FIM", nullable = false)
	private Date dtFim;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = LancamentoComercial.class, mappedBy="formaPagamento")
	private List<LancamentoComercial> lancamentosComerciais;

	public Long getIdFormaPagamento() {
		return idFormaPagamento;
	}

	public void setIdFormaPagamento(Long idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ClassePagamento getClassePagamento() {
		return classePagamento;
	}

	public void setClassePagamento(ClassePagamento classePagamento) {
		this.classePagamento = classePagamento;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
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
		int result = 1;
		result = prime * result + ((classePagamento == null) ? 0 : classePagamento.hashCode());
		result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
		result = prime * result + ((dtInicio == null) ? 0 : dtInicio.hashCode());
		result = prime * result + ((idFormaPagamento == null) ? 0 : idFormaPagamento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((qtdParcelas == null) ? 0 : qtdParcelas.hashCode());
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
		FormaPagamento other = (FormaPagamento) obj;
		if (classePagamento == null) {
			if (other.classePagamento != null)
				return false;
		} else if (!classePagamento.equals(other.classePagamento))
			return false;
		if (dtFim == null) {
			if (other.dtFim != null)
				return false;
		} else if (!dtFim.equals(other.dtFim))
			return false;
		if (dtInicio == null) {
			if (other.dtInicio != null)
				return false;
		} else if (!dtInicio.equals(other.dtInicio))
			return false;
		if (idFormaPagamento == null) {
			if (other.idFormaPagamento != null)
				return false;
		} else if (!idFormaPagamento.equals(other.idFormaPagamento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qtdParcelas == null) {
			if (other.qtdParcelas != null)
				return false;
		} else if (!qtdParcelas.equals(other.qtdParcelas))
			return false;
		return true;
	}
	
}