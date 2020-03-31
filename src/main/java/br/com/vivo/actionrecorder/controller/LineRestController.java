package br.com.vivo.actionrecorder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.actionrecorder.dto.request.LineDTO;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.dto.response.LineDTOResponse;
import br.com.vivo.actionrecorder.service.LineService;

@RestController
@RequestMapping("/record")
public class LineRestController {

	@Autowired
	LineService lineService;
	
	@PostMapping("user/{userId}/line")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public CreateDTOResponse createLine(@PathVariable (name = "userId") Long userId, @Valid @RequestBody LineDTO line) {
		return lineService.create(line , userId);
	}
	
	@GetMapping("user/{userId}/line/{lineId}")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public LineDTOResponse getLine(@PathVariable(name = "userId", required = true)Long userId,
									@PathVariable(name = "lineId", required = true)Long lineId) {
		return lineService.find(userId , lineId);
	}
	
	@GetMapping("user/{documentNumber}/line")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public LineDTOResponse getLineByLineNumber(@PathVariable(name = "documentNumber", required = true)Long documentNumber,
									@RequestParam(name = "number", required = true)Long number) {
		return lineService.findByLineNumber(documentNumber , number);
	}
	
	@GetMapping("user/{userId}/lines")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public List<LineDTOResponse> getAllLinesFromUser(@PathVariable(name = "userId", required = true)Long userId) {
		return lineService.find(userId);
	}
	
	@DeleteMapping("user/{userId}/line/{lineId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
	public void deleteLine(@PathVariable(name = "userId", required = true) Long userId,
							@PathVariable(name = "lineId", required = true) Long lineId) {
		lineService.delete(userId, lineId);
	}
}
