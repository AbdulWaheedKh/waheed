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

import org.waheed.java.utils.EncryptionUtill;

import lombok.Data;

/**
 * @author Waheed
 *
 * Date : 11 jan 2022
 */
@Entity
@Data
@Table(name = "account")
public class account {
	
	   @Id 
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "Id")
	   private Long Id;

	   @Size(min=2, message = "length of user name must be 2 or greater") 
	   @Column(name = "Username")
	   private String Username;

	   @Column(name = "Password")
	   private String Password;

	   @Column(name = "CreatedDate")
	   private Timestamp CreatedDate;  
	   
	   @Column(name = "ModifiedDate")
	   private Timestamp ModifiedDate;  

	   @Column(name = "Deleted")
	   private Boolean Deleted; 
	   
	   public void setEncryptedPassword(String pwd) {
		this.setPassword(EncryptionUtill.encryptMD5(pwd));
	}


    }
