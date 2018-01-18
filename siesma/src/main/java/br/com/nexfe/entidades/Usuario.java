package br.com.nexfe.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@NamedQueries(value = { 
		@NamedQuery(name="Usuario.selectLogin", query="select e from Usuario e where e.email = :email and e.senha = :senha")
} )
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 2020574501561031630L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
    private Long idUsuario;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "CPF", length = 15, nullable = false)
	private String cpf;
	
	@Column(name = "RG", length = 20, nullable = false)
	private String rg;
	
	@Column(name = "ORGAO_EXPEDITOR", length = 6, nullable = false)
	private String orgaoExpeditor;
	
	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;
	
	@Column(name = "TEL_CELULAR", length = 20, nullable = false)
	private String telCelular;
	
	@Column(name = "SENHA_USUARIO", length = 20, nullable = false)
	private String senha;
	
	@Column(name = "DT_CADASTRO", nullable = false)
	private Date dtCadastro;
	
	@Column(name = "DT_FIM_VINCULO")
	private Date dtFimVinculo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_NIVEL_ACESSO")
	private NivelAcesso nivelAcesso;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtFimVinculo() {
		return dtFimVinculo;
	}

	public void setDtFimVinculo(Date dtFimVinculo) {
		this.dtFimVinculo = dtFimVinculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
		result = prime * result + ((dtFimVinculo == null) ? 0 : dtFimVinculo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nivelAcesso == null) ? 0 : nivelAcesso.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((orgaoExpeditor == null) ? 0 : orgaoExpeditor.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telCelular == null) ? 0 : telCelular.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (dtFimVinculo == null) {
			if (other.dtFimVinculo != null)
				return false;
		} else if (!dtFimVinculo.equals(other.dtFimVinculo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nivelAcesso == null) {
			if (other.nivelAcesso != null)
				return false;
		} else if (!nivelAcesso.equals(other.nivelAcesso))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (orgaoExpeditor == null) {
			if (other.orgaoExpeditor != null)
				return false;
		} else if (!orgaoExpeditor.equals(other.orgaoExpeditor))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telCelular == null) {
			if (other.telCelular != null)
				return false;
		} else if (!telCelular.equals(other.telCelular))
			return false;
		return true;
	}
	
}
