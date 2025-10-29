package jp.co.sss.crud.dto;

/**
 * 部署情報エンティティ
 * 
 * @author 絹川
 */

public class Department {

	//部署ID
	private String deptId;
	//部署名
	private String deptName;

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
		return deptId + ":" + deptName;
	}
}
