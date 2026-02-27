package com.tap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.model.Expense;
import com.tap.repository.ExpenseRepository;

@Service
public class ExpenseService {

	    @Autowired
	    private ExpenseRepository expenseRepository;

	    public void saveExpense(Expense expense) {
	         expenseRepository.save(expense);
	    }

	    public List<Expense> getAllExpenses() {
	           return (List<Expense>) expenseRepository.findAll();
	    }

		public void deleteExpense(int id) {
			expenseRepository.deleteById(id);


		
        
}

		public Expense getExpenseById(int id) {
		    return expenseRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Expense not found for id : " + id));
		}
		


	

		

		
		
	}


