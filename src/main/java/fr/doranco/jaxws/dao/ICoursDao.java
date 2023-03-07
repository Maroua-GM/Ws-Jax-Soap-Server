package fr.doranco.jaxws.dao;

import java.util.List;

import fr.doranco.entity.Cours;

public interface ICoursDao {

	List<Cours> getCours() throws Exception;

	Cours getCoursById(Integer id) throws Exception;

	Cours addCours(Cours cours) throws Exception;

}
