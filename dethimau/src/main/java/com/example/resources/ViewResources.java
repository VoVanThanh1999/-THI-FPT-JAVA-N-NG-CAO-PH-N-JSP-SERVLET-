package com.example.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Member;
import com.example.service.MemberServiceImpl;


@Controller
@RequestMapping(value = "/")
public class ViewResources {
	@Autowired
	MemberServiceImpl nemberService;
	
	@RequestMapping(value = "/")
	public ModelAndView addMember() {
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}
	
	@RequestMapping(value = "/quanlythanhvien")
	public ModelAndView quanLyThanhVien() {
		ModelAndView andView = new ModelAndView("quanlythanhvien");
		andView.addObject("members", nemberService.getAll());
		return andView;
	}
}