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
	
	@Transactional
	public String editAction(Action action,Member member) {
		try {
			Optional<Action> action2 = actionRepository.findById(action.getIdAction());
			if (action2.get().getMember().getIdMember() == member.getIdMember()) {
				action2.get().setDayFinish(action.getDayFinish());
				action2.get().setDayStart(action.getDayStart());
				action2.get().setDeadlineForRegistration(action.getDeadlineForRegistration());
				action2.get().setDescription(action.getDescription());
				action2.get().setNameAction(action.getNameAction());
				action2.get().setNumberMax(action.getNumberMax());
				action2.get().setNumberMin(action.getNumberMin());
			}
			actionRepository.save(action2.get());
			return "Edit Succes";
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
