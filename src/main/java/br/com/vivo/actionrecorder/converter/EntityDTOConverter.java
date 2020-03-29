package br.com.vivo.actionrecorder.converter;

public interface EntityDTOConverter<I,O,A> {

	public I toDTO(O object);
	
	public O toEntity(I object);
	
	public A toResponseDTO(O object);
}
