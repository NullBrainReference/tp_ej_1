package tp_ej_1;

import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("enter cities count");
		if (input == null)
		{
			throwCustomMessage("wrong value");
			return;
		}
		else if (verifyNumber(input)) {
			throwCustomMessage("wrong value");
			return;
		}
			
		int count = Integer.parseInt(input);
		
		WeatherSheet sheet = new WeatherSheet(count);
		throwCustomMessage(sheet.toString());
		
		while (true) {
			
			String[] options = new String[] {"Exit", "Set", "Get", "Set City", "Get AVG", "Get Max"};
			String opt = (String) JOptionPane.showInputDialog(null, "choose the option", "menu", 0, null, options, "Set City");
			switch (opt) {
			case "Exit":
				return;
			case "Set":
				setTemp(sheet);
				break;
			case "Set City":
				setCity(sheet);
				break;
			case "Get":
				getTemp(sheet);
				break;
			case "Get AVG":
				getAvg(sheet);
				break;
			case "Get Max":
				getMax(sheet);
				break;
			}
			
			throwCustomMessage(sheet.toString());
		}
		
	}
	
	private static void getAvg(WeatherSheet sheet) {
		JOptionPane.showMessageDialog(null, sheet.getAVGOutput());
	}
	
	private static void getMax(WeatherSheet sheet) {
		var max = sheet.getMax();
		JOptionPane.showMessageDialog(null, max[0] + " " + max[1]);
	}
	
	private static void setCity(WeatherSheet sheet) {
		String inputC = JOptionPane.showInputDialog("enter city name");
		if (inputC == null)
		{
			throwCustomMessage("wrong value");
			return;
		}
		
		sheet.setCity(inputC);
	}
	
	private static void throwCustomMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	private static void getTemp(WeatherSheet sheet) {
		String inputC = JOptionPane.showInputDialog("enter city name");
		if (inputC == null)
		{
			throwCustomMessage("wrong value");
			return;
		}
		
		if (sheet.doesCityExist(inputC) == false)
		{
			throwCustomMessage("does not exist");
			return;
		}
		
		String input = JOptionPane.showInputDialog("enter day value");
		if (input == null)
		{
			throwCustomMessage("wrong value");
			return;
		}
		else if (verifyNumber(input)) {
			throwCustomMessage("wrong value");
			return;
		}
		int day = Integer.parseInt(input);
		
		throwCustomMessage(String.valueOf(sheet.getTemp(inputC, day)));
	}
	
	private static void setTemp(WeatherSheet sheet) {
		String inputC = (String) JOptionPane.showInputDialog("enter city name");
		if (inputC == null)
		{
			throwCustomMessage("wrong value");
			return;
		}
		
		if (sheet.doesCityExist(inputC) == false)
		{
			throwCustomMessage("does not exist");
			return;
		}
		
		String input = JOptionPane.showInputDialog("enter day value");
		if (input == null)
		{
			throwCustomMessage("wrong value");
			return;
		}
		else if (verifyNumber(input)) {
			throwCustomMessage("wrong value");
			return;
		}
		int day = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("enter temp value");
		if (input == null)
		{
			throwCustomMessage("wrong value");
			return;
		}
		else if (verifyNumber(input)) {
			throwCustomMessage("wrong value");
			return;
		}
		int tmp = Integer.parseInt(input);
		
		if (tmp > 50) {
			throwCustomMessage("too high");
			return;
		}
		if (tmp < -50) {
			throwCustomMessage("too low");
			return;
		}
		
		sheet.setTemp(inputC, day, tmp);
	}
	
	
	
	private static boolean verifyNumber(String num) {
		for (char ch : num.toCharArray()) {
			if (Character.isDigit(ch)) {
				return false;
			}
		}
		
		return true;
	}

}
