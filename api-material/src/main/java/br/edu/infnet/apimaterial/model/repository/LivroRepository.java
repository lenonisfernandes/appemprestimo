package br.edu.infnet.apimaterial.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apimaterial.model.domain.Livro;


@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer>{

	
	public List<Livro> findAll(Sort sort);
	
	@Query("from Livro l where l.usuario.id = :userid")
	List<Livro> obterLista(Integer userid, Sort by);


}
