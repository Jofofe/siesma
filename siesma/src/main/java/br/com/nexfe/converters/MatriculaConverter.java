package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Matricula;

@FacesConverter("matriculaConverter")
public class MatriculaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Matricula) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Matricula matricula = (Matricula) objeto;
		if(matricula != null){
			component.getAttributes().put(""+matricula.getIdMatricula(), matricula);
			return String.valueOf(matricula.getIdMatricula());
		}
		return "";
	}

}
