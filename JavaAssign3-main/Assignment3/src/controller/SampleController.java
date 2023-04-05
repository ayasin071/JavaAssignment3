package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toy;
/**
 * 
 * This imports all of the buttons, listviews, radio buttons etc from scene builder
 *
 */

public class SampleController {
    StoreManager sm;
    ArrayList<Toy> selectedToys;
    int SelectedIndex = 0;
    @FXML
    private Button btnBuy;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Button btnSearchRemove;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private ComboBox<?> cbCategory1;

    @FXML
    private ListView<String> lvHome;
    @FXML
    private ListView<String> lvRemove;

    @FXML
    private ToggleGroup rb1;

    @FXML
    private RadioButton rbName;

    @FXML
    private RadioButton rbSerNum;

    @FXML
    private RadioButton rbType;

    @FXML
    private Tab tabAddToy;

    @FXML
    private Tab tabHome;

    @FXML
    private Tab tabRemToy;

    @FXML
    private TextField tfAgeAppr;

    @FXML
    private TextField tfAvailCount;

    @FXML
    private TextField tfBrand;

    @FXML
    private TextField tfClass;

    @FXML
    private TextField tfDesigner;

    @FXML
    private TextField tfMaterial;

    @FXML
    private TextField tfMaxPlayers;

    @FXML
    private TextField tfMinPlayers;

    @FXML
    private TextField tfNameSearch;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfSN;

    @FXML
    private TextField tfSerNum;
    
    @FXML
    private TextField tfType;
    
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSN1;

    @FXML
    private TextField tfSerNumSearch;

    @FXML
    private TextField tfSize;

    @FXML
    private TextField tfTypeSearch;

    @FXML
    private Text txtAgeAppr;

    @FXML
    private Text txtAnimal;

    @FXML
    private Text txtAvailCount;

    @FXML
    private Text txtBoardGame;

    @FXML
    private Text txtBrand;

    @FXML
    private Text txtCategory;

    @FXML
    private Text txtClass;

    @FXML
    private Text txtDesigner;

    @FXML
    private Text txtEnter;

    @FXML
    private Text txtEnterSN;

    @FXML
    private Text txtFig;

    @FXML
    private Text txtMaterial;

    @FXML
    private Text txtMaxPlayers;

    @FXML
    private Text txtMinPlayers;

    @FXML
    private Text txtName;

    @FXML
    private Text txtPrice;

    @FXML
    private Text txtPuzzle;

    @FXML
    private Text txtSN;

    @FXML
    private Text txtSN1;

    @FXML
    private Text txtSearch;

    @FXML
    private Text txtSerNun;

    @FXML
    private Text txtSize;

    @FXML
    private Text txtType;
    
    @FXML
    ComboBox<String> cbCategory = new ComboBox<>();
    @FXML
    void initialize(){
        cbCategory.getItems().addAll("Figure", "Animals", "Puzzle", "Board Game");
    }
    public SampleController(){
        
        try {
            sm = new StoreManager();
            sm.loadData();
        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();
    
        }
        
        
    }
    /**
     * Handles the Buy button in the GUI.
     *
     * @param event The ActionEvent object representing the user's click on the button.
     */
    @FXML
    void btnBuyHandler(ActionEvent event) {
        Toy selecteedToy = selectedToys.get(SelectedIndex);
        sm.purchaseToy(selecteedToy);
        sm.Save();
        lvHome.getItems().add("purchase complete");
    }
     /**
     * Handles the Clear button in the GUI.
     *
     * @param event The ActionEvent object representing the user's click on the button.
     */
    @FXML
    void btnClearHandler(ActionEvent event) {
        lvHome.getItems().clear();
        tfNameSearch.setText("");
        tfSerNumSearch.setText("");
        tfTypeSearch.setText("");
    }
    /**
     * Handles the Remove button in the GUI.
     *
     * @param event The ActionEvent object representing the user's click on the button.
     */
    @FXML
    void btnRemoveHandler(ActionEvent event) {
        String sn = tfSN1.getText();
        sm.removeAToy(sn);
            sm.Save();
            lvRemove.getItems().add("Item Removed");
    }
     /**
     * This method is a handler for the button click event that occurs when the user clicks the "Save" button. 
     * The method retrieves the values entered by the user in various text fields, converts them to the appropriate data type, and creates a new "Toy" object based on the entered values
     * This is when the user chooses the Figure option
     */

