package addrbook;

public class AddrBookVO {
	/*
	 *   ab_id number(11) NOT NULL PRIMARY KEY ,
  ab_name varchar(15) NOT NULL,
  ab_email varchar(50) DEFAULT NULL,
  ab_comdept varchar(20) NOT NULL,
  ab_birth varchar(10) NOT NULL,
  ab_tel varchar(20) DEFAULT NULL,
  ab_memo varchar(100) DEFAULT NULL
	 */
	int abId;
	String abName;
	String abEmail;
	String abComdept;
	String abBirth;
	String abTel;
	String abMemo;
	public int getAbId() {
		return abId;
	}
	public void setAbId(int abId) {
		this.abId = abId;
	}
	public String getAbName() {
		return abName;
	}
	public void setAbName(String abName) {
		this.abName = abName;
	}
	public String getAbEmail() {
		return abEmail;
	}
	public void setAbEmail(String abEmail) {
		this.abEmail = abEmail;
	}
	public String getAbComdept() {
		return abComdept;
	}
	public void setAbComdept(String abComdept) {
		this.abComdept = abComdept;
	}
	public String getAbBirth() {
		return abBirth;
	}
	public void setAbBirth(String abBirth) {
		this.abBirth = abBirth;
	}
	public String getAbTel() {
		return abTel;
	}
	public void setAbTel(String abTel) {
		this.abTel = abTel;
	}
	public void setAbMemo(String abMemo) {
		this.abMemo = abMemo;
	}
	public String getAbMemo() {
		return abMemo;
	}
	@Override
	public String toString() {
		return "AddrBookVO [abId=" + abId + ", abName=" + abName + ", abEmail=" + abEmail + ", abComdept=" + abComdept
				+ ", abBirth=" + abBirth + ", abTel=" + abTel + ", abMemo=" + abMemo + "]";
	}
	
	
}
