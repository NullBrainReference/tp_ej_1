package tp_ej_1;

public class WeatherSheet {
	private float[][] data;
	private String[] cities;
	
	public WeatherSheet(int size) {
		data = createPredicatedData(size);
		cities = new String[size];
		
		createDummyData();
	}
	
	public void setCity(String city) {
		for (int i = 0; i < cities.length; i++) {
			if (cities[i] == null) {
				setCity(city, i);
				return;
			}
			else if (cities[i].equals("")) {
				setCity(city, i);
				return;
			}
		}
		scaleUp();
		cities[cities.length - 1] = city;
	}
	public void setCity(String city ,int index) {
		if (index < 0)
			return;
		if (index >= cities.length)
			return;
		
		cities[index] = city;
	}
	
	private void scaleUp() {
		String[] citiesUp = new String[cities.length + 1];
		float[][] dataUp = new float[data.length + 1][data[0].length];
		
		for (int i = 0; i < cities.length; i++) {
			citiesUp[i] = cities[i];
			for (int j = 0; j < dataUp[0].length; j++) {
				dataUp[i][j] = data[i][j];
			}
		}
		
		cities = citiesUp;
		data = dataUp;
	}
	
	public boolean doesCityExist(String city) {
		for (String string : cities) {
			if (string == null)
				continue;
			if (string.equals(city)) {
				return true;
			}
		}
		return false;
	}
	
	public float getTemp(String city, int day) {
		for (int i = 0; i < cities.length; i++) {
			if (cities[i] == null)
				continue;
			
			if (cities[i].equals(city)) {
				return data[i][day];
			}
		}
		
		return 0;
	}
	public void setTemp(String city, int day, float value) {
		for (int i = 0; i < cities.length; i++) {
			if (cities[i] == null)
				continue;

			if (cities[i].equals(city)) {	
				System.out.println("city was found");
				data[i][day] = value;
				return;
			}
		}
	}
	
	public String getAVGOutput() {
		String result = "";
		var values = getAVG();
		for (int i = 0; i < values.length; i++) {
			result += String.format("%s: %.1f\n", cities[i], values[i]);
		}
		return result;
	}
	
	private float[] getAVG() {
		float[] result = new float[cities.length];
		
		for (int i = 0; i < cities.length; i++) {
			float avg = 0;
			for (float t : data[i]) {
				avg += t;
			}
			result[i] = avg / data[i].length;
		}
		
		return result;
	}
	
	public String[] getMax() {
		float max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < cities.length; i++) {
			for (int j = 0; j < 7; j++) {
				if (data[i][j] > max) {
					max = data[i][j];
					index = i;
				}
			}
		}
		
		return new String[] { cities[index], String.valueOf(max) };
	}
	
	private float[][] createPredicatedData(int size) {
		return new float[size][7];
	}
	
	private void createDummyData() {
		String[] variants = new String[] {"Moscow", "New York", "Bs.As.", "London", "Oslo", "Tokyo", "Wat Ever"};
		for (int i = 0; i < data.length; i++) {
			cities[i] = variants[(int) (Math.random() * variants.length)] + i; 
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = (float) Math.random() * 30;	
			}
		}
	}
	
	@Override
	public String toString() {

		String result = "";
		for (int i = 0; i < cities.length; i++) {
			if (cities[i] == null)
				continue;
			result += cities[i] + ": ";
			for (float t : data[i]) {
				result += String.format(" / %.1f", t);
			}
			result += "\n";
		}
		
		return result;
	}
}
