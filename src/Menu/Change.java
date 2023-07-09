package Menu;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class Change {
   private Pane halaman;

    public Pane getPane(String FileName){

        try {

            URL filePage = Menu.class.getResource("/Update/"+FileName+".fxml");

            if(filePage == null){
                throw new java.io.FileNotFoundException("sesuai.");

            } 

            halaman = new FXMLLoader().load(filePage);
 
        } catch (Exception e) {
            System.out.println("Salah.");
        }
        return halaman;
    }
}
