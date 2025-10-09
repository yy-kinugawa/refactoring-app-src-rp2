package jp.co.sss.crud.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.sss.crud.util.Gender;

public class Employee {

	//社員番号
	private int empId;
	//社員名
	private String empName;
	//性別
	private int gender;
	//生年月日
	private Date birthday;
	//部署ID
	private int deptId;
	//部署名
	private String deptName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return empId + "\t"
				+ empName + "\t"
				+ Gender.fromNumeric(gender) + "\t"
				+ sdf.format(birthday) + "\t"
				+ deptName;
	}

}
