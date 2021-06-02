package automateIt.fixtures.beans;

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

//    @Override
//    public String toString() {
//        return "AdminUserBean{" +
//                "userRole='" + userRole + '\'' +
//                ", employeeName='" + employeeName + '\'' +
//                ", userName='" + userName + '\'' +
//                ", status='" + status + '\'' +
//                ", password='" + password + '\'' +
//                ", confirmPassword='" + confirmPassword + '\'' +
//                '}';
//    }
}
