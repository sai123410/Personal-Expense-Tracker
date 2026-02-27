package com.tap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tap.model.Expense;
import com.tap.service.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseUIController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String viewExpenses(Model model) {
        List<Expense> list = expenseService.getAllExpenses();
        model.addAttribute("expenses", list); // Name here must match th:each
        model.addAttribute("totalExpenses", list.size()); 
        return "expenses";
    }

    @GetMapping("/add-expense")
    public String showAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "add-expense"; // Ensure your file is named add-expense.html
    }

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenses"; 
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "update_expense"; // your update HTML page
    }

   
    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable("id") int id) {

        expenseService.deleteExpense(id);

        return "redirect:/expenses";
    }
      
}


