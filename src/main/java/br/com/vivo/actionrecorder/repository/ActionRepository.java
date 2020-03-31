package br.com.vivo.actionrecorder.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vivo.actionrecorder.entity.Action;
import br.com.vivo.actionrecorder.entity.Line;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long>{
	
	Optional<List<Action>> findByLine(Line line);
	
	Optional<Action> findByActionIdAndLine(Long id , Line line);
	
	@Query("select a from Action a where a.line = :line and a.date between :dateStart and :dateEnd")
	Optional<List<Action>> filterActionsByLineAndDate(@Param("line") Line line,
			@Param("dateStart") Date dateStart,
			@Param("dateEnd")  Date dateEnd);
}
