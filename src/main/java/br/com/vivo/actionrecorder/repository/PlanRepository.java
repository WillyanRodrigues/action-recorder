package br.com.vivo.actionrecorder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vivo.actionrecorder.entity.Plan;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Long> {

}
