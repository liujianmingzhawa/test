package com.everything.demo.po;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


public class Student extends BaseObject{
	private static final long serialVersionUID = 6699610293238838037L;

	private String content;
	
	private String name;
	
	private Integer age;
	
	private Integer compar;
	
	private List<Map<String, String>> param;
	


	public List<Map<String, String>> getParam() {
		return param;
	}

	public void setParam(List<Map<String, String>> param) {
		this.param = param;
	}

	public Integer getCompar() {
		return compar;
	}

	public void setCompar(Integer compar) {
		this.compar = compar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return 100;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if(other.getContent() == null){
			return false;
		}
		
		if(this.content == null){
			return false;
		}
		
		if(this.content.equals(other.getContent())){
			return true;
		}
		
		if(other.getContent().length()*this.compar/100 > this.content.length() || this.content.length()*this.compar/100 > other.getContent().length()){
			return false;
		}
		if(getSimilarityRatio(this.content, other.getContent())*100 <= this.compar){
			return false;
		}
		
		
		if(getSimFloat(this.content, other.getContent()) * 100 <= (float)this.compar){
			return false;
		}
		return true;
	}
	
	public float getSimFloat(String s1,String s2){
		int max = Math.max(s1.length(), s2.length());
		return 1 - (float) StringUtils.getLevenshteinDistance(s1, s2) / max;
	}
	
	/*
	
	public  int compare(String str, String target) {
		int d[][]; // 矩阵
		int n = str.length();
		int m = target.length();
		int i; // 遍历str的
		int j; // 遍历target的
		char ch1; // str的
		char ch2; // target的
		int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		d = new int[n + 1][m + 1];
		// 初始化第一列
		for (i = 0; i <= n; i++) {
			d[i][0] = i;
		}
		// 初始化第一行
		for (j = 0; j <= m; j++) {
			d[0][j] = j;
		}
		for (i = 1; i <= n; i++) {
			// 遍历str
			ch1 = str.charAt(i - 1);
			// 去匹配target
			for (j = 1; j <= m; j++) {
				ch2 = target.charAt(j - 1);
				if (ch1 == ch2 || ch1 == ch2 + 32 || ch1 + 32 == ch2) {
					temp = 0;
				} else {
					temp = 1;
				}
				// 左边+1,上边+1, 左上角+temp取最小
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
			}
		}
		return d[n][m];
	}

	*//**
	 * 获取最小的值
	 *//*
	public  int min(int one, int two, int three) {
		return (one = one < two ? one : two) < three ? one : three;
	}*/


	public float getSimilarityRatio(String str, String target) {
		int max = Math.max(str.length(), target.length());
		return 1 - (float) StringUtils.getLevenshteinDistance(str, target) / max;
	}

	

}
