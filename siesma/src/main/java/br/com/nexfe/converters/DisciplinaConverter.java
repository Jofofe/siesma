package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Disciplina;

@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Disciplina) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Disciplina disciplina = (Disciplina) objeto;
		if(disciplina != null){
			component.getAttributes().put(""+disciplina.getIdDisciplina(), disciplina);
			return String.valueOf(disciplina.getIdDisciplina());
		}
		return "";
	}

}
