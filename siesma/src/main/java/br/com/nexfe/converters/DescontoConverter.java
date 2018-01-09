package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Desconto;

@FacesConverter("descontoConverter")
public class DescontoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Desconto) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Desconto desconto = (Desconto) objeto;
		if(desconto != null){
			component.getAttributes().put(""+desconto.getIdDesconto(), desconto);
			return String.valueOf(desconto.getIdDesconto());
		}
		return "";
	}

}
