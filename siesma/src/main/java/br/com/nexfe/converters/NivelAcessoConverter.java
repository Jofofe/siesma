package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.NivelAcesso;

@FacesConverter("nivelAcessoConverter")
public class NivelAcessoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (NivelAcesso) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		NivelAcesso nivelAcesso = (NivelAcesso) objeto;
		if(nivelAcesso != null){
			component.getAttributes().put(""+nivelAcesso.getIdNivelAcesso(), nivelAcesso);
			return String.valueOf(nivelAcesso.getIdNivelAcesso());
		}
		return "";
	}

}
