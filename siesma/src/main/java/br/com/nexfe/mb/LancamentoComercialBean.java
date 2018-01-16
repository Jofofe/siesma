package br.com.nexfe.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.constantes.ConstantesStatus;
import br.com.nexfe.dao.AlunoDAO;
import br.com.nexfe.dao.EmpregadoDAO;
import br.com.nexfe.dao.FormaPagamentoDAO;
import br.com.nexfe.dao.LancamentoComercialDAO;
import br.com.nexfe.dao.TipoLancamentoDAO;
import br.com.nexfe.entidades.Aluno;
import br.com.nexfe.entidades.Empregado;
import br.com.nexfe.entidades.FormaPagamento;
import br.com.nexfe.entidades.LancamentoComercial;
import br.com.nexfe.entidades.TipoLancamento;

@ManagedBean
@ViewScoped
public class LancamentoComercialBean {
	
	private LancamentoComercialDAO lancamentoComercialDAO;
	
	private FormaPagamentoDAO formaPagamentoDAO;
	
	private TipoLancamentoDAO tipoLancamentoDAO;
	
	private AlunoDAO alunoDAO;
	
	private EmpregadoDAO empregadoDAO;
	
	private LancamentoComercial lancamentoComercial;
	
	private LancamentoComercial lancamentoComercialExclusao;
	
	private List<FormaPagamento> formasPagamentos;
	
	private List<TipoLancamento> tiposLancamentos;
	
	private List<Aluno> alunos;
	
	private List<Empregado> empregados;
	
	private List<LancamentoComercial> lancamentosComerciais;
	
	private List<LancamentoComercial> lancamentosComerciaisFiltrados;
	
	private Integer tipo;
	
	public void init() {
		lancamentoComercialDAO = new LancamentoComercialDAO();
		formaPagamentoDAO = new FormaPagamentoDAO();
		tipoLancamentoDAO = new TipoLancamentoDAO();
		alunoDAO = new AlunoDAO();
		empregadoDAO = new EmpregadoDAO();
		setFormasPagamentos(formaPagamentoDAO.listarDataAtual());
		setLancamentosComerciais(lancamentoComercialDAO.listarDataAtual());
		setTiposLancamentos(tipoLancamentoDAO.listar(TipoLancamento.class));
		setAlunos(alunoDAO.listar(Aluno.class));
		setEmpregados(empregadoDAO.listarProfessores());
		setLancamentoComercial(null);
		setTipo(null);
	}

	public void back() {
		setLancamentoComercial(null);
	}

	public void add() {
		setLancamentoComercial(new LancamentoComercial());
	}
	
	public void edit(LancamentoComercial l){
		setLancamentoComercial(l);
	}
	
	public void saveAndUpdate() {
		alteraStatus();
		if (getLancamentoComercial().getIdLancamentoComercial() != null) {
			if (getLancamentoComercial().getIdLancamentoComercial() > 0) {
				lancamentoComercialDAO.alterar(getLancamentoComercial());	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			lancamentoComercialDAO.salvar(getLancamentoComercial());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	private void alteraStatus() {
		if(getLancamentoComercial().getDtPrevista() == null && getLancamentoComercial().getDtRecebimento() == null) {
			getLancamentoComercial().setStatus(ConstantesStatus.SEM_PREVISAO.getNome());
		} else if(getLancamentoComercial().getDtPrevista() != null && getLancamentoComercial().getDtRecebimento() == null) {
			getLancamentoComercial().setStatus(ConstantesStatus.AGUARDANDO_PAGAMENTO.getNome());
		} else if(getLancamentoComercial().getDtRecebimento() != null) {
			if(getLancamentoComercial().getDtPrevista() == null || 
					getLancamentoComercial().getDtRecebimento().compareTo(getLancamentoComercial().getDtPrevista()) <= 0) {
				getLancamentoComercial().setStatus(ConstantesStatus.PAGO_EM_DIA.getNome());
			} else {
				getLancamentoComercial().setStatus(ConstantesStatus.PAGO_COM_ATRASO.getNome());
			}
		}
	}
	
	public void selectDelete(LancamentoComercial l){
		setLancamentoComercialExclusao(l);
	}
	
	//public boolean canDelete(LancamentoComercial l) {
	//	return l.get() == null || l.get().isEmpty();
	//}
	   
	public void delete(){
		lancamentoComercialDAO.excluir(getLancamentoComercialExclusao());
		setLancamentoComercialExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}
	
	public List<FormaPagamento> autoCompleteFormaPagamento(String query) {
		List<FormaPagamento> sugestoes = new ArrayList<FormaPagamento>();
		for (FormaPagamento f : getFormasPagamentos()) {
			if (f.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(f);
			}
		}
		return sugestoes;
	}
	
	public List<TipoLancamento> autoCompleteTipoLancamento(String query) {
		List<TipoLancamento> sugestoes = new ArrayList<TipoLancamento>();
		for (TipoLancamento t : getTiposLancamentos()) {
			if (t.getDescricao().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(t);
			}
		}
		return sugestoes;
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
	
	public List<Empregado> autoCompleteEmpregado(String query) {
		List<Empregado> sugestoes = new ArrayList<Empregado>();
		for (Empregado e : getEmpregados()) {
			if (e.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(e);
			}
		}
		return sugestoes;
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public LancamentoComercial getLancamentoComercial() {
		return lancamentoComercial;
	}

	public void setLancamentoComercial(LancamentoComercial lancamentoComercial) {
		this.lancamentoComercial = lancamentoComercial;
	}

	public LancamentoComercial getLancamentoComercialExclusao() {
		return lancamentoComercialExclusao;
	}

	public void setLancamentoComercialExclusao(LancamentoComercial lancamentoComercialExclusao) {
		this.lancamentoComercialExclusao = lancamentoComercialExclusao;
	}

	public List<FormaPagamento> getFormasPagamentos() {
		return formasPagamentos;
	}

	public void setFormasPagamentos(List<FormaPagamento> formasPagamentos) {
		this.formasPagamentos = formasPagamentos;
	}

	public List<LancamentoComercial> getLancamentosComerciais() {
		return lancamentosComerciais;
	}

	public void setLancamentosComerciais(List<LancamentoComercial> lancamentosComerciais) {
		this.lancamentosComerciais = lancamentosComerciais;
	}

	public List<LancamentoComercial> getLancamentosComerciaisFiltrados() {
		return lancamentosComerciaisFiltrados;
	}

	public void setLancamentosComerciaisFiltrados(List<LancamentoComercial> lancamentosComerciaisFiltrados) {
		this.lancamentosComerciaisFiltrados = lancamentosComerciaisFiltrados;
	}

	public List<TipoLancamento> getTiposLancamentos() {
		return tiposLancamentos;
	}

	public void setTiposLancamentos(List<TipoLancamento> tiposLancamentos) {
		this.tiposLancamentos = tiposLancamentos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
}
