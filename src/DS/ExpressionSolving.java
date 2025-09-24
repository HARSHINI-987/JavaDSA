package DS;
public class ExpressionSolving {
	int expression(String st){
		StackInt stack=new StackInt(st.length());
		for(char ch:st.toCharArray()) {
			if(Character.isDigit(ch)) {
				stack.push(ch-'0');
			}
			else {
				int b=stack.pop();
				int a=stack.pop();
				if(ch=='*') {
					stack.push(a*b);
				}
				else if(ch=='/') {
					stack.push(a/b);
				}
				else if(ch=='+') {
					stack.push(a+b);
				}
				else if(ch=='-') {
					stack.push(a-b);
				}
				else if(ch=='^') {
					int res=(int)Math.pow(a, b);
					stack.push(res);
				}
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		ExpressionSolving e=new ExpressionSolving();
		String st="573*+1-";
		int op=e.expression(st);
		System.out.println(op);
	}
}
