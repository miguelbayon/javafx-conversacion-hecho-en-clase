import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;



public class Conversacion extends Application
{
  public static void main(String[] args){
    launch(args);
  }
  
  @Override
  public void start(Stage escenario)
  {
    VBox contenedorVertical = new VBox();
       
  	HBox contenedorNombre = new HBox();	
    Label labelNombre = new Label("Nombre:");
  	TextField campoNombre = new TextField();
    
    contenedorNombre.getChildren().add(labelNombre);
    contenedorNombre.getChildren().add(campoNombre);  
    
    contenedorVertical.getChildren().add(contenedorNombre);
    
    Label etiquetaComentario = new Label("Comentario");
    TextArea campoComentario = new TextArea();
    
    contenedorVertical.getChildren().add(etiquetaComentario);
    contenedorVertical.getChildren().add(campoComentario);
    
    Button botonEnviar = new Button("Enviar");
    contenedorVertical.getChildren().add(botonEnviar);
    
    botonEnviar.setOnAction(event -> {
    	if(!campoNombre.getText().isEmpty() && !campoComentario.getText().isEmpty())
        {
          Comentario comentario = new Comentario(campoNombre.getText(), campoComentario.getText());
          Label nombreEtiqueta = new Label("Nombre: " + comentario.getNombre());
          Label comentarioEtiqueta = new Label("Comentario: " + comentario.getComentario());
          contenedorVertical.getChildren().add(nombreEtiqueta);
          contenedorVertical.getChildren().add(comentarioEtiqueta);          
        }
    });
    
    Scene escena = new Scene(contenedorVertical, 500, 500);
    
    escenario.setScene(escena);
    escenario.show();
  }
  
}