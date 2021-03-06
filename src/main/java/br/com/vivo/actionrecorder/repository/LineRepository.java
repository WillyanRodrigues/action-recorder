package br.com.vivo.actionrecorder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.actionrecorder.entity.Line;
import br.com.vivo.actionrecorder.entity.User;

@Repository
public interface LineRepository extends CrudRepository<Line , Long>{

	Optional<List<Line>> findByUser(User user);
	
	Optional<Line> findByNumber(Long number);
	
	Optional<Line> findByLineIdAndUser(Long lineId, User user);
	
	Optional<Line> findByNumberAndUser(Long number , User user);
}
