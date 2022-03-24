package br.edu.infnet.apimaterial.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apimaterial.model.domain.Academico;


@Repository
public interface AcademicoRepository extends CrudRepository<Academico, Integer>{

	
	public List<Academico> findAll(Sort sort);
	
	@Query("from Academico a where a.usuario.id = :userid")
	List<Academico> obterLista(Integer userid, Sort by);


}