    @FXML
    void btnSaveHandler(ActionEvent event) {

        String category = cbCategory.getValue();
        if (category == "Figure"){
            String sn = tfSN.getText();
            String name = tfName.getText();
            String brand = tfBrand.getText();
            String priceStr = tfPrice.getText();
            Double price = Double.parseDouble(priceStr);
            String avalablecountStr = tfAvailCount.getText();
            Integer avalablecount = Integer.parseInt(avalablecountStr);
            String ageappropriateStr = tfAgeAppr.getText();
            Integer ageappropriate = Integer.parseInt(ageappropriateStr);
            String classification = tfClass.getText();
            Toy t = new Figures(sn, name, brand, price , avalablecount, ageappropriate, classification);
            sm.addNewToy(t);
        }
         /**
         * This method is a handler for the button click event that occurs when the user clicks the "Save" button. 
         * The method retrieves the values entered by the user in various text fields, converts them to the appropriate data type, and creates a new "Toy" object based on the entered values
         * This is when the user chooses the Animals option
         */
        if (category == "Animals"){
            String sn = tfSN.getText();
            String name = tfName.getText();
            String brand = tfBrand.getText();
            String priceStr = tfPrice.getText();
            Double price = Double.parseDouble(priceStr);
            String avalablecountStr = tfAvailCount.getText();
            Integer avalablecount = Integer.parseInt(avalablecountStr);
            String ageappropriateStr = tfAgeAppr.getText();
            Integer ageappropriate = Integer.parseInt(ageappropriateStr);
            String material = tfMaterial.getText();
            String size = tfSize.getText();
            Toy t = new Animals(sn, name, brand, price , avalablecount, ageappropriate, material, size);
            sm.addNewToy(t);
        }
        /**
         * This method is a handler for the button click event that occurs when the user clicks the "Save" button. 
         * The method retrieves the values entered by the user in various text fields, converts them to the appropriate data type, and creates a new "Toy" object based on the entered values
         * This is when the user chooses the Puzzle option
          */
        if (category == "Puzzle"){
            String sn = tfSN.getText();
            String name = tfName.getText();
            String brand = tfBrand.getText();
            String priceStr = tfPrice.getText();
            Double price = Double.parseDouble(priceStr);
            String avalablecountStr = tfAvailCount.getText();
            Integer avalablecount = Integer.parseInt(avalablecountStr);
            String ageappropriateStr = tfAgeAppr.getText();
            Integer ageappropriate = Integer.parseInt(ageappropriateStr);
            String ptype = tfType.getText();
            Toy t = new Puzzles(sn, name, brand, price , avalablecount, ageappropriate, ptype);
            sm.addNewToy(t);
        }
        if (category == "Board Game"){
            String sn = tfSN.getText();
            String name = tfName.getText();
            String brand = tfBrand.getText();
            String priceStr = tfPrice.getText();
            Double price = Double.parseDouble(priceStr);
            String avalablecountStr = tfAvailCount.getText();
            Integer avalablecount = Integer.parseInt(avalablecountStr);
            String ageappropriateStr = tfAgeAppr.getText();
            Integer ageappropriate = Integer.parseInt(ageappropriateStr);
            String maxStr = tfMaxPlayers.getText();
            Integer max = Integer.parseInt(maxStr);
            String minStr = tfMinPlayers.getText();
            Integer min = Integer.parseInt(minStr);
            String designer = tfDesigner.getText();
            Toy t = new BoardGames(sn, name, brand, price , avalablecount, ageappropriate, max, min, designer );
            sm.addNewToy(t);
        }
        sm.Save();
    }
    /**
    * This method is the event handler for a button that searches for toys based on the selected search criteria.
    * The method clears the items in a ListView component (lvHome) and then adds the formatted string representation of each Toy object in the ArrayList to the ListView (using a for loop to iterate through the ArrayList).
    */
    /**
    Handles the search button click event.
    Searches for toys based on the selected search criteria and adds them to the GUI list.
    If no search criteria is selected, no toys will be displayed.
    @param event The ActionEvent object representing the search button click event.
    */

    @FXML
    void btnSearchHandler(ActionEvent event) {
        if (rbName.isSelected()){
            String name = tfNameSearch.getText();
            selectedToys = sm.searchByName(name);
        }else if 
        (rbSerNum.isSelected()){
            String SN = tfSerNumSearch.getText();
            selectedToys = sm.getToyBySerialNumber(SN);
        }else{
            String type = tfTypeSearch.getText();
            selectedToys = sm.ByType(type);
        }
        // adding toys to GUI list 
        lvHome.getItems().clear();
        for(int n=0; n<selectedToys.size(); n++){
			String s = String.format("(%d) %s\n",n +1 , selectedToys.get(n).formatToScreen());
            lvHome.getItems().add(s);
		}
    }
    /**
    Handles the name radio button click event.
    This method does not contain any implementation as it only needs to be triggered when the radio button is selected.
    @param event The ActionEvent object representing the name radio button click event.
    */
    // Handles the name radio button
    @FXML
    void rbNameHandler(ActionEvent event) {
        
    }
    /**
    Handles the serial number radio button click event.
    This method does not contain any implementation as it only needs to be triggered when the radio button is selected.
    @param event The ActionEvent object representing the serial number radio button click event.
    */
     // Handles the serial number radio button
    @FXML
    void rbSerHandler(ActionEvent event) {
        
    }
    /**
    Handles the toy type radio button click event.
    This method does not contain any implementation as it only needs to be triggered when the radio button is selected.
    @param event The ActionEvent object representing the toy type radio button click event.
    */
    // Handles the toy type radio button
    @FXML
    void rbTypeHandler(ActionEvent event) {
      
    }
    /**
    Stores the index of the selected item in the SelectedIndex variable.
    @param event The MouseEvent object representing the list view click event.
    */
    // Handles clicking on an item in the GUI list
    @FXML
    void lvHomeClickHandler(MouseEvent event) {
        SelectedIndex = lvHome.getSelectionModel().getSelectedIndex();	

    }
    /**
    Handles the remove button click event.
    Searches for toys based on the provided serial number and displays them in the remove list view.
    @param event The ActionEvent object representing the remove button click event.
    */
    // Handles the remove button
    @FXML
    void btnSearchRemoveHandler(ActionEvent event) {
        String SN = tfSN1.getText();
        selectedToys = sm.getToyBySerialNumber(SN);
        lvRemove.getItems().clear();
        for(int n=0; n<selectedToys.size(); n++){
			String s = String.format("(%d) %s\n",n +1 , selectedToys.get(n).formatToScreen());
            lvRemove.getItems().add(s);
		}
    }

}

