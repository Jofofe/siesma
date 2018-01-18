package br.com.nexfe.mb;
 
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.UsuarioDAO;
import br.com.nexfe.entidades.Usuario;
import br.com.nexfe.util.UtilCrypt;
 
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private UsuarioDAO usuarioDAO;
	
	private Usuario usuario;
	
	private String email;
	
	private String senha;
 
	public Usuario getUsuarioSession(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (Usuario)facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}
 
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}
	public String efetuarLogin(){
 
		if(getEmail() == null || getEmail().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Favor informar o email!"));
			resetaDados();
			return null;
		} else if(getSenha() == null || getSenha().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Favor informar a senha!"));
			resetaDados();
			return null;
		} else{	
			usuarioDAO = new UsuarioDAO();
			setUsuario(usuarioDAO.login(getEmail(), UtilCrypt.criptografia(getSenha())));
			if(getUsuario() != null){
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", getUsuario());
				return "paginas/home?faces-redirect=true";
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Email ou senha incorretos!"));
				resetaDados();
				return null;
			}
		}
	}
	
	public void resetaDados() {
		setEmail(null);
		setSenha(null);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}