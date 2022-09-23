package com.example.spring_boot_api_jwt_ad.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_token")
@Getter
@Setter
public class Token extends BaseEntity {

	@Column(length = 1000)
	private String token;

	private Date tokenExpDate;
	// get set

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenExpDate() {
		return tokenExpDate;
	}

	public void setTokenExpDate(Date tokenExpDate) {
		this.tokenExpDate = tokenExpDate;
	}
	// constructor

	public Token(Long id, String deleted, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy, String token,
			Date tokenExpDate) {
		super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
		this.token = token;
		this.tokenExpDate = tokenExpDate;
	}

	public Token(String token, Date tokenExpDate) {
		super();
		this.token = token;
		this.tokenExpDate = tokenExpDate;
	}

	public Token() {
		super();
	}

}
