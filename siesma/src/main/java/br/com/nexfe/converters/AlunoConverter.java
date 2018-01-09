package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Aluno;

@FacesConverter("alunoConverter")
public class AlunoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Aluno) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Aluno aluno = (Aluno) objeto;
		if(aluno != null){
			component.getAttributes().put(""+aluno.getIdUsuario(), aluno);
			return String.valueOf(aluno.getIdUsuario());
		}
		return "";
	}

}
