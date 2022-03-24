package br.edu.infnet.apiemprestimo.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiemprestimo.model.domain.Emprestimo;


@Repository
public interface EmprestimoRepository extends CrudRepository<Emprestimo, Integer>{

	@Query("from Emprestimo e where e.usuario.id= :userid")
	List<Emprestimo> findAll(Integer userid, Sort by);
	
	List<Emprestimo> findAll(Sort by);

}
