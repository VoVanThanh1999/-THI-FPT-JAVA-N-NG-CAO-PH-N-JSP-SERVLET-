package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.repository.MemberRepository;

@Service
public class MemberServiceImpl {
	@Autowired
	MemberRepository memberRepository;
	
	public String addMember(Member member) {
		try {
			memberRepository.save(member);
			return "update thanh cong";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<Member> getAll(){
		return memberRepository.findAll();
	}
	
	public String deleteMember(int id) {
		try {
			memberRepository.deleteById(id);
			return "Xoa thanh cong";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
