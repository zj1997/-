package cn.zj.domain;

public class Payoff {
/*
 * //���гɹ�
CREATE TABLE `scientist_payoff` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `catagory` varchar(50) DEFAULT NULL,
  `rank` varchar(50) DEFAULT NULL,
  `class` int(11) DEFAULT NULL,
  `cer_num` int(11) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pay_id`),
  KEY `pname` (`pname`),
  CONSTRAINT `pname` FOREIGN KEY (`pname`) REFERENCES `project` (`pname`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 * ���гɹ����ɹ���š���Ŀ���ơ������Ȼ��ѧ�����Ƽ����������������������𣨹�
          �ҡ�����ʡ���У����ȼ���1~4����֤����������׼ʱ�䡣

 * */
	private Integer pay_id;
	private Integer p_class;
	private Integer cer_num;
	private String pname;
	private String catagory;
	private String rank;
	private String time;
	public Integer getPay_id() {
		return pay_id;
	}
	public void setPay_id(Integer pay_id) {
		this.pay_id = pay_id;
	}
	
	public Integer getCer_num() {
		return cer_num;
	}
	public void setCer_num(Integer cer_num) {
		this.cer_num = cer_num;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getP_class() {
		return p_class;
	}
	public void setP_class(Integer p_class) {
		this.p_class = p_class;
	}
	@Override
	public String toString() {
		return "Payoff [pay_id=" + pay_id + ", p_class=" + p_class + ", cer_num=" + cer_num + ", pname=" + pname
				+ ", catagory=" + catagory + ", rank=" + rank + ", time=" + time + "]";
	}
	
	
	
}
