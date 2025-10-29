package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.Gender;

/**
 * 社員情報エンティティ
 * 
 * @author 絹川
 */
public class Employee {

	//社員番号
	private String empId;
	//社員名
	private String empName;
	//性別
	private String gender;
	//生年月日
	private String birthday;
	//部署ID
	private String deptId;
	//部署名
	private String deptName;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
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
		return empId + "\t"
				+ empName + "\t"
				+ Gender.fromNumeric(gender) + "\t"
				+ birthday + "\t"
				+ deptName;
	}

}
