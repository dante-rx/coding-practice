package javacoding;

public class Employee {
	private String name;
	
	@Override
	public int hashCode() {
		int result = 17;
		result += 31 * name.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			return ((Employee )obj).name.equals(this.name);
		}
		return false;
	}

}
