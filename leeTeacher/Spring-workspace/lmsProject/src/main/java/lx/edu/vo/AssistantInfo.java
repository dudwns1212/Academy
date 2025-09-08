package lx.edu.vo;

public class AssistantInfo {
	String taId;
	String taName;
	String deptId;
	String supervisorId;
	String taType;
	String createdAt;
	public String getTaId() {
		return taId;
	}
	public void setTaId(String taId) {
		this.taId = taId;
	}
	public String getTaName() {
		return taName;
	}
	public void setTaName(String taName) {
		this.taName = taName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getTaType() {
		return taType;
	}
	public void setTaType(String taType) {
		this.taType = taType;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "AssistantInfo [taId=" + taId + ", taName=" + taName + ", deptId=" + deptId + ", supervisorId="
				+ supervisorId + ", taType=" + taType + ", createdAt=" + createdAt + "]";
	}
	
}
