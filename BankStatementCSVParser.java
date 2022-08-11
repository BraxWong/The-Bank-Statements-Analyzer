import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//CSV FILES FORMAT
//30-01-2017,-100,Deliveroo
//30-01-2017,-50,Tesco
//01-02-2017,6000,Salary
//02-02-2017,2000,Royalties
//02-02-2017,-4000,Rent
//03-02-2017,3000,Tesco
//05-02-2017,-30,Cinema

public class BankStatementCSVParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("DD-MM-YYYY");
	
	private BankTransaction parseFromCSV(final String line) {
		//Parse the line by columns using split(limiter);
		final String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date,amount,description);
	}
	
	public List<BankTransaction> parseLinesFromCSV(final List<String> lines){
		final List<BankTransaction> bankTransactions = new ArrayList<>();
		for(final String line : lines) {
			bankTransactions.add(parseFromCSV(line));
		}
		return bankTransactions;
	}
	
}
