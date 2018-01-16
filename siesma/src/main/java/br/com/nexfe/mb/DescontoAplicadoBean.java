package br.com.nexfe.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.AlunoDAO;
import br.com.nexfe.dao.DescontoAplicadoDAO;
import br.com.nexfe.dao.DescontoDAO;
import br.com.nexfe.dao.ModuloDAO;
import br.com.nexfe.entidades.Aluno;
import br.com.nexfe.entidades.Desconto;
import br.com.nexfe.entidades.DescontoAplicado;
import br.com.nexfe.entidades.Modulo;

@ManagedBean
@ViewScoped
public class DescontoAplicadoBean {
	
	private DescontoAplicadoDAO descontoAplicadoDAO;
	
	private AlunoDAO alunoDAO;
	
	private ModuloDAO moduloDAO;
	
	private DescontoDAO descontoDAO;
	
	private DescontoAplicado descontoAplicado;
	
	private DescontoAplicado descontoAplicadoExclusao;
	
	private List<DescontoAplicado> descontosAplicados;
	
	private List<DescontoAplicado> descontosAplicadosFiltrados;
	
	private List<Aluno> alunos;
	
	private List<Modulo> modulos;
	
	private List<Desconto> descontos;
	
	public void init() {
		descontoAplicadoDAO = new DescontoAplicadoDAO();
		alunoDAO = new AlunoDAO();
		moduloDAO = new ModuloDAO();
		descontoDAO = new DescontoDAO();
		setDescontosAplicados(descontoAplicadoDAO.listarDataAtual());
		setAlunos(alunoDAO.listar(Aluno.class));
		setModulos(moduloDAO.listarDataAtual());
		setDescontos(descontoDAO.listarDataAtual());
		setDescontoAplicado(null);
	}

	public void back() {
		setDescontoAplicado(null);
	}

	public void add() {
		setDescontoAplicado(new DescontoAplicado());
	}
	
	public void edit(DescontoAplicado d){
		setDescontoAplicado(d);
	}
	
	public void saveAndUpdate() {
		if (getDescontoAplicado().getIdDescontoAplicado() != null) {
			if (getDescontoAplicado().getIdDescontoAplicado() > 0) {
				descontoAplicadoDAO.alterar(getDescontoAplicado());	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			descontoAplicadoDAO.salvar(getDescontoAplicado());	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	//public boolean canDelete(DescontoAplicado d) {
	//	return d.get() == null || d.get.isEmpty();
	//}
	
	public void selectDelete(DescontoAplicado d){
		setDescontoAplicadoExclusao(d);
	}
	   
	public void delete(){
		descontoAplicadoDAO.excluir(getDescontoAplicadoExclusao());
		setDescontoAplicadoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}
	
	public List<Aluno> autoCompleteAluno(String query) {
		List<Aluno> sugestoes = new ArrayList<Aluno>();
		for (Aluno a : getAlunos()) {
			if (a.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(a);
			}
		}
		return sugestoes;
	}
	
	public List<Modulo> autoCompleteModulo(String query) {
		List<Modulo> sugestoes = new ArrayList<Modulo>();
		for (Modulo m : getModulos()) {
			if (m.getNomeComCurso().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(m);
			}
		}
		return sugestoes;
	}
	
	public List<Desconto> autoCompleteDesconto(String query) {
		List<Desconto> sugestoes = new ArrayList<Desconto>();
		for (Desconto d : getDescontos()) {
			if (d.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(d);
			}
		}
		return sugestoes;
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public DescontoAplicado getDescontoAplicado() {
		return descontoAplicado;
	}

	public void setDescontoAplicado(DescontoAplicado descontoAplicado) {
		this.descontoAplicado = descontoAplicado;
	}

	public DescontoAplicado getDescontoAplicadoExclusao() {
		return descontoAplicadoExclusao;
	}

	public void setDescontoAplicadoExclusao(DescontoAplicado descontoAplicadoExclusao) {
		this.descontoAplicadoExclusao = descontoAplicadoExclusao;
	}

	public List<DescontoAplicado> getDescontosAplicados() {
		return descontosAplicados;
	}

	public void setDescontosAplicados(List<DescontoAplicado> descontosAplicados) {
		this.descontosAplicados = descontosAplicados;
	}

	public List<DescontoAplicado> getDescontosAplicadosFiltrados() {
		return descontosAplicadosFiltrados;
	}

	public void setDescontosAplicadosFiltrados(List<DescontoAplicado> descontosAplicadosFiltrados) {
		this.descontosAplicadosFiltrados = descontosAplicadosFiltrados;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<Desconto> getDescontos() {
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}
	
}
