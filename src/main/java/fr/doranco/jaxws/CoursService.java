package fr.doranco.jaxws;

import java.util.List;

import javax.jws.WebService;

import fr.doranco.entity.Cours;
import fr.doranco.jaxws.dao.CoursDao;
import fr.doranco.jaxws.dao.ICoursDao;

@WebService(endpointInterface = "fr.doranco.jaxws.ICoursService", serviceName = "CoursService", portName = "CoursPort")
public class CoursService implements ICoursService {
	ICoursDao coursDao = new CoursDao();

	@Override
	public List<Cours> getCours() throws Exception {
		return coursDao.getCours();
	}

	@Override
	public Cours getCoursById(Integer id) throws Exception {
		return coursDao.getCoursById(id);
	}

	@Override
	public Cours addCours(Cours cours) throws Exception {
		return coursDao.addCours(cours);
	}

}
