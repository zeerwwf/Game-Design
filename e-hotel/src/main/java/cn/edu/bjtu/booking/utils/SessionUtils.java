package cn.edu.bjtu.booking.utils;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import cn.edu.bjtu.booking.entities.Client;

public class SessionUtils {

	public static Client getCurrentClient()
	{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return (Client)externalContext.getSessionMap().get("user");
	}

	public static void redirectPage(String string) {
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(string);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
