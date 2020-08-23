package ManufactureJet.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ManufactureJet.application.DTO.JetDto;
import ManufactureJet.application.DTO.JetOrderDTO;
import ManufactureJet.application.Entity.JetEntity;
import ManufactureJet.application.Entity.JetOrderEntity;
import ManufactureJet.application.repository.JetOrderRepository;
import ManufactureJet.application.repository.JetRepository;
@Service
public class JetService {
	@Autowired
	JetRepository repo;
	
	@Autowired
	JetOrderRepository orderrepo;
	
	public List<JetDto> getModel(){
		List<JetEntity> jetModel= repo.findAll();
		List<JetDto> modelList= new ArrayList<JetDto>();
		for(JetEntity j1:jetModel) {
			JetDto Model = JetDto.valueOf(j1);
			modelList.add(Model);
		}
		return modelList;
	}
	
	public JetDto getModelById(String manufactureModelNo) {
		JetDto model= null;
		Optional<JetEntity> entity=repo.findById(manufactureModelNo);
		if(entity.isPresent()) {
			if(manufactureModelNo.equals(entity.get().getManufactureModelNo())) {
				model=JetDto.value(entity);
				}
		}
		return model;
	}

	public void orderJet(JetOrderDTO order) throws Exception {
		System.out.println("in entity");
		Optional<JetEntity> entity=repo.findById(order.getQuotationmodelno());
		System.out.println(entity);
		if(entity.isPresent()) {
			if(order.getQuotationmodelno().equals(entity.get().getManufactureModelNo())) {
				JetDto model=JetDto.value(entity);
				System.out.println(model);
				JetOrderEntity jetOrder= order.createEntity(model);
				System.out.println(jetOrder);
				orderrepo.save(jetOrder);
			}
		}else {
			throw new Exception("Invalid Quotation Model Number");
		}
		
	}

	public void deleteOrder(Integer orderid) throws Exception {
		Optional<JetOrderEntity> entity= orderrepo.findById(orderid);
		if(entity.isPresent()) {
			orderrepo.deleteById(orderid);
		}else {
			throw new Exception("Order ID Unavailable");
		}
	}

	public JetDto getModelByName(String modelName) {
		JetDto model= null;
		JetEntity entity=repo.findBymodelName(modelName);
		model=JetDto.valueOf(entity);
		return model;
	}

	public List<JetOrderDTO> getvieworder() {
		List<JetOrderEntity> entity=orderrepo.findAll();
		List<JetOrderDTO> orderdto=new ArrayList<JetOrderDTO>();
		for(JetOrderEntity en:entity) {
			JetOrderDTO dto=JetOrderDTO.value(en);
			orderdto.add(dto);
		}
		
		return orderdto;
	}

	public JetOrderDTO getViewOrderById(Integer orderid) throws Exception {
		Optional<JetOrderEntity> entity= orderrepo.findById(orderid);
		if(entity.isPresent()) {
			JetOrderDTO jetorderDTO = JetOrderDTO.valueOf(entity);
			return jetorderDTO ;
		}
		else {
			throw new Exception("Order ID Unavailable");
		}
		
	}
}
