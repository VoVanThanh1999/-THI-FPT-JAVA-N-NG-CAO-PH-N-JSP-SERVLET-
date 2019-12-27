package com.example.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Member;
import com.example.repository.ActionRepository;
import com.example.service.ActionServiceImpl;
import com.example.service.MemberServiceImpl;

import ch.qos.logback.core.joran.action.Action;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	@Autowired
	ActionServiceImpl actionServiceImpl;
	
	@Autowired
	ActionRepository actionRepository;
	
	@RequestMapping(value = "/member",method = RequestMethod.POST)
	public String addMember(@Valid  @RequestBody Member member) {
		try {
			if (memberServiceImpl.addMember(member) != null) {
				return "Add Member Success";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping(value = "/member/{id}",method=RequestMethod.DELETE)
	public String deleteMember(@PathVariable("id") int id) {
		try {
			memberServiceImpl.deleteMember(id);
			return "xoa thanh cong";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value="/action",method=RequestMethod.GET)
	public List<com.example.model.Action> loadAll(){
		return actionServiceImpl.loadAllAction();
	}
	
	@RequestMapping(value="/action",method=RequestMethod.POST)
	public String addAction(@Valid @RequestBody com.example.model.Action action) {
		try {
			 actionServiceImpl.addAction(action);
			 return "them thanh cong";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value="/action/{id}",method=RequestMethod.DELETE)
	public String deleteAction(@PathVariable("id") int id) {
		try {
			Optional<com.example.model.Action> actionInput = actionRepository.findById(id);
			actionServiceImpl.deleteAction(actionInput.get());
			return "xoa thanh cong";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
