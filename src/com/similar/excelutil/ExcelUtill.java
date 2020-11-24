package com.similar.excelutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtill {
	public static void main(String[] args) {
		// 获取文件路径
		String filePath = "C:\\xx/1.xlsx";
		Workbook workbook = null;
		FileInputStream inputStream = null;
		List<City> cityList = new ArrayList<City>();

		File exceFile = new File(filePath);
		try {
			// 读取文件流
			inputStream = new FileInputStream(exceFile);
			// 读取工作簿
			workbook = new XSSFWorkbook(inputStream);
			// 获取sheet页
			Sheet sheet = workbook.getSheetAt(0);

			// 读取数据并保存
			for (int i = 1; i < 1042; i++) {
				Row row = sheet.getRow(i);
				City city = new City();

				for (int j = 0; j < 4; j++) {
					Cell cell = row.getCell(j);
					if (j == 0) {
						city.setId(cell.getStringCellValue());
					}
					if (j == 1) {
						city.setEqualId(cell.getStringCellValue());
					}
					if (j == 2) {
						city.setCityName(cell.getStringCellValue());
					}
					if (j == 3) {
						city.setCityFlag(cell.getStringCellValue());
					}
				}

				cityList.add(city);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 设置输出文件路径
		String outFilePath = "C:\\xx/1.txt";
		try {
			// 获得输出流
			BufferedWriter ot = new BufferedWriter(new FileWriter(outFilePath));

			// 编辑输出文本
			String frstLine = "";
			ot.write(frstLine);
			ot.newLine();

			String outString = "";
			
			ot.write(outString);
			ot.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
