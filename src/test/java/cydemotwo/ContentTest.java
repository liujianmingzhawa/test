package cydemotwo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


import com.everything.demo.po.Student;
import com.everything.demo.util.SignUtils;

public class ContentTest {
	
	public static void main(String[] args) throws Exception {
		List<String> readLines = FileUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\汉字对照表.txt"));
		List<String> listsss = new ArrayList<>();
		for(int i=0; i<readLines.size();i++){
			if(i%2==1){
				listsss.add(readLines.get(i).trim().replaceAll("\\s", ""));
			}
		}
		//您369
		//蕊4079瑞4080锐4081芮6039蕤6208枘7236睿780蚋8224
		//闰4082润408
		Map<String, Integer> map = new HashMap<>();
		for (String str : listsss) {
			int length = str.length();
			if(length%5 == 0){
				int xx = length/5;
				for(int m=0;m<xx; m++){
					String substring = str.substring(m*5,(m+1)*5);	
					map.put(substring.substring(0,1), Integer.valueOf(substring.substring(1, 5)));
				}
			} 
		}
		map.put("您", 369);
		map.put("蕊", 4079);
		map.put("瑞", 4080);
		map.put("锐", 4081);
		map.put("芮", 6039);
		map.put("蕤", 6208);
		map.put("枘", 7236);
		map.put("睿", 780);
		map.put("蚋", 8224);
		map.put("闰", 4082);
		map.put("润", 408);
		System.err.println(map);
	}
	
	// 根据前三个字对比文案
	public static void main12(String[] args) throws Exception {
		List<String> readLines = FileUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\德邦content.txt"));
		Set<String> set = new HashSet<>(readLines);
		readLines = new ArrayList<>(set);
		Map<Integer, List<String>> map = new HashMap<>();
		Map<String, List<String>> thirdMap = new HashMap<>();
		for (String content : readLines) {
			content = content.replaceAll("【德邦快递】", "").trim().replaceAll("\\d+","").replaceAll("[a-zA-z]", "");
/*			List<String> list = map.get(content.length());
			if(list==null || list.size()==0){
				list = new ArrayList<String>();
				map.put(content.length(), list);
			}
			list.add(content);*/
			if(StringUtils.isEmpty(content) || content.length() < 10){
				continue;
			}
			String substr = content.substring(0,3);
			List<String> list = thirdMap.get(substr);
			if(list == null){
				list = new ArrayList<>();
				thirdMap.put(substr, list);
			}
			list.add(content);
		}
		
	/*	for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
			Integer key = entry.getKey();
			List<String> value = entry.getValue();
			System.err.println(key);
			System.err.println(value);
		}*/
		
		for(Map.Entry<String, List<String>> entry : thirdMap.entrySet()){
			System.err.println(entry.getKey()+"=="+entry.getValue().toString());
		}
		
	}
	
	
	public static void main3(String[] args) throws Exception {
		
		List<String> readLiness = FileUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\汉字对照表.txt"));
		List<String> listsss = new ArrayList<>();
		for(int i=0; i<readLiness.size();i++){
			if(i%2==1){
				listsss.add(readLiness.get(i).trim().replaceAll("\\s", ""));
			}
		}
		//您369
		//蕊4079瑞4080锐4081芮6039蕤6208枘7236睿780蚋8224
		//闰4082润408
		Map<String, Integer> mapp = new HashMap<>();
		for (String str : listsss) {
			int length = str.length();
			if(length%5 == 0){
				int xx = length/5;
				for(int m=0;m<xx; m++){
					String substring = str.substring(m*5,(m+1)*5);	
					mapp.put(substring.substring(0,1), Integer.valueOf(substring.substring(1, 5)));
				}
			} 
		}
		mapp.put("您", 369);
		mapp.put("蕊", 4079);
		mapp.put("瑞", 4080);
		mapp.put("锐", 4081);
		mapp.put("芮", 6039);
		mapp.put("蕤", 6208);
		mapp.put("枘", 7236);
		mapp.put("睿", 780);
		mapp.put("蚋", 8224);
		mapp.put("闰", 4082);
		mapp.put("润", 408);
		
		
		
		
		List<String> readLines = FileUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\绿地.txt"));
		

		
		
		
	/*	Map<Integer, String> map = new HashMap<Integer, String>();
		for (String content : readLines) {
			map.put(content.length(), content);
		}
		System.err.println(map.size());
		for(Map.Entry<Integer,String> entry : map.entrySet()){
			System.err.println(entry.getValue());
		}
		*/
		Map<Integer, List<String>> map = new HashMap<>();
		for (String content : readLines) {
			content = content.trim().replaceAll("[^\\u4e00-\\u9fa5]", "");
			List<String> list = map.get(content.length());
			if(list==null || list.size()==0){
				list = new ArrayList<String>();
				map.put(content.length(), list);
			}
			list.add(content);
		}
		Set<String> chList = new HashSet();
		List<String> xxx = new ArrayList<>();

		for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
			//System.err.println(entry.getKey());
			//System.err.println(entry.getValue().size());
			//System.err.println(entry.getValue());
	/*		if(entry.getKey() == 194){
				System.err.println(entry.getValue());
			}*/
			if(entry.getKey() == 62){
				List<String> co = entry.getValue();
				for (String str : co) {
					xxx.add(str);
					char[] charArray = str.toCharArray();
					for(int i =0; i<charArray.length;i++){
						chList.add(charArray[i]+"");
					}
				}
			}
		}
		
		
	    System.err.println(chList);
	    List<String> sslist = new ArrayList<>(chList);
	    Map<String, Integer> map2 = new HashMap<>();
		for(int c = 0; c<sslist.size(); c++){
			map2.put(sslist.get(c), c+5000);
		}
		System.err.println(map2);
		
