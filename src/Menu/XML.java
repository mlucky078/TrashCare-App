package Menu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class XML {

 public static <T> ObservableList<T> readXML(String namaFile, Class<T> dataClass) {

    ObservableList<T> data = FXCollections.observableArrayList();

    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY); // Tambahkan izin untuk semua tipe
    xstream.allowTypesByWildcard(new String[] {"Menu." + dataClass.getSimpleName()});
    InputStream inputStream = null;
    try {
        inputStream = new FileInputStream(namaFile);

        StringBuilder stringBuilder = new StringBuilder();
        int isi;
        while ((isi = inputStream.read()) != -1) {
            stringBuilder.append((char) isi);
        }
        String xmlData = stringBuilder.toString();
        data = (ObservableList<T>) xstream.fromXML(xmlData);

        return data;
    } catch (IOException e) {
        System.err.println("Gagal membaca file XML: " + e.getMessage());
    } finally {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return data;
}

    public static <T> void writeXML(String namaFile, ObservableList<T> data) {

        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(data);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(namaFile);
            byte[] bytes = xml.getBytes("UTF-8");
            outputStream.write(bytes);
    
        } catch (IOException e) {
            System.err.println("Gagal menulis file XML: " + e.getMessage());
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
