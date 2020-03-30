package br.com.vivo.actionrecorder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.actionrecorder.entity.Action;
import br.com.vivo.actionrecorder.entity.Line;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long>{
	
	Optional<List<Action>> findByLine(Line line);
	
	Optional<Action> findByActionIdAndLine(Long id , Line line);
}
