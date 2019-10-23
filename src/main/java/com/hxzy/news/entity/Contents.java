package com.hxzy.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbl_content")
public class Contents implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String content;
	@Column(length = 10)
	private String datetime;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "u_id")
	private User user;


	public String getContent() {
		return content;
	}

	public String getDatetime() {
		return datetime;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public User getUser() {
		return user;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
