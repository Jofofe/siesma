package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.TipoLancamento;

@FacesConverter("tipoLancamentoConverter")
public class TipoLancamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (TipoLancamento) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		TipoLancamento tipoLancamento = (TipoLancamento) objeto;
		if(tipoLancamento != null){
			component.getAttributes().put(""+tipoLancamento.getIdTipoLancamento(), tipoLancamento);
			return String.valueOf(tipoLancamento.getIdTipoLancamento());
		}
		return "";
	}

}
