package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Genero;

@FacesConverter("generoConverter")
public class GeneroConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Genero) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Genero genero = (Genero) objeto;
		if(genero != null){
			component.getAttributes().put(""+genero.getIdGenero(), genero);
			return String.valueOf(genero.getIdGenero());
		}
		return "";
	}

}
