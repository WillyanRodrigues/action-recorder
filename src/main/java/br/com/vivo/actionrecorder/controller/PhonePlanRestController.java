package br.com.vivo.actionrecorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vivo.actionrecorder.dto.request.PlanDTO;
import br.com.vivo.actionrecorder.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PhonePlanRestController {
	
	@Autowired
	PlanService service;

	@PostMapping
	public void create(@RequestBody PlanDTO plan) {
		service.create(plan);
	}
}
