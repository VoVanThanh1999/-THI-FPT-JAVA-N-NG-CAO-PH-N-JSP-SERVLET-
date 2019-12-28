package com.example.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Action;
import com.example.model.JoinAction;
import com.example.model.Member;
import com.example.repository.ActionRepository;
import com.example.repository.JoinActionRepository;

@Service
public class ActionServiceImpl {
	@Autowired
	ActionRepository actionRepository;
	
	@Autowired
	JoinActionRepository joinActionRepository;
	
	@Transactional
	public String addAction(Action action) {
		try {
			actionRepository.save(action);
			return "Update Success";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	public Action getActionById(int id) {
		return actionRepository.findById(id).get();
	}
	
	
	@Transactional
	public String editAction(Action actionInput) {
		try {
			Optional<Action> actionOptinal = actionRepository.findById(actionInput.getIdAction());
			Action action = actionOptinal.get();
			if (action.getStatus().equals("Da ket thuc") == false) {
				action.setDayFinish(actionInput.getDayFinish());
				action.setDayStart(actionInput.getDayStart());
				action.setDeadlineForRegistration(actionInput.getDeadlineForRegistration());
				action.setDescription(actionInput.getDescription());
				action.setNameAction(actionInput.getNameAction());
				action.setNumberMax(actionInput.getNumberMax());
				action.setNumberMin(actionInput.getNumberMin());
				actionRepository.save(action);
				return "Edit Succes";
			}
			return null;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<Action> loadAllAction(){
		return actionRepository.findAll();
	}
	
	public String deleteAction(Action actionInput) {
		try {
			Optional<Action> action = actionRepository.findById(actionInput.getIdAction());
			if (action.get().getStatus().equalsIgnoreCase("Da ket thuc")) {
				return "khong the xoa trang thai nay";
			}else {
				action.get().setStatus("Da ket thuc");
				action.get().setCancellation(actionInput.getCancellation());
				actionRepository.save(action.get());
				return "xoa thanh cong";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<JoinAction> orderByPoint(){
		return joinActionRepository.loadAllBySortPointLeader();
	}
	

}
