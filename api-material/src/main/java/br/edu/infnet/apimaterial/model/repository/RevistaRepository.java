package br.edu.infnet.apimaterial.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apimaterial.model.domain.Revista;


@Repository
public interface RevistaRepository extends CrudRepository<Revista, Integer>{

	
	public List<Revista> findAll(Sort sort);
	
	@Query("from Revista r where r.usuario.id = :userid")
	List<Revista> obterLista(Integer userid, Sort by);


}
