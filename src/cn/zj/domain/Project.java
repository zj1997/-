package cn.zj.domain;

public class Project {
/*��Ŀ��Ϣ
    CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL,
  `presource` varchar(50) NOT NULL,
  `pfee` double(50,0) NOT NULL,
  `ptime` date NOT NULL,
  `prole` varchar(50) NOT NULL,
  `person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `pname` (`pname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

��Ŀ��Ϣ����Ŀ��š���Ŀ���ơ���Ŀ��Դ��������������ʡ��������Э���������ѡ�����ʱ�䡢�μ���Ա��ɫ���������֡���Ҫ�μӡ�һ��μӣ���
*/
	
	private Integer project_id;
	private String pname;
	private String presource;
	private String prole;
	private String ptime;
	private Double pfee;
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPresource() {
		return presource;
	}
	public void setPresource(String presource) {
		this.presource = presource;
	}
	public String getProle() {
		return prole;
	}
	public void setProle(String prole) {
		this.prole = prole;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public Double getPfee() {
		return pfee;
	}
	public void setPfee(Double pfee) {
		this.pfee = pfee;
	}
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", pname=" + pname + ", presource=" + presource + ", prole="
				+ prole + ", ptime=" + ptime + ", pfee=" + pfee + "]";
	}
	
}
