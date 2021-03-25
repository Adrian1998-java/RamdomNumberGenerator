
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	// Value of spinner total
	SpinnerValueFactory<Integer> totalNumberSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
	// Value of Spinner max
	SpinnerValueFactory<Integer> maximumNumberSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);

	@FXML
	private BorderPane view;

	@FXML
	private Spinner<Integer> maximunNumber;

	@FXML
	private Spinner<Integer> totalNumber;

	@FXML
	private Button generateButton;

	@FXML
	private ListView<Integer> numberList;

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainController.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		maximunNumber.setValueFactory(maximumNumberSpinner);
		totalNumber.setValueFactory(totalNumberSpinner);
		
		maximunNumber.setEditable(true);
		totalNumber.setEditable(true);
		
		maximunNumber.valueProperty().addListener((o, ov, nv) -> {
			System.out.println("Old Value : "+ ov + "/ New value : "+ nv);
			maximumNumberSpinner.setValue(nv);
		});
		
	}

	public BorderPane getView() {
		return view;
	}

	@FXML
	void onGenerate(ActionEvent event) {
		int i = 0;
		numberList.getItems().clear();

		Integer value = maximumNumberSpinner.getValue();
		double numberDouble;
		while(i < totalNumber.getValue())
		{
			numberDouble = Math.random()* value + 1;
			numberList.getItems().add((int) numberDouble);
			i++;
		}
	}

}
