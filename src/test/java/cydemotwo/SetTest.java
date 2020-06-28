package cydemotwo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.everything.demo.po.AllSign;

public class SetTest {
    public static final char LEFT_BRACKET = '【';
    public static final char RIGHT_BRACKET = '】';
	public static void main(String[] args) throws Exception {
/*		List<AllSign> list = new ArrayList<AllSign>();
		AllSign allSign = new AllSign();
		allSign.setDestChannel(null);
		allSign.setSignature("【测试1】");
		allSign.setExtendCode("123");
		list.add(allSign);
		AllSign allSign1 = new AllSign();
		allSign1.setDestChannel("测试1");
		allSign1.setSignature("【测试1】");
		allSign1.setExtendCode("123");
		list.add(allSign1);
		System.err.println(list);
		System.err.println(list.size());
		Map<String, List<AllSign>> collect = list.stream().filter(t -> t.getDestChannel() != null).collect(Collectors.groupingBy(AllSign :: getDestChannel));
		System.err.println(collect);*/
/*		List<String> readLines = FileUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\0528.txt"));
		List<Long> list = new ArrayList<>();
		for (String line : readLines) {
			String[] split = line.split(",");
			for(int i =0; i<split.length; i++){
				list.add(Long.valueOf(split[i]));
			}
		}
		//Collections.sort(list);
		
		for(Long i=1L; i<= 5271259L; i++){
			if(!list.contains(i)){
				System.err.println(i);
			}
		}*/
		String str = "(";
		for(int i = 4000001; i <= 4001000; i++){
			str += i + ",";
		}
		System.err.println(str+")");
	/*	FileUtils.writeLines(new File("C:\\Users\\ljm\\Desktop\\ids.txt"), list);
		System.err.println(list.size());//5271259
*//*		String content = "测试";
		content = "" == null ? content : (LEFT_BRACKET + ("京东" == null ? StringUtils.EMPTY : "京东") + RIGHT_BRACKET + content);
		System.err.println(content);*/
	}
}
