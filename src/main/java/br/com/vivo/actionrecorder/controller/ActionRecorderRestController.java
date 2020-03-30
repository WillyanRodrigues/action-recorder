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

import br.com.vivo.actionrecorder.dto.request.ActionDTO;
import br.com.vivo.actionrecorder.dto.response.ActionDTOResponse;
import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;
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

	//-----------------------------ACTION----------------------------------

	@PostMapping("user/{userId}/line/{lineId}/action")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public CreateDTOResponse createAction(@PathVariable(name = "userId") Long userId,
			@PathVariable(name = "lineId") Long lineId
			,@Valid @RequestBody ActionDTO action) {
		return actionRecordingservice.create(userId , lineId ,action);
	}
	
	@GetMapping("user/{userId}/line/{lineId}/action?actionId=actionId")
	@ResponseStatus(code = HttpStatus.OK,  value =  HttpStatus.OK)
	public ActionDTOResponse getAction(@PathVariable(name = "userId") Long userId,
			@PathVariable(name = "lineId") Long lineId,
			@RequestParam(name = "actionId") Long actionId) {
		return actionRecordingservice.find(userId, lineId , actionId);
	}
	
	@GetMapping("user/{userId}/line/{lineId}/action")
	@ResponseStatus(code = HttpStatus.OK,  value =  HttpStatus.OK)
	public List<ActionDTOResponse> getAllActionsFromLine(@PathVariable(name = "userId") Long userId,
			@PathVariable(name = "lineId") Long lineId) {
		return actionRecordingservice.find(userId, lineId);
	}
	
	@DeleteMapping("user/{userId}/line/{lineId}/action/{actionId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
	public void deleteAction(@PathVariable(name = "userId") Long userId,
			@PathVariable(name = "lineId") Long lineId
			,@PathVariable(name = "actionId") Long actionId) {
		actionRecordingservice.delete(userId , lineId ,actionId);
	}
	
	
}
