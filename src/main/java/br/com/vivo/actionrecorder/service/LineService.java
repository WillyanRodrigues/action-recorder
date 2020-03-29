package br.com.vivo.actionrecorder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vivo.actionrecorder.converter.LineConverter;
import br.com.vivo.actionrecorder.dto.request.LineDTO;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.dto.response.LineDTOResponse;
import br.com.vivo.actionrecorder.entity.Line;
import br.com.vivo.actionrecorder.repository.LineRepository;

@Service
public class LineService {

	@Autowired
	LineRepository repository;
	
	@Autowired
	LineConverter converter;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PlanService planService;
	
	public CreateDTOResponse create(LineDTO lineDto , Long userId) {
		Line line = converter.toEntity(lineDto);
		line.setPlan(planService.find(lineDto.getPlanId()));
		line.setUser(userService.find(userId));
		return new CreateDTOResponse(repository.save(line).getId());
	}
	
	public LineDTOResponse find(Long lineId) {
		Optional<Line> line =  repository.findById(lineId);
		if(!line.isPresent()) {
			throw new RuntimeException("Line not found");
		}
		return converter.toResponseDTO(line.get());
	}
	
	public Line findLine(Long lineId) {
		Optional<Line> line =  repository.findById(lineId);
		if(!line.isPresent()) {
			throw new RuntimeException("Line not found");
		}
		return line.get();
	}
}
