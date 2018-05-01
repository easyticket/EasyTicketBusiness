package com.dise.tickets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enterprise")
public class Enterprise {

	@Id
	@Column(name = "id_enterprise")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnterprise;

	@Column(name = "enterprise_name")
	private String enterpriseName;

	@Column(name = "enterprise_address")
	private String enterpriseAddress;

	@Column(name = "enterprise_phone")
	private String enterprisePhone;

	@ManyToOne
	@JoinColumn(name = "id_city", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_ent_cit"))
	private City city;

	public Enterprise() {
		super();
	}
	
	

	public Enterprise(Long idEnterprise, String enterpriseName, String enterpriseAddress, String enterprisePhone,
			City city) {
		super();
		this.idEnterprise = idEnterprise;
		this.enterpriseName = enterpriseName;
		this.enterpriseAddress = enterpriseAddress;
		this.enterprisePhone = enterprisePhone;
		this.city = city;
	}



	public Long getIdEnterprise() {
		return idEnterprise;
	}

	public void setIdEnterprise(Long idEnterprise) {
		this.idEnterprise = idEnterprise;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseAddress() {
		return enterpriseAddress;
	}

	public void setEnterpriseAddress(String enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}

	public String getEnterprisePhone() {
		return enterprisePhone;
	}

	public void setEnterprisePhone(String enterprisePhone) {
		this.enterprisePhone = enterprisePhone;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
