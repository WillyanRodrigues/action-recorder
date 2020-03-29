package br.com.vivo.actionrecorder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vivo.actionrecorder.converter.PlanConverter;
import br.com.vivo.actionrecorder.dto.request.PlanDTO;
import br.com.vivo.actionrecorder.entity.Plan;
import br.com.vivo.actionrecorder.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired
	PlanRepository repository;

	@Autowired
	PlanConverter converter;

	public void create(PlanDTO planDTO) {
		repository.save(converter.toEntity(planDTO));
	}

	public Plan find(Long planId) {
		Optional<Plan> plan = repository.findById(planId);
		if(plan.isPresent()) {
			return plan.get();
		}else {
			throw new RuntimeException("Plan not found");
		}
	}
}
