
package com.te.lms.entity.employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.te.lms.ourenum.AddressType;
import com.te.lms.ourenum.State;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_address_info")
public class EmployeeAddressInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	@Column(name = "address_type")
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	@Column(name = "city")
	private String city;
	@Column(name = "door_no")
	private String doorNo;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "locality")
	private String locality;
	@Column(name = "pincode")
	private Integer pincode;
	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private State state;
	@Column(name = "street")
	private String street;
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "employee_primary_info_address", joinColumns
	 * = @JoinColumn(name = "address_address_id"), inverseJoinColumns
	 * = @JoinColumn(name = "employee_emp_id")) private EmployeePrimaryInfo
	 * employeePrimaryInfo2;
	 */
}
