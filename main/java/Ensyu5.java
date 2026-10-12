import java.util.ArrayList;
import java.util.List;

public class Ensyu5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int[] num = {1,2,3,4,5,6,7,8,9};
		int start = 0;
		List<Integer> chosen = new ArrayList<Integer>();
		Sum(sum,num,start,chosen);
 	}
	
	static void Sum(int sum,int[] num,int start, List<Integer> chosen) {
		if(sum == 15) {
			System.out.println(chosen);
			return;
		}
		for(int i = start; i < 9;i++) {
			
			start = i + 1;
			chosen.add(num[i]);
			sum = sum + num[i];
			Sum(sum,num,start,chosen);
			
			chosen.remove(chosen.size() - 1);
			sum = sum - num[i];
		}
	}
		

}
