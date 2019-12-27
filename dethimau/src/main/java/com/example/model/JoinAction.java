package com.example.model;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="join_action")
public class JoinAction {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne()
	private Action actions;
	
	@ManyToMany(mappedBy = "joinActions")
	private List<Member> members;
	
	@Column()
	private Date daySignup;
	private int pointLeader;
	private int point1;
	private int point2;
	private int point3;
	private String comment;
	public int getId() {
		return id;
	}
	public Action getActions() {
		return actions;
	}
	public void setActions(Action actions) {
		this.actions = actions;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public Date getDaySignup() {
		return daySignup;
	}
	public void setDaySignup(Date daySignup) {
		this.daySignup = daySignup;
	}
	public int getPointLeader() {
		return pointLeader;
	}
	public void setPointLeader(int pointLeader) {
		this.pointLeader = pointLeader;
	}
	public int getPoint1() {
		return point1;
	}
	public void setPoint1(int point1) {
		this.point1 = point1;
	}
	public int getPoint2() {
		return point2;
	}
	public void setPoint2(int point2) {
		this.point2 = point2;
	}
	public int getPoint3() {
		return point3;
	}
	public void setPoint3(int point3) {
		this.point3 = point3;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
}
