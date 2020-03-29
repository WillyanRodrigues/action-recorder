package br.com.vivo.actionrecorder.service;

import java.util.List;

import br.com.vivo.actionrecorder.dto.response.CreateDTOResponse;

public interface ServiceEntityInterface<I,O> {

	public CreateDTOResponse create(I dto , Long id); 
	
	public O find(Long id);
	
	public List<O> find();
}
