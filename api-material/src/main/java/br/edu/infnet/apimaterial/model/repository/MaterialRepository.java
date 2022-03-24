package br.edu.infnet.apimaterial.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apimaterial.model.domain.Material;


@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer>{

	
	public List<Material> findAll(Sort sort);
	
	@Query("from Material m where m.usuario.id = :userid")
	List<Material> obterLista(Integer userid, Sort by);


}
