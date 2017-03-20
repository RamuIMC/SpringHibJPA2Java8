/**
 * 
 */
package com.project.dto;

import java.io.Serializable;

/**
 * @author Ramakrishna
 *
 */
public class UserDto implements Serializable{	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7712364646825618513L;
	private int userId;
	private String userName;
	private String token;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
