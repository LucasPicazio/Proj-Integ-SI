package com.pisi.marketplace.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("USERNAME")
    private String username;
    
    @JsonProperty("ADMIN")
    private String admin;

    @JsonProperty("PASSWORD")
    private String password;

    @JsonProperty("EMAIL")
    private String email;

    @JsonProperty("FULLNAME")
    private String fullName;

    @JsonProperty("PHONENUMBER")
    private String phoneNumber;

    @JsonProperty("ADDRESS")
    private String address;

    @JsonProperty("BIRTHDAY")
    private String birthday;

	
	public MemberResource(String username, String admin,String password,String email,String fullName,String phoneNumber, String address,String birthday) {
		this.username = username;
		this.admin = admin;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birthday = birthday;
	}
    
    public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

	@Override
	public String toString() {
		return "MemberResource [username=" + username + ", admin=" + admin + ", password=" + password + ", email="
				+ email + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", birthday=" + birthday + "]";
	}

}
