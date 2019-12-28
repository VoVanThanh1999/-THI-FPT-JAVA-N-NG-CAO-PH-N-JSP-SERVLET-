package com.example.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Action;
import com.example.model.Member;
import com.example.repository.ActionRepository;
import com.example.service.ActionServiceImpl;
import com.example.service.MemberServiceImpl;


@Controller
@RequestMapping(value = "/")
public class ViewResources {
	@Autowired
	MemberServiceImpl nemberService;
	
	@Autowired
	ActionServiceImpl  actionServiceImpl;
	
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
	@RequestMapping(value = "/quanlyhoatdong")
	public ModelAndView quanLyHoatDong() {
		ModelAndView andView = new ModelAndView("quanlyhoatdong");
		andView.addObject("members", nemberService.getAll());
		return andView;
	}
	
	@RequestMapping(value = "/themhoatdong")
	public ModelAndView themHoatDong() {
		ModelAndView andView = new ModelAndView("themhoatdong");
		andView.addObject("members", nemberService.getAll());
		return andView;
	}
	
	@RequestMapping(value = "/thamgiahoatdong")
	public ModelAndView thamGiaHoatDong() {
		ModelAndView andView = new ModelAndView("thamgiahoatdong");
		andView.addObject("members", nemberService.getAll());
		
		List<Action> actions = actionServiceImpl.loadAllAction();
		andView.addObject("actions", actions.stream().
				filter(e ->!e.getStatus().equalsIgnoreCase("Da ket thuc")).
				collect(Collectors.toList()));
		
	
		return andView;
	}
	
	
	
	
}
