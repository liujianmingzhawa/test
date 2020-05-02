package cydemotwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class UpdateTableTest {
	
	public static void main(String[] args) throws Exception {
		String str = "ALTER TABLE sms_history_%1$02d%2$02d ADD COLUMN message_format INT(11);";
		List<String> lines = new ArrayList<>();
		for (int m = 1; m <= 12; m++) {
			for (int d = 1; d <= 31; d++) {
				lines.add(String.format(str, m,d)+"\r\n");
			}
		}
		FileOutputStream output = new FileOutputStream(new File("C:\\Users\\ljm\\Desktop\\alter_sms_history.txt"));
		IOUtils.writeLines(lines, "", output, "UTF-8");
		System.err.println("完成。。。。。。。。。。");
	}
}
