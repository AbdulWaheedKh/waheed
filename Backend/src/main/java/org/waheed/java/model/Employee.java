package org.waheed.java.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Data
@Table(name = "employe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private Long id;

   @Size(min=2, message = "length of first name must be 2 or greater") 
   @Column(name = "firstname")
   private String firstName;

   @Column(name = "lastname")
   private String lastName;

   @Column(name = "salary")
   private int salary;  
   
   @Column(name = "CreatedDate")
   private Timestamp CreatedDate;  
   
   @Column(name = "ModifiedDate")
   private Timestamp ModifiedDate;  
   
   @Column(name = "Deleted")
   private Boolean Deleted;  
   
}
