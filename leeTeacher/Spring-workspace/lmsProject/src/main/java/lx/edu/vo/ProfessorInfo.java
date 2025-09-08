package lx.edu.vo;

public class ProfessorInfo {
	String ProfessorId;
	String ProfessorName;
	String ProfessorRank;
	String hireDate;
	String specialization;
	String officeLocation;
	String deptId;
	String createdAt;
	public String getProfessorId() {
		return ProfessorId;
	}
	public void setProfessorId(String professorId) {
		ProfessorId = professorId;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public String getProfessorRank() {
		return ProfessorRank;
	}
	public void setProfessorRank(String professorRank) {
		ProfessorRank = professorRank;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getOfficeLocation() {
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "ProfessorInfo [ProfessorId=" + ProfessorId + ", ProfessorName=" + ProfessorName + ", ProfessorRank="
				+ ProfessorRank + ", hireDate=" + hireDate + ", specialization=" + specialization + ", officeLocation="
				+ officeLocation + ", deptId=" + deptId + ", createdAt=" + createdAt + "]";
	}
	
	
}
