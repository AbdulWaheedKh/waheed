package org.waheed.java.model;

import java.sql.Timestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Institute {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	
	private String instituteCode;

	private String instituteName;
	private String address;
	private boolean deleted;
	
    private Timestamp ModifiedDate;
	private Timestamp CreatedDate;
	

	@ManyToOne()
	@JoinColumn(name = "ProfileId")
	private Profile profile;
	
}
