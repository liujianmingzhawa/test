package cydemotwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;


public class HtmlToImage {
/*	public static void main(String[] args){
		ProcessBuilder pb = new ProcessBuilder("D:\\tmp\\", "www.baidu.com", "D:\\tmp\\test.jpg");
		Process process;
		try {
			process = pb.start();
			//注意，调用process.getErrorStream()而不是process.getInputStream()
			BufferedReader errStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream())); 
			System.out.println("read errstreamreader");
			String line = null;
			line = errStreamReader.readLine(); 
			while(line != null) { 
			    System.out.println(line); 
			    line = errStreamReader.readLine(); 
			}
			process.destroy();
		    System.out.println("destroyed process");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	

    public static void generateOutput() throws Exception {
        String url = new File("https://z.didi.cn/roBfdSLPckk7g").toURI().toString();
        JEditorPane ed = new JEditorPane(new URL(url));
        ed.setSize(1000,1300);
        Thread.sleep(5000);
        //create a new image
        BufferedImage image = new BufferedImage(ed.getWidth(), ed.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        SwingUtilities.paintComponent(image.createGraphics(),
                ed,
                new JPanel(),
                0, 0, image.getWidth(), image.getHeight());
        //save the image to file
        ImageIO.write((RenderedImage)image, "png", new File("D:\\tmp\\01.png"));
    }
    public static void main(String[] args) {
        try {
            generateOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
