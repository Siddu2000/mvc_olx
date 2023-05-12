package DTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(generator = "idg")
	@SequenceGenerator(initialValue = 4512131, allocationSize = 1, sequenceName = "idg", name = "idg")
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	int custid;
	String name;
	String email;
	long mobile;
	String password;
	String gender;
	Date dob;
	String address;
	int age;

}
