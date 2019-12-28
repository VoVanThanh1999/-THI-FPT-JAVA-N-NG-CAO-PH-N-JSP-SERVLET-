package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Action;
import com.example.model.JoinAction;
import com.example.model.Member;
import com.example.repository.ActionRepository;
import com.example.repository.JoinActionRepository;
import com.example.utils.JoinActionUtils;

@Service
public class JoinActionServiceImpl {
	
	@Autowired
	JoinActionRepository actionRepository;
	
	@Autowired
	ActionRepository actionRepositories;
	
	public String joinAction(Action actionDto,Member member) {
		List<JoinAction> joinActions = actionRepository.findAll();
		int temp = 0;
		for (JoinAction joinAction : joinActions) {
			if (joinAction.getActions().getIdAction() == actionDto.getIdAction()) {
				temp++;
			}
		}
		if (actionDto.getMember().getIdMember()==member.getIdMember())  {
			return JoinActionUtils.ERROR_LEADER;
		}
		if (temp<1) {
			JoinAction joinAction = new JoinAction();
			joinAction.setId(actionDto.getIdAction());
			joinAction.setActions(actionDto);
			List<Member> members = new ArrayList<Member>();
			members.add(member);
			joinAction.setMembers(members);
			actionRepository.save(joinAction);
			return JoinActionUtils.JOIN_SUCCESS;
		}else {
			Optional<JoinAction> joinAction = actionRepository.findById(actionDto.getIdAction());
			int checkMember = 0;
			for (Member memberCheck : joinAction.get().getMembers()) {
				if (memberCheck.getIdMember() == member.getIdMember()) {
					checkMember++;
				};
			}
			if (checkMember >0) {
				return JoinActionUtils.CHECK_MEMBER;
			}
			if (joinAction.get().getMembers().size()<actionDto.getNumberMax()||
					!joinAction.get().getActions().getStatus().equals("Da ket thuc")) {
				List<Member> members = joinAction.get().getMembers();
				members.add(member);
				joinAction.get().setMembers(members);
				actionRepository.save(joinAction.get());
				return JoinActionUtils.JOIN_SUCCESS;
			}else {
				return JoinActionUtils.EROR_SIZE;
			}
		}
	}
	
	
}
