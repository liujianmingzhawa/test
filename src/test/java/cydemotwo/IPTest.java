package cydemotwo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.everything.demo.util.GainUrlUtils;

public class IPTest {
	
	public static void main(String[] args) throws Exception {
		List<String> readLines = FileUtils.readLines(new File("C:\\Users\\ljm\\Desktop\\url2.txt"));
		for (String line : readLines) {
			if(!line.equals("url=")){
				String[] split = line.split("=");
				if(split.length > 1){
					System.err.println(GainUrlUtils.getUrl(split[1]));
				}
			}
		}
	}
}
