/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import clases.ReciboSuma;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import componentes.ReciboFacadeLocal;
import java.io.File;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class ManagedBeanReportes implements Serializable {

    @EJB
    private ReciboFacadeLocal reciboFacade;

    public static final String ruta_archivo = "c:/data/reporte.pdf";

    public ManagedBeanReportes() {
    }

    public void creaPDF() {
        try {
             File archivo = new File(ruta_archivo);
            archivo.getParentFile().mkdir();

            PdfWriter writer = new PdfWriter(ruta_archivo);
            PdfDocument pdf_fichero = new PdfDocument(writer);
            Document documento = new Document(pdf_fichero);
            //documento.add(new Paragraph("Saludos Desde PiensaenJava"));
            PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
            Text titulo = new Text("REPORTE CONSOLIDADO").setFont(font).setFontSize(25);
            Paragraph p = new Paragraph().add(titulo).setTextAlignment(TextAlignment.CENTER);
            documento.add(p);
            
            float[] anchoColumnas ={1.5f,2.1f,1.2f};
            Table tabla = new Table(anchoColumnas);
            tabla.setWidthPercent(100);
            
            PdfFont f = PdfFontFactory.createFont(FontConstants.HELVETICA);
            tabla.addCell(new Cell().setFont(f).setTextAlignment(TextAlignment.CENTER).add("COLUMNA 01"));
            tabla.addCell(new Cell().setFont(f).setTextAlignment(TextAlignment.CENTER).add("COLUMNA 02"));
            tabla.addCell(new Cell().setFont(f).setTextAlignment(TextAlignment.CENTER).add("COLUMNA 03"));
            
            for(ReciboSuma rs :reciboFacade.lista_mes()){
           
            tabla.addCell(new Cell().setFont(f).setTextAlignment(TextAlignment.CENTER).add(""));
            tabla.addCell(new Cell().setFont(f).setTextAlignment(TextAlignment.CENTER).add(String.valueOf(rs.getNum_mes())));
            tabla.addCell(new Cell().setFont(f).setTextAlignment(TextAlignment.CENTER).add(String.valueOf(rs.getCantidad())));
           
            }
            documento.add(tabla);
            
            
            documento.close();

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
