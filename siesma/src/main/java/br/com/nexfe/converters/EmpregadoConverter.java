package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Empregado;

@FacesConverter("empregadoConverter")
public class EmpregadoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Empregado) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Empregado empregado = (Empregado) objeto;
		if(empregado != null){
			component.getAttributes().put(""+empregado.getIdUsuario(), empregado);
			return String.valueOf(empregado.getIdUsuario());
		}
		return "";
	}

}
