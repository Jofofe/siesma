package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.TipoAvaliacao;

@FacesConverter("tipoAvaliacaoConverter")
public class TipoAvaliacaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (TipoAvaliacao) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		TipoAvaliacao tipoAvaliacao = (TipoAvaliacao) objeto;
		if(tipoAvaliacao != null){
			component.getAttributes().put(""+tipoAvaliacao.getIdTipoAvaliacao(), tipoAvaliacao);
			return String.valueOf(tipoAvaliacao.getIdTipoAvaliacao());
		}
		return "";
	}

}
