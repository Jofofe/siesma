package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Uf;

@FacesConverter("ufConverter")
public class UfConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Uf) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Uf uf = (Uf) objeto;
		if(uf != null){
			component.getAttributes().put(""+uf.getIdUf(), uf);
			return String.valueOf(uf.getIdUf());
		}
		return "";
	}

}
