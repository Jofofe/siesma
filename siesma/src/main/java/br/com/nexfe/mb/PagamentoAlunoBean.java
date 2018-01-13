package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.AlunoDAO;
import br.com.nexfe.dao.LancamentoComercialDAO;
import br.com.nexfe.dao.PagamentoAlunoDAO;
import br.com.nexfe.entidades.Aluno;
import br.com.nexfe.entidades.LancamentoComercial;
import br.com.nexfe.entidades.PagamentoAluno;

@ManagedBean
@ViewScoped
public class PagamentoAlunoBean {
	
	private PagamentoAlunoDAO pagamentoAlunoDAO;
	
	private AlunoDAO alunoDAO;
	
	private LancamentoComercialDAO lancamentoComercialDAO;
	
	private PagamentoAluno pagamentoAluno;
	
	private PagamentoAluno pagamentoAlunoExclusao;
	
	private List<PagamentoAluno> pagamentosAlunos;
	
	private List<PagamentoAluno> pagamentoAlunosFiltrados;
	
	private List<Aluno> alunos;
	
	private List<LancamentoComercial> lancamentosComerciais;
	
	public void init() {
		pagamentoAlunoDAO = new PagamentoAlunoDAO();
		alunoDAO = new AlunoDAO();
		lancamentoComercialDAO = new LancamentoComercialDAO();
		setPagamentosAlunos(pagamentoAlunoDAO.listar(PagamentoAluno.class));
		setAlunos(alunoDAO.listar(Aluno.class));
		setLancamentosComerciais(lancamentoComercialDAO.listarDataAtual());
		setPagamentoAluno(null);
	}

	public void back() {
		setPagamentoAluno(null);
	}

	public void add() {
		setPagamentoAluno(new PagamentoAluno());
	}
	
	public void edit(PagamentoAluno p){
		setPagamentoAluno(p);
	}
	
	public void saveAndUpdate() {
		if (getPagamentoAluno().getIdPagamentoAluno() != null) {
			if (getPagamentoAluno().getIdPagamentoAluno() > 0) {
				pagamentoAlunoDAO.alterar(getPagamentoAluno());			
			}
		} else {
			pagamentoAlunoDAO.salvar(getPagamentoAluno());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	//public boolean canDelete(DescontoAplicado d) {
	//	return d.get() == null || d.get.isEmpty();
	//}
	
	public void selectDelete(PagamentoAluno p){
		setPagamentoAlunoExclusao(p);
	}
	   
	public void delete(){
		pagamentoAlunoDAO.excluir(getPagamentoAlunoExclusao());
		setPagamentoAlunoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}

	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public PagamentoAluno getPagamentoAluno() {
		return pagamentoAluno;
	}

	public void setPagamentoAluno(PagamentoAluno pagamentoAluno) {
		this.pagamentoAluno = pagamentoAluno;
	}

	public PagamentoAluno getPagamentoAlunoExclusao() {
		return pagamentoAlunoExclusao;
	}

	public void setPagamentoAlunoExclusao(PagamentoAluno pagamentoAlunoExclusao) {
		this.pagamentoAlunoExclusao = pagamentoAlunoExclusao;
	}

	public List<PagamentoAluno> getPagamentosAlunos() {
		return pagamentosAlunos;
	}

	public void setPagamentosAlunos(List<PagamentoAluno> pagamentosAlunos) {
		this.pagamentosAlunos = pagamentosAlunos;
	}

	public List<PagamentoAluno> getPagamentoAlunosFiltrados() {
		return pagamentoAlunosFiltrados;
	}

	public void setPagamentoAlunosFiltrados(List<PagamentoAluno> pagamentoAlunosFiltrados) {
		this.pagamentoAlunosFiltrados = pagamentoAlunosFiltrados;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<LancamentoComercial> getLancamentosComerciais() {
		return lancamentosComerciais;
	}

	public void setLancamentosComerciais(List<LancamentoComercial> lancamentosComerciais) {
		this.lancamentosComerciais = lancamentosComerciais;
	}
	
}
