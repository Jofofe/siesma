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
@NamedQueries(value = { @NamedQuery(name="DescontoAplicado.selectAllDate", query="select e from DescontoAplicado e where e.aluno.dtFimVinculo is null "
		+ "and :dataAtual between e.modulo.dtInicio and e.modulo.dtFim and :dataAtual between e.desconto.dtInicio and e.desconto.dtFim order by e.aluno.nome") } )
@Table(name = "DESCONTO_APLICADO")
public class DescontoAplicado implements Serializable {
	
	private static final long serialVersionUID = -2959477147744399856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DESCONTO_APLICADO")
	private Long idDescontoAplicado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODULO")
	private Modulo modulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DESCONTO")
	private Desconto desconto;
	
	@Column(name = "OBS_DESCONTO_APLICADO", length = 100)
	private String obsDesconto;

	public Long getIdDescontoAplicado() {
		return idDescontoAplicado;
	}

	public void setIdDescontoAplicado(Long idDescontoAplicado) {
		this.idDescontoAplicado = idDescontoAplicado;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public String getObsDesconto() {
		return obsDesconto;
	}

	public void setObsDesconto(String obsDesconto) {
		this.obsDesconto = obsDesconto;
	}
	
}
