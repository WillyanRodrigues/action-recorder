package br.com.vivo.actionrecorder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.actionrecorder.entity.Line;

@Repository
public interface LineRepository extends CrudRepository<Line , Long>{

	Optional<List<Line>> findByUser(Long userId);
}
