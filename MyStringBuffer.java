public interface MyStringBuffer {
	void append(char c);// 添加字符c
	void append(String s);// 添加字符串s
	void insert(int p,char c);// 指定位置p插入字符c
	void insert(int p,String s);//指定位置p插入字符串c
	void delete(int start);// 删除start后的内容
	void delete(int start,int end);// 删除start和end间的内容
	void reverse();// 字符串反转
	int length();// 获取长度
	String toString();// 转化为String
}
