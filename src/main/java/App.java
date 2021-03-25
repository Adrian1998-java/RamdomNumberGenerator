
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application
{
	private MainController mainController;
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		mainController = new MainController();
		
		Scene scene = new Scene(mainController.getView());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ramdom Number Generator");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("/images/logo_32_32px.png"));
		
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
