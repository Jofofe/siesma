package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Documento;

@FacesConverter("documentoConverter")
public class DocumentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Documento) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Documento documento = (Documento) objeto;
		if(documento != null){
			component.getAttributes().put(""+documento.getIdDocumento(), documento);
			return String.valueOf(documento.getIdDocumento());
		}
		return "";
	}

}
