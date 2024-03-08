package com.priyanshu.q_09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_09.model.Transaction;
import com.priyanshu.q_09.model.User;
import com.priyanshu.q_09.service.FinanceService;

@RestController
@RequestMapping("/api")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @PostMapping("/users") // http://localhost:8080/api/users
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return financeService.createUser(user);
    }
    // {
    //     "id": 3,    
    //     "username": "JaneSmith",
    //     "email": "jane.smith@example.com"
    // }

    @GetMapping("/users/{id}") // http://localhost:8080/api/users/5
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return financeService.getUserById(id);
    }

    @PutMapping("/users/{id}") // http://localhost:8080/api/users/5
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return financeService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}") // http://localhost:8080/api/users/4
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        return financeService.deleteUser(id);
    }

    

    @PostMapping("/transactions") // http://localhost:8080/api/transactions
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return financeService.createTransaction(transaction);
    }

//     {
//         "type": "Deposit",
//         "amount": 20000.0,
//         "description": "Deposit into savings account",
//         "user": {
//             "id": 1
//         }
// }

    @GetMapping("/transactions/{id}") // http://localhost:8080/api/transactions/2
    public ResponseEntity<Transaction> getTransactionById(@PathVariable int id) {
        return financeService.getTransactionById(id);
    }

    @GetMapping("/transactions/user/{userId}") // http://localhost:8080/api/transactions/user/1
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable int userId) {
        return financeService.getTransactionsByUserId(userId);
    }

    @PutMapping("/transactions/{id}") // http://localhost:8080/api/transactions/2
    public ResponseEntity<Transaction> updateTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
        return financeService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/transactions/{id}") // http://localhost:8080/api/transactions/4
    public ResponseEntity<Void> deleteTransaction(@PathVariable int id) {
        financeService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
