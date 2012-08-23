package pfm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the moneyaccount database table.
 * 
 */
@Entity
public class Moneyaccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String code;
	private List<Expense> expenses;
	private List<Income> incomes;
	private Account account;
	private List<Transfer> transfers1;
	private List<Transfer> transfers2;

	public Moneyaccount() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="moneyaccount")
	public List<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}


	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="moneyaccount")
	public List<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}


	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="accountId")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	//bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy="moneyaccount1")
	public List<Transfer> getTransfers1() {
		return this.transfers1;
	}

	public void setTransfers1(List<Transfer> transfers1) {
		this.transfers1 = transfers1;
	}


	//bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy="moneyaccount2")
	public List<Transfer> getTransfers2() {
		return this.transfers2;
	}

	public void setTransfers2(List<Transfer> transfers2) {
		this.transfers2 = transfers2;
	}

}