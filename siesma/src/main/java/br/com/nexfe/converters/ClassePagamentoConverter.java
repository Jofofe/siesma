package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.ClassePagamento;

@FacesConverter("classePagamentoConverter")
public class ClassePagamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (ClassePagamento) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		ClassePagamento classePagamento = (ClassePagamento) objeto;
		if(classePagamento != null){
			component.getAttributes().put(""+classePagamento.getIdClassePagamento(), classePagamento);
			return String.valueOf(classePagamento.getIdClassePagamento());
		}
		return "";
	}

}
