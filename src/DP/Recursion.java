package DP;

public class Recursion {
	//Head Recursion
	void rec(int num) {
		if(num>1) {
			rec(num-1);
		}
		System.out.println(num);
	}
	//Tail Recursion
	void recRev(int num) {
		if(num>0) {
			System.out.println(num);
			recRev(num-1);
		}
	}
	int recRet(int num) {
		if(num>0) {
			System.out.println(num);
			return recRet(num-1);
		}
		return 1;
		
	}
	int recRetFwd(int num,int i) {
		System.out.println(i);
		if(num==1) {
			return i;
		}
		return recRetFwd(num-1,i+1);
	}
	public static void main(String[] args) {
		Recursion r=new Recursion();
		System.out.println("Forward Without ReturnType");
		r.rec(10);
		System.out.println("Reverse Without ReturnType");
		r.recRev(10);
		System.out.println("Reverse With ReturnType");
		r.recRet(10);
		System.out.println("Forward With ReturnType");
		r.recRetFwd(10,1);
	}
}
