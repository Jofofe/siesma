package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Funcao;

@FacesConverter("funcaoConverter")
public class FuncaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Funcao) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Funcao funcao = (Funcao) objeto;
		if(funcao != null){
			component.getAttributes().put(""+funcao.getIdFuncao(), funcao);
			return String.valueOf(funcao.getIdFuncao());
		}
		return "";
	}

}
