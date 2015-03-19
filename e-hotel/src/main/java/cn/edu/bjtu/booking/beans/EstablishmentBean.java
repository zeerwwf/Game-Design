package cn.edu.bjtu.booking.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import cn.edu.bjtu.booking.entities.Client;
import cn.edu.bjtu.booking.entities.Establishment;
import cn.edu.bjtu.booking.utils.HibernateUtils;

@ManagedBean(name = "establishmentbean")
@RequestScoped
public class EstablishmentBean {

	private List<Establishment> bestRated;

	public EstablishmentBean()
	{
		bestRated = new ArrayList<Establishment>();
	}
	
	public List<Establishment> getBestRated() {
		
		Establishment e1 = new Establishment();
		e1.setAddress("ADDR");
		e1.setDescription("DESC");
		e1.setTitle("TITLE");
		
		bestRated.add(e1);
		
		return bestRated;
	}

	public void setBestRated(List<Establishment> bestRated) {
		this.bestRated = bestRated;
	}
}
