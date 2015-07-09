package execl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import common.Sentence;

public class ExelData implements ExelInterface{
	static ArrayList<Sentence> list =new ArrayList<Sentence>();
	
	public XSSFWorkbook workbook;
	private String exelFilePath="D:\\banseok\\프로젝트\\자바프로젝트(영어문장공부)\\프로젝트 보고서\\EnglishSentence.xlsx";
	
	public ExelData() {		
	}

	@Override
	public ArrayList<Sentence> loadData() {
		Sentence sentence;
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(exelFilePath);
			workbook = new XSSFWorkbook(fis);
						

			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rows=sheet.getPhysicalNumberOfRows();
			
			for(int rowIndex =0 ; rowIndex < rows; rowIndex++ ){
				XSSFRow row =sheet.getRow(rowIndex);
				if(row != null){
					int cells = row.getPhysicalNumberOfCells();
					
					sentence=new Sentence();
					
					for(int columnIndex=0;columnIndex < cells ;columnIndex++){
						
						XSSFCell cell = row.getCell(columnIndex);
						String value =cell.getStringCellValue();
						
						if(columnIndex ==0){
							sentence.setEnglish(value);
						}else if(columnIndex == 1){
							sentence.setKorean(value);
						}														
					}
					System.out.println(sentence.getEnglish());
					System.out.println(sentence.getKorean());
					list.add(sentence);				
				}
				
			}
			fis.close();			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	
	}

	//Total Data Store
	@Override
	public void storeData() {
		FileOutputStream fos = null;
		Workbook workbook2;
		try {			
			workbook2 = new SXSSFWorkbook();
			SXSSFSheet sheet = (SXSSFSheet)workbook2.createSheet("Sheet1");
			
//			int rows=sheet.getPhysicalNumberOfRows();
			
			SXSSFRow row ;
			for(int i=0;i<list.size();i++){
				row = (SXSSFRow)sheet.createRow(i);
				row.createCell(0).setCellValue(list.get(i).getEnglish());
				row.createCell(1).setCellValue(list.get(i).getKorean());
			}
						
			fos = new FileOutputStream(exelFilePath);
			workbook2.write(fos); 
			
			workbook2.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	//Just add Current List , (not store Excelfile) 
	@Override
	public void addSentence(Sentence sentence) {
		list.add(sentence);
		
	}
	
	public void showList(){
		for(int i=0;i<list.size();i++){
		}
	}
	

}
