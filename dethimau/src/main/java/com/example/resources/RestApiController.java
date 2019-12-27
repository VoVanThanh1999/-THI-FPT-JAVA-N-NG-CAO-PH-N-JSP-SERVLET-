package com.example.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Member;
import com.example.service.MemberServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
	@Autowired
	MemberServiceImpl memberServiceImpl;
	
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
	
	@RequestMapping(value = "/member/{id}")
	public void deleteMember(@PathVariable("id") int id) {
		try {
			memberServiceImpl.deleteMember(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			
		}
	}
	
}
