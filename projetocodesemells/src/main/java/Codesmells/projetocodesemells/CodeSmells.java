package Codesmells.projetocodesemells;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Date;

public class CodeSmells {

	public class Invoices {
		Integer itemId;
		String itemName;
		Integer itemQty;
		Double totalPrice;
		Date itemSold;

		public Invoices(Integer itemId, String itemName, Integer itemQty, Double totalPrice, Date itemSold) {
			super();
			this.itemId = itemId;
			this.itemName = itemName;
			this.itemQty = itemQty;
			this.totalPrice = totalPrice;
			this.itemSold = itemSold;
		}

		public Integer getItemId() {
			return itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public Integer getItemQty() {
			return itemQty;
		}

		public Double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public Date getItemSold() {
			return itemSold;
		}
	}

	public void writeExcell() {

		try {
			Workbook workbook = new XSSFWorkbook();

			Sheet sh = workbook.createSheet("Invoices");
			ArrayList<Invoices> a = createData();
			CreationHelper creationHelper = workbook.getCreationHelper();
			CellStyle dataStyle = workbook.createCellStyle();
			dataStyle.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
			int rownum = 0;
			for (Invoices i : a) {
				Row row = sh.createRow(rownum++);
				row.createCell(0).setCellValue(i.getItemId());
				row.createCell(1).setCellValue(i.getItemSold());
				row.createCell(2).setCellValue(i.getItemQty());
				row.createCell(3).setCellValue(i.getTotalPrice());
			
				Cell dataCell = row.createCell(4);
				dataCell.setCellValue(i.getItemSold());
				dataCell.setCellStyle(dataStyle);

			}

			Sheet sh2 = workbook.createSheet("Second");

			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\TOSHIBA\\Documents\\teste\\invoices.xls");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
			System.out.println("Completed");

		} catch (Exception e) {

		}

	}

	private ArrayList<Invoices> createData() throws ParseException {
		ArrayList<Invoices> a = new ArrayList<>();
		a.add(new Invoices(1, "Book", 2, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
		a.add(new Invoices(2, "Table", 1, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
		a.add(new Invoices(3, "Lamp", 10, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
		a.add(new Invoices(4, "Pen", 2, 20.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/03/2020")));
		a.add(new Invoices(5, "Book", 1, 670.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
		a.add(new Invoices(6, "Table", 5, 800.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/05/2020")));
		a.add(new Invoices(7, "Lamp", 100, 1000.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/08/2020")));
		a.add(new Invoices(8, "Pen", 30, 40.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/09/2020")));
		a.add(new Invoices(9, "Book", 70, 80.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/03/2020")));
		a.add(new Invoices(10, "Table", 50, 70.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/07/2020")));
		a.add(new Invoices(11, "Lamp", 99, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/09/2020")));
		a.add(new Invoices(12, "Pen", 44, 30.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/04/2020")));
		a.add(new Invoices(13, "Book", 77, 22.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
		a.add(new Invoices(14, "Table", 90, 11.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/09/2020")));
		a.add(new Invoices(15, "Lamp", 100, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/11/2020")));

		return a;
	}

	public static void main(String[] args) {
		new CodeSmells().writeExcell();
	}

}