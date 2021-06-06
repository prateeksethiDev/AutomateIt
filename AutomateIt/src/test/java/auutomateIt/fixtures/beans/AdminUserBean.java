package auutomateIt.fixtures.beans;

public class AdminUserBean {

    private String userRole;
    private String employeeName;
    private String userName;
    private String status;
    private String password;
    private String confirmPassword;

    public AdminUserBean(String userRole, String employeeName, String userName, String status, String password, String confirmPassword) {
        this.userRole = userRole;
        this.employeeName = employeeName;
        this.userName = userName;
        this.status = status;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
     
    public String getUserRole() {
		return userRole;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getUserName() {
		return userName;
	}

	public String getStatus() {
		return status;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	@Override
    public String toString() {
        return "AdminUserBean{" +
                "userRole='" + userRole + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", userName='" + userName + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
