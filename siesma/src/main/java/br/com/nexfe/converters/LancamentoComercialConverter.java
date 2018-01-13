package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.LancamentoComercial;

@FacesConverter("lancamentoComercialConverter")
public class LancamentoComercialConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (LancamentoComercial) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		LancamentoComercial lancamentoComercial = (LancamentoComercial) objeto;
		if(lancamentoComercial != null){
			component.getAttributes().put(""+lancamentoComercial.getIdLancamentoComercial(), lancamentoComercial);
			return String.valueOf(lancamentoComercial.getIdLancamentoComercial());
		}
		return "";
	}

}