		for (String str : xxx) {
			System.err.println(str);
			char[] charArray = str.toCharArray();
			int count = 0;
			for(int i=0; i<charArray.length;i++){
				count+=mapp.get(charArray[i]+"");
			}
			System.err.println(count);
		}
	
		
		
	}
	
	
	public static void main11(String[] args) throws Exception {
		List<String> readLines = FileUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\content.txt"));
		long currentTimeMillis = System.currentTimeMillis();
		Map<String, Set<String>> map = new HashMap<>();
		for (String content : readLines) {
			String sign = SignUtils.getSignByContent(content);
			Set<String> set = map.get(sign);
			if(set == null){
				set = new HashSet<>();
				map.put(sign, set);
			}
			set.add(content);
		}
		System.err.println(map.size());
		int count = 0;
		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			Set<Student> students = new HashSet<>();
			Set<String> value = entry.getValue();
			for (String content : value) {				
				Student student = new Student();
				student.setCompar(50);
				student.setContent(content);
				students.add(student);
			}
			for (Student student : students) {
				System.err.println(entry.getKey()+"=="+student.getContent());
				count++;
			}
			
		}
		
		System.err.println(count);
		System.err.println(System.currentTimeMillis() - currentTimeMillis);
	}
	
	
	
	
	
	
	public static void main100(String[] args) {
/*		int  startId = 400000;
		int count = 2000;
		for(int i=0; i< 200; i++){
			int staId = startId + i*count + 1;
			int enId = staId+count-1;
			System.err.println(staId+"==="+enId);
		}*/
		int pageSize = 5000;
		int count = 80000001;
		int length = count % pageSize == 0 ? count / pageSize : (count / pageSize + 1);	
		for(int i = 0; i < length ; i++){
			int startId = i*pageSize + 1;
			int endId = (i+1)*pageSize;
			if(i == length -1){
				endId = count;
			}
			System.err.println(startId+"=="+endId);
		}
		
	}
	
	
	
	
}
