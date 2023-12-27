package com.example.parkview.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="factility_name")
	private String factilityName;
	
	@Column(name="player")
	private String player;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="play_date")
	private LocalDate playDate = LocalDate.now();

	public Comment(String factilityName, String player, String comments, LocalDate playDate) {
		super();
		this.factilityName = factilityName;
		this.player = player;
		this.comments = comments;
		this.playDate = playDate;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFactilityName() {
		return factilityName;
	}

	public void setFactilityName(String factilityName) {
		this.factilityName = factilityName;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getPlayDate() {
		return playDate;
	}

	public void setPlayDate(LocalDate playDate) {
		this.playDate = playDate;
	}
	
	

}
