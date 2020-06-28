package cydemotwo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
public class CutPictureUtil {
	public static void main(String[] args) throws IOException, URISyntaxException, AWTException {
        // 控制浏览器打开网页，仅适用于JdK1.6及以上版本
        Desktop.getDesktop().browse(new URL("https://z.didi.cn/roBf0Qo3HIGST").toURI());
        Robot robot = new Robot();
        // 延迟一秒
        robot.delay(1000);
        // 获取屏幕宽度和高度
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
        // 最大化浏览器
        robot.keyRelease(KeyEvent.VK_F11);
        robot.delay(1000);
        // 对屏幕进行截图
        Image image = robot.createScreenCapture(new Rectangle(0, 0, width, height));
        // 通过图形绘制工具类将截图保存
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        // 保存图片
        ImageIO.write(img, "jpg", new File("D:/tmp/"+System.currentTimeMillis()+".jpg"));
        System.out.println("done!");
    }
	
	public static void main11(String[] args) throws Exception {
	    //
        String href = "http://adasda.dsad";
        // 端口号
        int port = parsePort(href);
        // 域名
        String host = parseHost(href);
        // IP 地址
        String address = parseIp(host);
    //
        System.out.println("host=" + host); 
        System.out.println("port=" + port); 
        System.out.println("address=" + address);
	}
	
	
    public static int parsePort(String href) throws IOException {
        //
        URL url = new URL(href);
        // 端口号; 如果 href 中没有明确指定则为 -1
        int port = url.getPort();
        if (port < 0) {
            // 获取对应协议的默认端口号
            port = url.getDefaultPort();
        }
        return port;
    }
    
    public static String parseHost(String href) throws IOException {
        //
        URL url = new URL(href);
        // 获取 host 部分
        String host = url.getHost();
        return host;
    }
    public static String parseIp(String host) throws IOException {
        // 根据域名查找IP地址
        InetAddress.getAllByName(host);
        InetAddress inetAddress = InetAddress.getByName(host);
        // IP 地址
        String address = inetAddress.getHostAddress();
        return address;
    }
    
    
    
    

}
