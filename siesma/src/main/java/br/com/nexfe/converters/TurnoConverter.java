package br.com.nexfe.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.nexfe.entidades.Turno;

@FacesConverter("turnoConverter")
public class TurnoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null){
			return (Turno) component.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		Turno turno = (Turno) objeto;
		if(turno != null){
			component.getAttributes().put(""+turno.getIdTurno(), turno);
			return String.valueOf(turno.getIdTurno());
		}
		return "";
	}

}
