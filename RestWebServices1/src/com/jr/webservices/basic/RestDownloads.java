package com.jr.webservices.basic;

import java.io.File;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/file")
public class RestDownloads {
	
	private static final String FILE_PATH = "C:\\Users\\Dell\\Downloads\\test_text_file.txt";
	 
	@GET
	@Path("/get/text")
	@Produces("text/plain")
	public Response getFile() {
 
		File file = new File(FILE_PATH);
 
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=\"file_from_server.log\"");
		return response.build();
 
	}
	
	
	private static final String IMAGE_FILE_PATH = "C:\\Users\\Dell\\Downloads\\test_image_file.png";
	
	@GET
	@Path("/get/png")
	@Produces("image/png")
	public Response getImageFile() {
 
		File file = new File(IMAGE_FILE_PATH);
 
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=image_from_server.png");
		return response.build();
 
	}
	
	private static final String PDF_FILE_PATH = "C:\\Users\\Dell\\Downloads\\AMXPJ1700F-2014.pdf";
	 
	@GET
	@Path("/get/pdf")
	@Produces("application/pdf")
	public Response getPdfFile() {
 
		File file = new File(PDF_FILE_PATH);
 
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=new-android-book.pdf");
		return response.build();
 
	}
	
	private static final String EXCEL_FILE_PATH = "C:\\Users\\Dell\\Downloads\\TT MAIL 1.xlsx";
	 
	@GET
	@Path("/get/excel")
	@Produces("application/vnd.ms-excel")
	public Response getExcelFile() {
 
		File file = new File(EXCEL_FILE_PATH);
 
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=new-excel-file.xls");
		return response.build();
 
	}
 

}
