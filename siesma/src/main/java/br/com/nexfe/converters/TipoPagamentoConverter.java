package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.TipoPagamento;

@FacesConverter("tipoPagamentoConverter")
public class TipoPagamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (TipoPagamento) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		TipoPagamento tipoPagamento = (TipoPagamento) objeto;
		if(tipoPagamento != null){
			component.getAttributes().put(""+tipoPagamento.getIdTipoPagamento(), tipoPagamento);
			return String.valueOf(tipoPagamento.getIdTipoPagamento());
		}
		return "";
	}

}
