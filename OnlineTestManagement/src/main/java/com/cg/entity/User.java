package com.cg.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicUpdate(true)
@DynamicInsert(true)

@Table(name="userTable2")
public class User implements Serializable{

	@NotNull(message = "User Id is mandatory")
	@Id
	private BigInteger userId;
	
	@NotEmpty(message = "user name is mandetory")
	@Column
	private String userName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="testId")
	private Test userTest;
	
	@Column
    private boolean isAdmin;
	
	@Column
	private String userPassword;
	
	@NotNull(message = "mobile number is mandetory")
	@Column
	private BigInteger mobile_no;
	
	@NotEmpty(message = "email id is mandetory")
	@Column
	private String email;
	
	public User(BigInteger userId, String userName, boolean isAdmin, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		//this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public BigInteger getUserId() {
		return userId;
	}


	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Test getUserTest() {
		return userTest;
	}


	public void setUserTest(Test userTest) {
		this.userTest = userTest;
	}


	public boolean getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public BigInteger getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(BigInteger mobile_no) {
		this.mobile_no = mobile_no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", isAdmin=" + isAdmin
				+ ", userPassword=" + userPassword + ", mobile_no=" + mobile_no + ", email=" + email + "]";
	}
	


	
}
