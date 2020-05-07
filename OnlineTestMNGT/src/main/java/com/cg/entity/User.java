package com.cg.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="userTable2")
public class User {

	@Id
	private BigInteger userId;
	@Column
	private String userName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="testId")
	private Test userTest;
	
	@Column
    private boolean isAdmin;
	@Column
	private String userPassword;
	
	@Column
	private BigInteger mobile_no;
	
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
