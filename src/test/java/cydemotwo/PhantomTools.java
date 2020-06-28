package cydemotwo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gui.ava.html.Html2Image;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;  

public class PhantomTools {
	    private static final Logger logger = LoggerFactory.getLogger(PhantomTools.class);

	    private static final String _tempPath = "D:/temp/";
	    private String basePath;
	    private static final String _shellCommand1 = "phantomjs ";
	    private static final String _shellCommand2 = "rasterize.js ";

	    private String _file;
	    private String _size;

	    /**
	     * 构造截图类
	     * @param hash 用于临时文件的目录唯一化
	     * @param basePath phantomJs所在路径
	     */
	    public PhantomTools(int hash, String basePath) {
	        _file = _tempPath + hash + ".png";
	        this.basePath = basePath;
	    }

	    /**
	     * 构造截图类
	     * @param hash 用于临时文件的目录唯一化
	     * @param size 图片的大小，如800px*600px（此时高度会裁切），或800px（此时 高度最少=宽度*9/16，高度不裁切）
	     * @param basePath phantomJs所在路径
	     */
	    public PhantomTools(int hash, String size, String basePath) {
	        _file = _tempPath + hash + ".png";
	        if (size != null)
	            _size = " " + size;
	        this.basePath = basePath;
	    }

	    /**
	     * 将目标网页转为图片字节流
	     * @param url 目标网页地址
	     * @return 字节流
	     */
	    public byte[] getByteImg(String url) throws IOException {
	        BufferedInputStream in = null;
	        ByteArrayOutputStream out = null;
	        File file = null;
	        byte[] ret = null;
	        try {
	            if (exeCmd(basePath + _shellCommand1 + basePath + _shellCommand2 + url + " " + _file + (_size != null ? _size : ""))) {
	                file = new File(_file);
	                if (file.exists()) {
	                    out = new ByteArrayOutputStream();
	                    byte[] b = new byte[5120];
	                    in = new BufferedInputStream(new FileInputStream(file));
	                    int n;
	                    while ((n = in.read(b, 0, 5120)) != -1) {
	                        out.write(b, 0, n);
	                    }
	                    file.delete();
	                    ret = out.toByteArray();
	                }
	            } else {
	                ret = new byte[] {};
	            }
	        } finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	            } catch (IOException e) {
	            	logger.error(e.getMessage());
	            }
	            try {
	                if (in != null) {
	                    in.close();
	                }
	            } catch (IOException e) {
	            	logger.error(e.getMessage());
	            }
	            if (file != null && file.exists()) {
	                file.delete();
	            }
	        }
	        return ret;
	    }

	    /**
	     * 执行CMD命令
	     */
	    private static boolean exeCmd(String commandStr) {
	        BufferedReader br = null;
	        try {
	            Process p = Runtime.getRuntime().exec(commandStr);
	            if (p.waitFor() != 0 && p.exitValue() == 1) {
	                return false;
	            }
	        } catch (Exception e) {
	            logger.error(e.getMessage());
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (Exception e) {
	                    logger.error(e.getMessage());
	                }
	            }
	        }
	        return true;
	    }
	    
	    
	    public static void main(String[] args) throws Exception {
/*	    	 String charset = "UTF-8";  
	         String line = "";  
	         StringBuffer buffer = new StringBuffer();  
	         URL url = new URL("http://www.baidu.com");  
	         //开始访问该URL  
	         HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();  
	         //获取服务器响应代码  
	         int responsecode = urlConnection.getResponseCode();  
	         String contentType = urlConnection.getContentType();  
	         //打印出content-type值，然后就可以从content-type中提取出网页编码  
	         System.out.println("content-type:" + contentType);  
	         if(responsecode == 200){  
	             //获取网页输入流  
	             BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),charset));  
	             while((line = reader.readLine()) != null){  
	                 buffer.append(line).append("\n");  
	             }  
	             System.out.println(buffer.toString());  
	         }  
	         else{  
	             System.out.println("获取不到网页的源码，服务器响应代码为："+responsecode);  
	         }  
	         urlConnection.disconnect();  */
	        // System.err.println(getRedirectUrl("https://z.didi.cn/roBfcjHpqscfE"));
	         
	  /* 	Html2Image html2Image = Html2Image.fromURL(new URL("https://3.cn/1-2yxXDm"));
	        html2Image.getImageRenderer().saveImage("d:/tmp/13.png");*/
	    	
	    	
	    	System.err.println(getRedirectUrl("https://3.cn/1-2yxXDm"));
	    
	     }  
		
	    public static String getRedirectUrl(String path) throws Exception {
			HttpURLConnection conn = (HttpURLConnection) new URL(path)
					.openConnection();
			conn.setInstanceFollowRedirects(false);
			conn.setConnectTimeout(5000);
	        return conn.getHeaderField("Location");
		}

}
