package model.entities;

import model.exceptions.DomainException;

public class Account {
	private int number;
	private String holder;
	private double balance, withdrawLimit;
	
	public Account() {
	}

	public Account(int number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}
	
	public void withdraw(double amount) throws DomainException{
		if(amount > balance && amount < withdrawLimit){
			throw new DomainException("Not enough balance");
		}
		if(amount < balance && amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		System.out.printf("New balance: %.2f%n", balance - amount);
	}
}
