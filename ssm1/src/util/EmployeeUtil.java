package util;

import java.util.Date;

public class EmployeeUtil {
	private String empName = null;
	private int sex = -1;
	private Date startBirthday = null;
	private Date endBirthday = null;
	private int roleId = 0;
	private int status = -1;
	
	public EmployeeUtil() {}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getStartBirthday() {
		return startBirthday;
	}
	public void setStartBirthday(Date startBirthday) {
		this.startBirthday = startBirthday;
	}
	public Date getEndBirthday() {
		return endBirthday;
	}
	public void setEndBirthday(Date endBirthday) {
		this.endBirthday = endBirthday;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
