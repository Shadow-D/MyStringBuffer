public class Test implements MyStringBuffer{
	private static int length=0;
	private static int capacity=20;
	private static char[] cha=new char[20];
	@Override
	public void append(char c) {
		// TODO Auto-generated method stub
		if (length+1<=capacity) {
			cha[length]=c;
			length++;
		} else {
			capacity=capacity+capacity/2;
			char[] cha1=new char[capacity];
			for (int i=0;i<length;i++) {
				cha1[i]=cha[i];
			}
			cha=cha1;
			append(c);
		}
	}

	@Override
	public void append(String s) {
		// TODO Auto-generated method stub
		if (length+s.length()<=capacity) {
			for (int i=0;i<s.length();i++) {
				cha[length]=s.toCharArray()[i];
				length++;
			}
		} else {
			capacity=capacity+capacity/2;
			char[] cha1=new char[capacity];
			for (int i=0;i<length;i++) {
				cha1[i]=cha[i];
			}
			cha=cha1;
			append(s);
		}
	}

	@Override
	public void insert(int p, char c) {
		// TODO Auto-generated method stub
		if (p>capacity-1||p<0) {
			System.out.println("字符插入位置错误");
			return;
		}
		if (length+1<=capacity) {
			for(int i=length-1;i>=p;i--) {
				cha[i+1]=cha[i];
			}
			cha[p]=c;
			length++;
		} else {
			capacity=capacity+capacity/2;
			char[] cha1=new char[capacity];
			for (int i=0;i<length;i++) {
				cha1[i]=cha[i];
			}
			cha=cha1;
			insert(p, c);
		}
	}

	@Override
	public void insert(int p, String s) {
		// TODO Auto-generated method stub
		if (p>capacity-1||p<0) {
			System.out.println("字符串插入位置错误");
			return;
		}
		if (length+s.length()<=capacity) {
			for(int i=length-1;i>=p;i--) {
				cha[i+s.length()]=cha[i];
			}
			for (int i=0;i<s.length();i++) {
				cha[p+i]=s.toCharArray()[i];
				length++;
			}
		} else {
			capacity=capacity+capacity/2;
			char[] cha1=new char[capacity];
			for (int i=0;i<length;i++) {
				cha1[i]=cha[i];
			}
			cha=cha1;
			insert(p, s);
		}
	}

	@Override
	public void delete(int start) {
		// TODO Auto-generated method stub
		if (start>capacity-1||start<0) {
			System.out.println("删除位置错误");
			return;
		}
		int length1=length;
		for (int i=start;i<length1;i++) {
			cha[i]=0;
			length--;
		}
	}

	@Override
	public void delete(int start, int end) {
		// TODO Auto-generated method stub
		if (start>capacity-1||start<0||end>capacity-1||end<0||start>end) {
			System.out.println("删除范围错误");
			return;
		}
		for (int i=start;i<end;i++) {
			cha[i]=0;
			length--;
		}
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		char temp='\0';
		for (int i=0;i<length/2;i++) {
			temp=cha[i];
			cha[i]=cha[length-1-i];
			cha[length-1-i]=temp;
		}
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return length;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string=String.valueOf(cha);
		return string;
	}
	public static void main(String args[]) {
		Test test=new Test();
		test.append('0');
		test.append("12359");
		test.insert(4, '4');
		test.insert(6, "678");
		System.out.println(test.toString());
		test.reverse();
		System.out.println(test.toString());
		test.reverse();
		test.delete(5);
		System.out.println(test.toString());
		test.delete(1, 5);
		System.out.println(test.toString());
	}
}
