import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
	public List<BankTransaction> bankTransactions;
	
	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
			this.bankTransactions = bankTransactions;
	}
	
	public double calculateTotalAmount() {
		double amount = 0d;
		for(final BankTransaction bankTransaction: bankTransactions) {
			amount += bankTransaction.getAmount();
		}
		return amount;
	}
	
	public double calculateTotalInMonth(final Month month) {
		double amount = 0d;
		for(final BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				amount += bankTransaction.getAmount();
			}
		}
		return amount;
	}
	
	public double calculateTotalForCategory(final String category) {
		double amount = 0d;
		for(final BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDescription() == category) {
				amount += bankTransaction.getAmount();
			}
		}
		return amount;
	}
}
