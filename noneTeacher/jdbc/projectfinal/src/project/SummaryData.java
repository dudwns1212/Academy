package project;
// 집계함수를 나타내는 변수를 정의한 클래스
public class SummaryData {
	String id;
	String name;
	public int count;
	public String avg;
	public String max;
	public String min;
	public String sum;
	

	public String toString() {
		return "Summary [id=" + id + ", name=" + name + ",\n\tcount=" + count + ", avg=" + avg + ", max=" + max + ", min="
				+ min + ",sum=" + sum + "]\n";
	}
	
	
}
