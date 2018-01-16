package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.UnidadeMedida;

@FacesConverter("unidadeMedidaConverter")
public class UnidadeMedidaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (UnidadeMedida) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		UnidadeMedida unidadeMedida = (UnidadeMedida) objeto;
		if(unidadeMedida != null){
			component.getAttributes().put(""+unidadeMedida.getIdUnidadeMedida(), unidadeMedida);
			return String.valueOf(unidadeMedida.getIdUnidadeMedida());
		}
		return "";
	}

}
