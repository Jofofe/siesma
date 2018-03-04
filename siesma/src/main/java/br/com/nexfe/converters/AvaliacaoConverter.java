package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Avaliacao;

@FacesConverter("avaliacaoConverter")
public class AvaliacaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Avaliacao) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Avaliacao avaliacao = (Avaliacao) objeto;
		if(avaliacao != null){
			component.getAttributes().put(""+avaliacao.getIdAvaliacao(), avaliacao);
			return String.valueOf(avaliacao.getIdAvaliacao());
		}
		return "";
	}

}
