package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.constantes.ConstantesStatus;
import br.com.nexfe.dao.TipoLancamentoDAO;
import br.com.nexfe.dao.TipoPagamentoDAO;
import br.com.nexfe.dao.UnidadeMedidaDAO;
import br.com.nexfe.entidades.TipoLancamento;
import br.com.nexfe.entidades.TipoPagamento;
import br.com.nexfe.entidades.UnidadeMedida;

@ManagedBean
@ViewScoped
public class TipoLancamentoBean {
	
	private TipoLancamentoDAO tipoLancamentoDAO;
	
	private TipoPagamentoDAO tipoPagamentoDAO;
	
	private UnidadeMedidaDAO unidadeMedidaDAO;
	
	private TipoLancamento tipoLancamento;
	
	private TipoLancamento tipoLancamentoExclusao;
	
	private List<TipoPagamento> tiposPagamentos;
	
	private List<UnidadeMedida> unidadesMedidas;
	
	private List<TipoLancamento> tiposLancamentos;
	
	private List<TipoLancamento> tiposLancamentosFiltrados;
	
	public void init() {
		tipoLancamentoDAO = new TipoLancamentoDAO();
		tipoPagamentoDAO = new TipoPagamentoDAO();
		unidadeMedidaDAO = new UnidadeMedidaDAO();
		setTiposLancamentos(tipoLancamentoDAO.listarTodosSemDistincao());
		setTiposPagamentos(tipoPagamentoDAO.listar(TipoPagamento.class));
		setUnidadesMedidas(unidadeMedidaDAO.listar(UnidadeMedida.class));
		setTipoLancamento(null);
	}

	public void back() {
		setTipoLancamento(null);
	}

	public void add() {
		setTipoLancamento(new TipoLancamento());
	}
	
	public void edit(TipoLancamento t){
		setTipoLancamento(t);
	}
	
	public void saveAndUpdate() {
		if (getTipoLancamento().getIdTipoLancamento()!= null) {
			if (getTipoLancamento().getIdTipoLancamento() > 0) {
				tipoLancamentoDAO.alterar(getTipoLancamento());	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			getTipoLancamento().setStatus(ConstantesStatus.ATIVO.getNome());
			tipoLancamentoDAO.salvar(getTipoLancamento());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	public void selectDelete(TipoLancamento t){
		setTipoLancamentoExclusao(t);
	}
	   
	public void delete(){
		getTipoLancamentoExclusao().setStatus(ConstantesStatus.INATIVO.getNome());
		tipoLancamentoDAO.alterar(getTipoLancamentoExclusao());
		setTipoLancamentoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Inativado com sucesso!"));
		init();
	}
	
	public void reativar(){
		getTipoLancamentoExclusao().setStatus(ConstantesStatus.ATIVO.getNome());
		tipoLancamentoDAO.alterar(getTipoLancamentoExclusao());
		setTipoLancamentoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Reativado com sucesso!"));
		init();
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public TipoLancamento getTipoLancamentoExclusao() {
		return tipoLancamentoExclusao;
	}

	public void setTipoLancamentoExclusao(TipoLancamento tipoLancamentoExclusao) {
		this.tipoLancamentoExclusao = tipoLancamentoExclusao;
	}

	public List<TipoPagamento> getTiposPagamentos() {
		return tiposPagamentos;
	}

	public void setTiposPagamentos(List<TipoPagamento> tiposPagamentos) {
		this.tiposPagamentos = tiposPagamentos;
	}

	public List<UnidadeMedida> getUnidadesMedidas() {
		return unidadesMedidas;
	}

	public void setUnidadesMedidas(List<UnidadeMedida> unidadesMedidas) {
		this.unidadesMedidas = unidadesMedidas;
	}

	public List<TipoLancamento> getTiposLancamentos() {
		return tiposLancamentos;
	}

	public void setTiposLancamentos(List<TipoLancamento> tiposLancamentos) {
		this.tiposLancamentos = tiposLancamentos;
	}

	public List<TipoLancamento> getTiposLancamentosFiltrados() {
		return tiposLancamentosFiltrados;
	}

	public void setTiposLancamentosFiltrados(List<TipoLancamento> tiposLancamentosFiltrados) {
		this.tiposLancamentosFiltrados = tiposLancamentosFiltrados;
	}

}
