
public class CalcTotal {
	
	public String itemD;
	public double itemC;
	public int quant;

	public CalcTotal(String itemD, String itemC, String quant) {
		
		this.itemD = itemD;
		this.itemC = Double.parseDouble(itemC);
		this.quant = Integer.parseInt(quant);
		
	}
	
}
