import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;




public class BankTransactionAnalyzer {
	//The path
	private static final String RESOURCES = "src/main/resources";
	
	//A function that calculate the total amount from a list of bankTransactions
	public static double calculateTotalAmount(List <BankTransaction> bankTransactions) {
		//amount has the value of 0
		double amount = 0d;
		for(final BankTransaction bankTransaction : bankTransactions) {
			//bankTransaction has a method called getAmount() which returns the amount
			amount += bankTransaction.getAmount();
		}
		//Return the amount
		return amount;
	}
	
	public static List<BankTransaction> selectInMonth(final List <BankTransaction> bankTransactions, final Month month){
		//Creating a new ArrayList to store BankTransaction objects
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for(BankTransaction bankTransaction : bankTransactions) {
			//BankTransaction has a method called getDate() which returns a LocalDate Object, and LocalDate object has a method called getMonth() which returns the month
			if(bankTransaction.getDate().getMonth() == month) {
				//Pushing it into the arrayList
				bankTransactionsInMonth.add(bankTransaction);
			}
		}
		//Returing the arrayList 
		return bankTransactionsInMonth;
	}
	
	public static void main(final String str) throws IOException {
		//A Path class represents a path in the filesystem
		final Path path = Paths.get(RESOURCES + str);
		//Creating a BankStatementCSVParser object so we can use the parseLinesFromCSV method
		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
		
		//Store all the lines within the file in a linked list using the Files.readAllLines(PATH) function
		final List<String> lines = Files.readAllLines(path);
		
		//Creating a list of BankTransaction objects and storing the lines
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
		
		//Printing out all the items
		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January is " + selectInMonth(bankTransactions,Month.JANUARY));
		
		
		}
	}
