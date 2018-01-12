package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.FormaPagamento;

@FacesConverter("formaPagamentoConverter")
public class FormaPagamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (FormaPagamento) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		FormaPagamento formaPagamento = (FormaPagamento) objeto;
		if(formaPagamento != null){
			component.getAttributes().put(""+formaPagamento.getIdFormaPagamento(), formaPagamento);
			return String.valueOf(formaPagamento.getIdFormaPagamento());
		}
		return "";
	}

}
