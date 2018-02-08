/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.FileOutputStream;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class ManagedBeanPrimefaces implements Serializable {

    String so_ = System.getProperty("os.name");
    String ruta_temporal = "";

    public void handleFileUpload(FileUploadEvent event) {
        if (so_.equalsIgnoreCase("linux")) {
            ruta_temporal = "/tmp/";
        } else {
            ruta_temporal = "C:/Windows/Temp/";
        }
        UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        byte[] contents = uploadedFile.getContents();
        try {
            FileOutputStream fos = new FileOutputStream(ruta_temporal + fileName.replace(" ", ""));
            fos.write(contents);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FacesMessage message = new FacesMessage("CARGA CORRECTA", event.getFile().getFileName() + " cargado al sistema");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
