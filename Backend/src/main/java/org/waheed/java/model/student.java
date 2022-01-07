/**
 * 
 */
package org.waheed.java.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * @author Waheed
 *
 */
@Entity
@Data
@Table(name = "student")
public class student {
	
	   @Id 
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "ID")
	   private Long ID;

	   @Size(min=2, message = "length of first name must be 2 or greater") 
	   @Column(name = "FirstName")
	   private String FirstName;

	   @Column(name = "LastName")
	   private String LastName;

	   @Column(name = "RollNumber")
	   private int RollNumber;  

	   @Column(name = "Deleted")
	   private Boolean Deleted;  
	   
	   @Column(name = "CreatedDate")
	   private Timestamp CreatedDate;  
	   
	   @Column(name = "ModifiedDate")
	   private Timestamp ModifiedDate;  
}
