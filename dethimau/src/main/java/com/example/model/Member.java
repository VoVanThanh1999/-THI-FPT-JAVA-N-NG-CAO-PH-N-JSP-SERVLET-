package com.example.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="member")
public class Member {
	
	@Id
	@Column(name = "id_member")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMember;
	
	@Column
	@NotNull
	@Size(min = 1,max = 36)
	private String fullName;
	
	@NotNull
	private Date ngaySinh;
	@NotNull()
	@Email
	private String email;
	@NotNull
	@Size(max = 11)
	private String phone;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "member_action", 
	    joinColumns = @JoinColumn(name="id_member"), 
	     inverseJoinColumns = @JoinColumn(name = "id") 
	)
	private List<JoinAction> joinActions;

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<JoinAction> getJoinActions() {
		return joinActions;
	}

	public void setJoinActions(List<JoinAction> joinActions) {
		this.joinActions = joinActions;
	}
	
	
	
	
	
	
}
