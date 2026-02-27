package com.tap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Expenses")
public class Expense {
        @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private Double amount;

	    private String description;

	    private String date;

      public Expense() {
		
    	  }

	  public Expense(int id, Double amount, String description, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.date = date;
	  }

	  public int getId() {
		  return id;
	  }

	  public void setId(int id) {
		  this.id = id;
	  }

	  public Double getAmount() {
		  return amount;
	  }

	  public void setAmount(Double amount) {
		  this.amount = amount;
	  }

	  public String getDescription() {
		  return description;
	  }

	  public void setDescription(String description) {
		  this.description = description;
	  }

	  public String getDate() {
		  return date;
	  }

	  public void setDate(String date) {
		  this.date = date;
	  }

	  @Override
	  public String toString() {
		return "Expense [id=" + id + ", amount=" + amount + ", description=" + description + ", date=" + date + "]";
	  }
    	  







}