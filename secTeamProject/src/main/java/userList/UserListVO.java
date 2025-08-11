package userList;

public class UserListVO {
	public String userId;
	public String userName;
	public int userAge;
	public String userMobile;
	public String userPassword;
	
	public UserListVO() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int age) {
		this.userAge = age;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String mobile) {
		this.userMobile = mobile;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String id) {
		this.userId = id;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String password) {
		this.userPassword = password;
	}
}
