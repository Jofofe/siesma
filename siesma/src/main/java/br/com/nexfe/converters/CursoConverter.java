package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Curso;

@FacesConverter("cursoConverter")
public class CursoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Curso) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Curso curso = (Curso) objeto;
		if(curso != null){
			component.getAttributes().put(""+curso.getIdCurso(), curso);
			return String.valueOf(curso.getIdCurso());
		}
		return "";
	}

}
