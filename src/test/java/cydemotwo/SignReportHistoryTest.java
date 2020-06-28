package cydemotwo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class SignReportHistoryTest {
	
	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();
        for (int m = 1; m <= 12; m++) {
            for (int d = 1; d <= 31; d++) {
              String  sql = String.format("CREATE TABLE `sign_report_history_%1$02d%2$02d` (\r\n" + 
              		"  `id` bigint(20) NOT NULL AUTO_INCREMENT,\r\n" + 
              		"  `gmt_create` datetime DEFAULT NULL,\r\n" + 
              		"  `gmt_modified` datetime DEFAULT NULL,\r\n" + 
              		"  `customer` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `src_channel` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `industry_type` int(11) DEFAULT NULL,\r\n" + 
              		"  `signature` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `username` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `sp_code` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `extend_code` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `dest_channel` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `content` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `connect_picture_path` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `company` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `business_license_path` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `company_query_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  `is_connect` int(11) DEFAULT NULL,\r\n" + 
              		"  `is_complete` int(11) DEFAULT '0',\r\n" + 
              		"  `md_srcchannel_sign` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\r\n" + 
              		"  PRIMARY KEY (`id`)\r\n" + 
              		") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci", m, d);
                 list.add(sql);
                System.err.println(sql);
            }
        }
        FileUtils.writeLines(new File("C:\\Users\\ljm\\Desktop\\签名报备系统\\sign_report_history.txt"), list);
	}
}
