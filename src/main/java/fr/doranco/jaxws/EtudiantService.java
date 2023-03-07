package fr.doranco.jaxws;

import java.util.List;

import javax.jws.WebService;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.dao.EtudiantDao;
import fr.doranco.jaxws.dao.IEtudiantDao;

@WebService(endpointInterface = "fr.doranco.jaxws.IEtudiantService", serviceName = "EtudiantService", portName = "EtudiantPort")
public class EtudiantService implements IEtudiantService {
	IEtudiantDao etudiantDao = new EtudiantDao();

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		return etudiantDao.addEtudiant(etudiant);

	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {
		return etudiantDao.getEtudiants();
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws Exception {
		return etudiantDao.getEtudiantById(id);
	}

}
