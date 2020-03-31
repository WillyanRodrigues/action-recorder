package br.com.vivo.actionrecorder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.vivo.actionrecorder.converter.LineConverter;
import br.com.vivo.actionrecorder.dto.request.LineDTO;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.dto.response.LineDTOResponse;
import br.com.vivo.actionrecorder.entity.Line;
import br.com.vivo.actionrecorder.entity.User;
import br.com.vivo.actionrecorder.exception.ResourceException;
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
	
	public CreateDTOResponse create(LineDTO lineDto, Long userId) {
		Line line = converter.toEntity(lineDto);
		line.setPlan(planService.find(lineDto.getPlanId()));
		line.setUser(userService.findUser(userId));
		return new CreateDTOResponse(repository.save(line).getLineId());
	}
	
	public LineDTOResponse findByLineNumber(Long documentNumber, Long lineNumber) {
		Optional<Line> line =  repository.findByNumberAndUser(lineNumber, userService.findUserByDocumentNumber(documentNumber));
		if(!line.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND,"Line not found");
		}
		return converter.toResponseDTO(line.get());
	}
	
	public LineDTOResponse find(Long userId, Long lineId) {
		Optional<Line> line =  repository.findByLineIdAndUser(lineId, userService.findUser(userId));
		if(!line.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND,"Line not found");
		}
		return converter.toResponseDTO(line.get());
	}
	
	public void delete(Long userId, Long lineId) {
		Optional<Line> line =  repository.findByLineIdAndUser(lineId, userService.findUser(userId));
		if(!line.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND,"Line not found");
		}
		repository.delete(line.get());
	}
	
	public List<LineDTOResponse> find(Long userId){
		Optional<List<Line>> lines = repository.findByUser(userService.findUser(userId));
		if(!lines.isPresent() || lines.get().isEmpty()) {
			throw new ResourceException(HttpStatus.NOT_FOUND,"Lines not found");
		}
		List<LineDTOResponse> linesDTOResponse = new ArrayList<>();
		lines.get().forEach(line -> {
			linesDTOResponse.add(converter.toResponseDTO(line));
		});
		return linesDTOResponse;
	}
	
	public Line findLineByIdAndUser(Long lineId , Long userId) {
		User user = userService.findUser(userId);
		Optional<Line> line = repository.findByLineIdAndUser(lineId, user);
		if(!line.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND, "No line found for this user");
		}
		return line.get();
	}
	
	
	public Line findByLineNumberAndDocumentNumber(Long documentNumber, Long number) {
		Optional<Line> line =  repository.findByNumberAndUser(number, userService.findUserByDocumentNumber(documentNumber));
		if(!line.isPresent()) {
			throw new ResourceException(HttpStatus.NOT_FOUND,"No line found for this user");
		}
		return line.get();
	}
	
}
