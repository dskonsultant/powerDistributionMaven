package com.urjamitra.usermanagement.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="USER_MASTER")
public class UserDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen",sequenceName="USER_ID_SEQ")
	private long userId;
	
	@Column(name="USER_FIRST_NAME")
	private String userFirstName;
	
	@Column(name="USER_LAST_NAME")
	private String userLastName;
	
	@Column(name="USER_EMAIL_ADDRESS")
	private String userEmailAddress;
	
	@Column(name="USER_PHONE_NUMBER")
	private String userPhoneNumber;
	
	@Column(name="USER_HANDSET_DETAILS_ID")
	private long userHandsetDetailsId;
	
	@Column(name="USER_ROLE_ID")
	private long userRoleId;
	
	@Column(name="LAST_ACCESS_DATE_TIME")
	private Date lastAccessDateTime;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public long getUserid() {
		return userId;
	}

	public void setUserid(long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public long getUserHandsetDetailsId() {
		return userHandsetDetailsId;
	}

	public void setUserHandsetDetailsId(long userHandsetDetailsId) {
		this.userHandsetDetailsId = userHandsetDetailsId;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getLastAccessDateTime() {
		return lastAccessDateTime;
	}

	public void setLastAccessDateTime(Date lastAccessDateTime) {
		this.lastAccessDateTime = lastAccessDateTime;
	}
	
	
}
