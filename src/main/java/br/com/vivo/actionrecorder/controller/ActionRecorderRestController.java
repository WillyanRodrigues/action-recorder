package br.com.vivo.actionrecorder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.actionrecorder.dto.request.ActionDTO;
import br.com.vivo.actionrecorder.dto.request.LineDTO;
import br.com.vivo.actionrecorder.dto.request.UserDTO;
import br.com.vivo.actionrecorder.dto.response.ActionDTOResponse;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
import br.com.vivo.actionrecorder.dto.response.LineDTOResponse;
import br.com.vivo.actionrecorder.entity.User;
import br.com.vivo.actionrecorder.service.ActionRecordingService;
import br.com.vivo.actionrecorder.service.LineService;
import br.com.vivo.actionrecorder.service.UserService;

@RestController
@RequestMapping("/record")
public class ActionRecorderRestController {
	
	@Autowired
	ActionRecordingService actionRecordingservice;
	
	@Autowired
	LineService lineService;
	
	@Autowired
	UserService userService;


	@PostMapping("/line/{lineId}/action")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public void createAction(@RequestParam(name = "lineId", required = true)Long lineId,
							@Valid @RequestBody ActionDTO action) {
		actionRecordingservice.create(action ,lineId);
	}
	
	@GetMapping("/line/{lineId}/action/{actionId}")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public ActionDTO getAction(@PathVariable(name = "lineId", required = true)Long lineId,
							@PathVariable(name = "actionId", required= true) Long actionId) {
		return actionRecordingservice.find(actionId,lineId);
	}
	
	@GetMapping("/line/{lineId}/action")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public List<ActionDTOResponse> getActions(@PathVariable(name = "lineId", required = true)Long lineId) {
		return actionRecordingservice.findByLineId(lineId);
	}
	
	@PostMapping("/user/{userId}/line")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public CreateDTOResponse createLine(@PathVariable(name = "userId", required = true)Long userId,
							@Valid @RequestBody LineDTO line) {
		return lineService.create(line , userId);
	}
	
	@GetMapping("/user/{userId}/line/{lineId}")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public LineDTOResponse getLine(@PathVariable(name = "userId", required = true)Long userId) {
		return lineService.find(userId);
	}
	
	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public CreateDTOResponse createUser(@RequestBody UserDTO user){
		return userService.create(user);
	}
	
	@GetMapping("/user/{userId}")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	public User getUser(@PathVariable(name = "userId") Long userId){
		return userService.find(userId);
	}
	
}
