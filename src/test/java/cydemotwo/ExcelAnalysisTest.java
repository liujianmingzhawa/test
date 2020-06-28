package cydemotwo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.opc.ZipPackagePart;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFVMLDrawing;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
public class ExcelAnalysisTest {
	
	
	public static void main(String[] args) throws Exception {
		try(FileInputStream input = new FileInputStream(new File("C:\\Users\\ljm\\Desktop\\签名报备表.xlsx"))
			
				) {
			XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(input);
			List<XSSFPictureData> pictures = workbook.getAllPictures();
			XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
			List<POIXMLDocumentPart> relations = sheet.getRelations();
			
			for (POIXMLDocumentPart dr : relations) {
				if(dr instanceof XSSFDrawing){
					System.err.println("---");
					XSSFDrawing drawing = (XSSFDrawing) dr;  
		            List<XSSFShape> shapes = drawing.getShapes();  
		            for (XSSFShape shape : shapes) {  
	                    XSSFPicture pic = (XSSFPicture) shape;  
	                    XSSFClientAnchor anchor = pic.getPreferredSize();  	                
	                    CTMarker ctMarker = anchor.getFrom();  
	                    System.err.println(ctMarker.getRow()+":"+ctMarker.getCol());
	                    FileOutputStream out = new FileOutputStream(new File("C:\\Users\\ljm\\Desktop\\测试图片.jpg"));
	                    out.write(pic.getPictureData().getData());
	                    out.flush();
	                    out.close();
	                }  
				}
	    	 }
			
		} 
	}
}
