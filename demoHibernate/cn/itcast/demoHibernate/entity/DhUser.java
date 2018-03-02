package cn.itcast.demoHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name="dh_user")*/
public class DhUser {
	
	private Long DhId;
	private String DhName;
	
	//getter and setter method;
	/*@Id
	@Column(name="dh_id")*/
	public Long getDhId() {
		return DhId;
	}
	public void setDhId(Long dhId) {
		DhId = dhId;
	}
	
	/*@Column(name="dh_name")*/
	public String getDhName() {
		return DhName;
	}
	public void setDhName(String dhName) {
		DhName = dhName;
	}

}
