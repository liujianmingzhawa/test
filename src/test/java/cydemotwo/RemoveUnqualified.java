package cydemotwo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.dubbo.common.utils.IOUtils;

public class RemoveUnqualified {
	
	public static void main(String[] args) throws Exception {
		String[] readLine = IOUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\1022\\签名.txt"));
		List<String> list = Arrays.asList(readLine);
		List<String> nowlist = new ArrayList<>();
		List<String> signList = new ArrayList<>();
		for (String str : list) {
			if(StringUtils.isEmpty(str)){
				continue;
			}
			String[] split = str.split("\\s+");
			String sign = split[1];
			if(sign.length()<=8){
				nowlist.add(str);
				signList.add(sign);
			}
		}
		String[] arry = new String[]{};
		String[] arrays = nowlist.toArray(arry);
		IOUtils.writeLines(new FileOutputStream(new File("C:\\Users\\ljm\\Desktop\\1022\\正常签名.txt")), arrays);
		
		String[] arry1 = new String[]{};
		String[] arrays1 = signList.toArray(arry1);
		IOUtils.writeLines(new FileOutputStream(new File("C:\\Users\\ljm\\Desktop\\下发.txt")), arrays1);
	}
}
