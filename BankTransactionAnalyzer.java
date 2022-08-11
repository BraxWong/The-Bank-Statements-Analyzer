import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;




public class BankTransactionAnalyzer {
	//The path
	private static final String RESOURCES = "src/main/resources";
	
	
	//Creating a BankStatementCSVParser object so we can use the parseLinesFromCSV method
	final static BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
			
	
	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
	}
	
	
	
	public static void main(final String str) throws IOException {
		//A Path class represents a path in the file system
		final Path path = Paths.get(RESOURCES + str);
		
		//Store all the lines within the file in a linked list using the Files.readAllLines(PATH) function
		final List<String> lines = Files.readAllLines(path);
		
		//Creating a list of BankTransaction objects and storing the lines
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
		
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		collectSummary(bankStatementProcessor);
		
		
		}

}
