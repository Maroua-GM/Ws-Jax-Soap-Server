package fr.doranco.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.doranco.entity.Cours;

/**
 *
 * @author Maroua
 *
 */
@WebService(name = "CoursService", targetNamespace = "http://jaxws.doranco.fr")
public interface ICoursService {

	@WebMethod
	List<Cours> getCours() throws Exception;

	@WebMethod
	Cours getCoursById(@WebParam(name = "id") Integer id) throws Exception;

	@WebMethod
	Cours addCours(@WebParam(name = "cours") Cours cours) throws Exception;

}
