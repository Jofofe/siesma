package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Modulo;

@FacesConverter("moduloConverter")
public class ModuloConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Modulo) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Modulo modulo = (Modulo) objeto;
		if(modulo != null){
			component.getAttributes().put(""+modulo.getIdModulo(), modulo);
			return String.valueOf(modulo.getIdModulo());
		}
		return "";
	}

}
