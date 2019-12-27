package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="action")
public class Action {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_action")
	private int idAction;
	@Column
	private String nameAction;
	private String description;
	private String dayStart;
	private String dayFinish;
	private int numberMax;
	private int numberMin;
	private String deadlineForRegistration;
	private String status;
	private String cancellation;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;


	public int getIdAction() {
		return idAction;
	}

	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}

	public String getNameAction() {
		return nameAction;
	}

	public void setNameAction(String nameAction) {
		this.nameAction = nameAction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDayStart() {
		return dayStart;
	}

	public void setDayStart(String dayStart) {
		this.dayStart = dayStart;
	}

	public String getDayFinish() {
		return dayFinish;
	}

	public void setDayFinish(String dayFinish) {
		this.dayFinish = dayFinish;
	}

	public int getNumberMax() {
		return numberMax;
	}

	public void setNumberMax(int numberMax) {
		this.numberMax = numberMax;
	}

	public int getNumberMin() {
		return numberMin;
	}

	public void setNumberMin(int numberMin) {
		this.numberMin = numberMin;
	}

	public String getDeadlineForRegistration() {
		return deadlineForRegistration;
	}

	public void setDeadlineForRegistration(String deadlineForRegistration) {
		this.deadlineForRegistration = deadlineForRegistration;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCancellation() {
		return cancellation;
	}

	public void setCancellation(String cancellation) {
		this.cancellation = cancellation;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
}
