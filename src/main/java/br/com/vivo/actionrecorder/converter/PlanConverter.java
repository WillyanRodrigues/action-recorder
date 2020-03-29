package br.com.vivo.actionrecorder.converter;

import org.springframework.stereotype.Component;

import br.com.vivo.actionrecorder.dto.request.ConsumeLimitDTO;
import br.com.vivo.actionrecorder.dto.request.PlanDTO;
import br.com.vivo.actionrecorder.entity.Plan;

@Component
public class PlanConverter implements EntityDTOConverter<PlanDTO, Plan , PlanDTO> {

	@Override
	public PlanDTO toDTO(Plan object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plan toEntity(PlanDTO object) {
		Plan plan = new Plan();
		plan.setCallLimit(object.getConsumeLimit().getCall());
		plan.setInternetLimit(object.getConsumeLimit().getInternet());
		plan.setSmsLimit(object.getConsumeLimit().getSms());
		plan.setPrice(object.getPrice());
		plan.setType(object.getType());
		return plan;
	}

	@Override
	public PlanDTO toResponseDTO(Plan object) {
		PlanDTO planDTO = new PlanDTO();
		ConsumeLimitDTO consumeLimitDTO = new ConsumeLimitDTO();
		consumeLimitDTO.setCall(object.getCallLimit());
		consumeLimitDTO.setInternet(object.getInternetLimit());
		consumeLimitDTO.setSms(object.getSmsLimit());
		planDTO.setConsumeLimit(consumeLimitDTO);
		planDTO.setPrice(object.getPrice());
		planDTO.setType(object.getType());
		return planDTO;
	}

}
