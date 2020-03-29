package br.com.vivo.actionrecorder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vivo.actionrecorder.converter.ActionConverter;
import br.com.vivo.actionrecorder.dto.request.ActionDTO;
import br.com.vivo.actionrecorder.dto.response.ActionDTOResponse;
import br.com.vivo.actionrecorder.entity.Action;
import br.com.vivo.actionrecorder.repository.ActionRepository;

@Service
public class ActionRecordingService {

	@Autowired
	ActionRepository actionRepository;
	
	@Autowired
	LineService lineService;
	
	@Autowired
	ActionConverter converter;
	
	public void create(ActionDTO actionDTO , Long lineId) {
		Action action = converter.toEntity(actionDTO);
		action.setLine(lineService.findLine(lineId));
		actionRepository.save(action);
	}
	
	public Optional<Action> find(Long actionId) {
		return actionRepository.findById(actionId);
	}
	
	public ActionDTO find(Long actionId , Long lineId) {
		Optional<Action> action = actionRepository.findByIdAndLineId(actionId , lineId);
		if(!action.isPresent()) {
			throw new RuntimeException("Action not found");
		}
		return converter.toDTO(action.get());
	}
	
	public List<ActionDTOResponse> findByLineId(Long lineId){
		Optional<List<Action>> actions = actionRepository.findByLineId(lineId);
		if(!actions.isPresent() || actions.get().isEmpty()) {
			throw new RuntimeException("No actions not found");
		}
		List<ActionDTOResponse> actionsDTOResponse = new ArrayList<>();
		actions.get().forEach(action -> {
			actionsDTOResponse.add(converter.toResponseDTO(action));
		});
		return actionsDTOResponse;
	}

}
