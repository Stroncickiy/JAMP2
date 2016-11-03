package com.epam.spring.pdf;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.epam.spring.model.TimeSpentByUserRecord;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ch.qos.logback.core.util.Duration;

public class SiteUsagePdfCreator {

	public static byte[] createPdf(List<TimeSpentByUserRecord> statisticsByUsers) {

		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			Document document = new Document();
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();

			PdfPTable table = new PdfPTable(2);
			PdfPCell cell;
			cell = new PdfPCell(new Phrase("Time spent on site by users"));
			cell.setColspan(2);
			table.addCell(cell);

			for (TimeSpentByUserRecord timeSpentByUserRecord : statisticsByUsers) {
				table.addCell(timeSpentByUserRecord.getEmail());
				table.addCell(Duration.buildBySeconds(timeSpentByUserRecord.getTimeSpent()).toString());
			}
			document.add(table);

			document.close();
			return byteArrayOutputStream.toByteArray();

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;

	}
}
