package br.com.vivo.actionrecorder.service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.vivo.actionrecorder.converter.ActionConverter;
import br.com.vivo.actionrecorder.dto.request.ActionDTO;
import br.com.vivo.actionrecorder.dto.response.ActionDTOResponse;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.entity.Action;
import br.com.vivo.actionrecorder.entity.Line;
import br.com.vivo.actionrecorder.exception.ResourceException;
import br.com.vivo.actionrecorder.repository.ActionRepository;
import br.com.vivo.actionrecorder.util.DateUtil;

@Service
public class ActionRecordingService {

	@Autowired
	ActionRepository actionRepository;

	@Autowired
	LineService lineService;

	@Autowired
	ActionConverter converter;

	public CreateDTOResponse create(Long userId, Long lineId, ActionDTO actionDTO) {
		Action action = converter.toEntity(actionDTO);
		action.setLine(lineService.findLineByIdAndUser(lineId, userId));
		return new CreateDTOResponse(actionRepository.save(action).getActionId());
	}

	public void delete(Long userId, Long lineId, Long actionId) {
		Optional<Action> action = actionRepository.findByActionIdAndLine(actionId,
				lineService.findLineByIdAndUser(lineId, userId));
		if (!action.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "Action not found");
		}
		actionRepository.delete(action.get());
	}

	public ActionDTOResponse find(Long userId, Long lineId, Long actionId) {
		Optional<Action> action = actionRepository.findByActionIdAndLine(actionId,
				lineService.findLineByIdAndUser(lineId, userId));
		if (!action.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "Action not found");
		}
		return converter.toResponseDTO(action.get());
	}

	public List<ActionDTOResponse> find(Long userId, Long lineId) {
		Optional<List<Action>> actions = actionRepository.findByLine(lineService.findLineByIdAndUser(lineId, userId));
		if (!actions.isPresent() || actions.get().isEmpty()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "Actions not found");
		}
		List<ActionDTOResponse> actionsDTOResponse = new ArrayList<>();
		actions.get().forEach(action -> {
			actionsDTOResponse.add(converter.toResponseDTO(action));
		});

		return actionsDTOResponse;
	}

	public List<ActionDTOResponse> findByDateFilter(Long documentNumber, Long number, LocalDateTime startDate,
			LocalDateTime endDate) {
		Line line = lineService.findByLineNumberAndDocumentNumber(documentNumber, number);
		Optional<List<Action>> actions = actionRepository.filterActionsByLineAndDate(line,
							DateUtil.fromLocalDateTimeToDate(startDate),
							DateUtil.fromLocalDateTimeToDate(endDate));
		if (!actions.isPresent() || actions.get().isEmpty()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "Actions not found");
		}
		List<ActionDTOResponse> actionsDTOResponse = new ArrayList<>();
		actions.get().forEach(action -> {
			actionsDTOResponse.add(converter.toResponseDTO(action));
		});

		return actionsDTOResponse;
	}

	public List<ActionDTOResponse> findActionsForCurrentMonth(Long documentNumber, Long number) {
		Date firstDayOfCurrentMonth = DateUtil
				.fromLocalDateTimeToDate(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()));

		Date lastDayOfCurrentMonth = DateUtil
				.fromLocalDateTimeToDate(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()));

		Line line = lineService.findByLineNumberAndDocumentNumber(documentNumber, number);

		Optional<List<Action>> actions = actionRepository.filterActionsByLineAndDate(line, firstDayOfCurrentMonth,
				lastDayOfCurrentMonth);
		
		if (!actions.isPresent() || actions.get().isEmpty()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "Actions not found");
		}
		List<ActionDTOResponse> actionsDTOResponse = new ArrayList<>();
		actions.get().forEach(action -> {
			actionsDTOResponse.add(converter.toResponseDTO(action));
		});

		return actionsDTOResponse;
		
	}

}
