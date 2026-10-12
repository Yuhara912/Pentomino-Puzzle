import java.util.ArrayList;
import java.util.List;

public class Ensyu4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] digits = {1,2,3,4};
		boolean[] used = new boolean[digits.length];
		List<Integer> chosen = new ArrayList<Integer>();
		search(digits, used, chosen);
	}
	
	static void search(int[] digits,boolean[] used,List<Integer> chosen) {
		if(chosen.size() == 4) {
			int sum = 0;
			for(int i = 0; i < chosen.size();i ++) {
				sum =(int) (sum + chosen.get(i) * Math.pow(10, i));
			}
			if(sum > 3000 && sum % 2 == 0) {
				System.out.println(sum);
			}
			return;
		}
		for(int i = 0; i < digits.length;i++) {
			if(used[i]) {
				continue;
			}
			chosen.add(digits[i]);
			used[i] = true;

			search(digits,used,chosen);
			used[i] = false;
			chosen.remove(chosen.size() - 1);
			
		}
	}

}
