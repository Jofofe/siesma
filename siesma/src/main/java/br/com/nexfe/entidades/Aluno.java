package br.com.nexfe.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumn(name="ID_USUARIO")
public class Aluno extends Usuario {

	private static final long serialVersionUID = 9005969662213209863L;
	
	@Column(name = "DT_NASCIMENTO", nullable = false)
	private Date dtNascimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GENERO")
	private Genero genero;
	
	@Column(name = "NATURALIDADE", length = 20, nullable = false)
	private String naturalidade;
	
	@Column(name = "PROFISSAO", length = 20)
	private String profissao;
	
	@Column(name = "ENDERECO", length = 100, nullable = false)
	private String endereco;
	
	@Column(name = "BAIRRO", length = 50, nullable = false)
	private String bairro;
	
	@Column(name = "CIDADE", length = 50, nullable = false)
	private String cidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UF")
	private Uf uf;
	
	@Column(name = "CEP", length = 20, nullable = false)
	private String cep;
	
	@Column(name = "TEL_RESID", length = 20)
	private String telResidencia;
	
	@Column(name = "TEL_COMERCIAL", length = 20)
	private String telComercial;
	
	@Column(name = "DT_VENCIMENTO", nullable = false)
	private Date dtVencimento;
	
	@Column(name = "IES_GRADUACAO", length = 50, nullable = false)
	private String iesGraduacao;
	
	@Column(name = "SITUACAO_COMERCIAL", length = 50, nullable = false)
	private String situacaoComercial;

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelResidencia() {
		return telResidencia;
	}

	public void setTelResidencia(String telResidencia) {
		this.telResidencia = telResidencia;
	}

	public String getTelComercial() {
		return telComercial;
	}

	public void setTelComercial(String telComercial) {
		this.telComercial = telComercial;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public String getIesGraduacao() {
		return iesGraduacao;
	}

	public void setIesGraduacao(String iesGraduacao) {
		this.iesGraduacao = iesGraduacao;
	}

	public String getSituacaoComercial() {
		return situacaoComercial;
	}

	public void setSituacaoComercial(String situacaoComercial) {
		this.situacaoComercial = situacaoComercial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + ((dtVencimento == null) ? 0 : dtVencimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((iesGraduacao == null) ? 0 : iesGraduacao.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((situacaoComercial == null) ? 0 : situacaoComercial.hashCode());
		result = prime * result + ((telComercial == null) ? 0 : telComercial.hashCode());
		result = prime * result + ((telResidencia == null) ? 0 : telResidencia.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Aluno other = (Aluno) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (dtVencimento == null) {
			if (other.dtVencimento != null)
				return false;
		} else if (!dtVencimento.equals(other.dtVencimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (iesGraduacao == null) {
			if (other.iesGraduacao != null)
				return false;
		} else if (!iesGraduacao.equals(other.iesGraduacao))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (situacaoComercial == null) {
			if (other.situacaoComercial != null)
				return false;
		} else if (!situacaoComercial.equals(other.situacaoComercial))
			return false;
		if (telComercial == null) {
			if (other.telComercial != null)
				return false;
		} else if (!telComercial.equals(other.telComercial))
			return false;
		if (telResidencia == null) {
			if (other.telResidencia != null)
				return false;
		} else if (!telResidencia.equals(other.telResidencia))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

}