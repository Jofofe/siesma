package br.com.nexfe.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.nexfe.dao.DisciplinaDAO;
import br.com.nexfe.dao.PresencaDAO;
import br.com.nexfe.entidades.Disciplina;
import br.com.nexfe.entidades.Matricula;
import br.com.nexfe.entidades.Presenca;
import br.com.nexfe.entidades.PresencaMatricula;

@ManagedBean(name = "presencaBean")
@ViewScoped
public class PresencaBean {
	
	private PresencaDAO presencaDAO;
	
	private DisciplinaDAO disciplinaDAO;
	
	private Presenca presenca;
	
	private Presenca presencaExclusao;
	
	private List<Presenca> presencas;
	
	private List<Disciplina> disciplinas;
	
	private List<Matricula> matriculas;
	
	private List<Presenca> presencasFiltradas;
	
	public void init() {
		presencaDAO = new PresencaDAO();
		disciplinaDAO = new DisciplinaDAO();
		setPresencas(presencaDAO.listar(Presenca.class));
		setDisciplinas(disciplinaDAO.listarDataAtual());
		setPresenca(null);
	}

	public void back() {
		setPresenca(null);
	}

	public void add() {
		setPresenca(new Presenca());
	}
	
	public void edit(Presenca p){
		setPresenca(p);
	}
	
	public void saveAndUpdate() {
		if (getPresenca().getIdPresenca() != null) {
			if (getPresenca().getIdPresenca() > 0) {
				presencaDAO.alterar(getPresenca());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			presencaDAO.salvar(getPresenca());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	public void selectDelete(Presenca p){
		setPresencaExclusao(p);
	}
	   
	public void delete(){
		presencaDAO.excluir(getPresencaExclusao());
		setPresencaExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}
	
	public List<Disciplina> autoCompleteDisciplina(String query) {
		List<Disciplina> sugestoes = new ArrayList<Disciplina>();
		for (Disciplina d : getDisciplinas()) {
			if (d.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(d);
			}
		}
		return sugestoes;
	}
	
	////////////////////////VALIDATORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public Presenca getPresenca() {
		return presenca;
	}

	public void setPresenca(Presenca presenca) {
		this.presenca = presenca;
	}

	public Presenca getPresencaExclusao() {
		return presencaExclusao;
	}

	public void setPresencaExclusao(Presenca presencaExclusao) {
		this.presencaExclusao = presencaExclusao;
	}

	public List<Presenca> getPresencas() {
		return presencas;
	}

	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
	}

	public void carregaAlunosDisciplinas(ValueChangeEvent e) {
		Disciplina disciplina = (Disciplina) e.getNewValue();
		PresencaMatricula presencaMatricula = null;
		this.getPresenca().setPresencasMatriculas(new ArrayList<PresencaMatricula>());
		for(Matricula matricula : disciplina.getModulo().getMatriculas()) {
			presencaMatricula = new PresencaMatricula();
			presencaMatricula.setMatricula(matricula);
			presencaMatricula.setPresenca(this.getPresenca());
			this.getPresenca().getPresencasMatriculas().add(presencaMatricula);
		}
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Presenca> getPresencasFiltradas() {
		return presencasFiltradas;
	}

	public void setPresencasFiltradas(List<Presenca> presencasFiltradas) {
		this.presencasFiltradas = presencasFiltradas;
	}
	
}
