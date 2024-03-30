
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.stage.Screen;
import javafx.stage.Stage;


public class Driver extends Application {
	
	static RentVehicleSystem vehicleRental = new RentVehicleSystem();

    @Override
    public void start(Stage primaryStage) throws Exception {
    	loadData(primaryStage);
    	Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
         
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ main pages ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    	BorderPane mainPagePane = new BorderPane();
        Scene mainPage = new Scene(mainPagePane,screenSize.getWidth(), screenSize.getHeight());  //creating scene with same screen size for every page
        BorderPane cusPane = new BorderPane();
        Scene customerPage = new Scene(cusPane,screenSize.getWidth(), screenSize.getHeight());
        BorderPane delCusPane = new BorderPane();
        Scene delCusPage = new Scene(delCusPane,screenSize.getWidth(),screenSize.getHeight());
        BorderPane addCusPane = new BorderPane();
        Scene addCusPage = new Scene(addCusPane,screenSize.getWidth(),screenSize.getHeight());
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ main page ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      //borderpane layout and adding it to the scene
        mainPagePane.setPadding(new Insets(25,40,25,40));
        mainPage.getStylesheets().add("mainPageStyle.css");

        //Name logo for the main page
        Image nameLogo  = new Image("f51724e22f46f84eb2613ba66081e4c1.jpg");
        ImageView nameLogoView = new ImageView(nameLogo);
        nameLogoView.setFitHeight(190);
        nameLogoView.setFitWidth(700);
        mainPagePane.setTop(nameLogoView);
        BorderPane.setAlignment(nameLogoView, Pos.CENTER);


        //Buttons in the homepage
        Button customerB = new Button("Customers");
        Button vehicle = new Button("Vehicle");
        Button rentB = new Button("Rent");

       //adding icons to the buttons
        Image cusIcon = new Image("cusIcon.png");
        ImageView cusIconView = new ImageView(cusIcon);
        cusIconView.setFitHeight(35);
        cusIconView.setFitWidth(35);
        customerB.setGraphic(cusIconView);
        customerB.setGraphicTextGap(15);

        Image vehicleIcon = new Image("vehicle.png");
        ImageView vehicleIconView = new ImageView(vehicleIcon);
        vehicleIconView.setFitWidth(35);
        vehicleIconView.setFitHeight(35);
        vehicle.setGraphic(vehicleIconView);
        vehicle.setGraphicTextGap(15);

        Image rentIcon = new Image("rent.png");
        ImageView rentIconView = new ImageView(rentIcon);
        rentIconView.setFitWidth(35);
        rentIconView.setFitHeight(35);
        rentB.setGraphic(rentIconView);
        rentB.setGraphicTextGap(15);
    
        customerB.setOnAction(e -> primaryStage.setScene(customerPage));  //actions for the buttons
   

        // adding button to a Vbox
        VBox vBox = new VBox();
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(50,50,50,50));
        vBox.getChildren().addAll(customerB,vehicle,rentB);

        //HBox for element in the center of borderpane
        HBox hBox = new HBox();
        mainPagePane.setCenter(hBox);
        hBox.setSpacing(100);
        hBox.setPadding(new Insets(80,50,50,50));
        BorderPane.setAlignment(hBox,Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);

        //adding the vbox of button to the HBox
        hBox.getChildren().add(vBox);

        //exit button
        Button exitB = new Button("EXIT");
        mainPagePane.setBottom(exitB);
        BorderPane.setAlignment(exitB,Pos.CENTER);

        exitB.setOnAction(e -> {    //setting action for the button (lambda expression)
            primaryStage.hide();
            System.exit(0);
        });
        cusPane.setPadding(new Insets(50,50,50,50));
        customerPage.getStylesheets().add("mainPageStyle.css");
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Customer  page ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        //buttons in customer page
        Button cusB1 = new Button("Add New Customer");
        Button cusB2 = new Button("Delete Customer");
        Button cusB3 = new Button("Search a Customer by ID");
        Button cusB4 = new Button("Return to the MainPage");

        VBox cusMenu = new VBox();
        cusMenu.setSpacing(25);
        cusMenu.setPadding(new Insets(30,30,30,30));
        cusMenu.getChildren().addAll(cusB1,cusB2,cusB3,cusB4);
        cusMenu.setAlignment(Pos.CENTER);
        cusPane.setCenter(cusMenu);
        BorderPane.setAlignment(cusMenu,Pos.CENTER);


        

         //Actions for the  buttons
        cusB1.setOnAction(e-> primaryStage.setScene(addCusPage) );
        cusB2.setOnAction(e-> primaryStage.setScene(delCusPage) );
        cusB4.setOnAction(e-> primaryStage.setScene(mainPage));
       
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Customer delete page ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        delCusPane.setPadding(new Insets(50,50,50,50));
        delCusPage.getStylesheets().add("mainPageStyle.css");

        //page labels and textField and toggle group
       Label cusIDLabel_delPage =new Label("Customer ID");
        cusIDLabel_delPage.setAlignment(Pos.CENTER);
        TextField cusIdIn_delPage = new TextField();
        cusIdIn_delPage.setPromptText("Enter Customer ID");
        cusIdIn_delPage.setAlignment(Pos.CENTER);


        Label cusNameLabel_delPage =new Label("Customer Name");
        cusNameLabel_delPage.setAlignment(Pos.CENTER);
        TextField cusNameIn_delPage = new TextField();
        cusNameIn_delPage.setAlignment(Pos.CENTER);
        cusNameIn_delPage.setEditable(false);

        Label cusAddressLabel_delPage =new Label("Customer Address");
        cusAddressLabel_delPage.setAlignment(Pos.CENTER);

        TextField cusAddressIn_delPage = new TextField();
        cusAddressIn_delPage.setAlignment(Pos.CENTER);
        cusAddressIn_delPage.setEditable(false);

        Label cusMobileLabel_delPage =new Label("Customer Mobile");
        cusMobileLabel_delPage.setAlignment(Pos.CENTER);

        TextField cusMobileIn_delPage = new TextField();
        cusMobileIn_delPage.setAlignment(Pos.CENTER);
        cusMobileIn_delPage.setEditable(false);

        Label cusPlanLabel_delPage =new Label("Customer Plan");
        cusPlanLabel_delPage.setAlignment(Pos.CENTER);

        TextField cusPlanIn_delPage = new TextField();
        cusPlanIn_delPage.setAlignment(Pos.CENTER);
        cusPlanIn_delPage.setEditable(false);


        GridPane del_cus_page_gp = new GridPane();

        del_cus_page_gp.add(cusIDLabel_delPage,0,0);
        del_cus_page_gp.add(cusIdIn_delPage,1,0);

        del_cus_page_gp.add(cusNameLabel_delPage,0,1);
        del_cus_page_gp.add(cusNameIn_delPage,1,1);

        del_cus_page_gp.add(cusAddressLabel_delPage,0,2);
        del_cus_page_gp.add(cusAddressIn_delPage,1,2);

        del_cus_page_gp.add(cusMobileLabel_delPage,0,3);
        del_cus_page_gp.add(cusMobileIn_delPage,1,3);

        del_cus_page_gp.add(cusPlanLabel_delPage,0,4);
        del_cus_page_gp.add(cusPlanIn_delPage,1,4);

        delCusPane.setCenter(del_cus_page_gp);

        del_cus_page_gp.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(del_cus_page_gp,Pos.CENTER);
        del_cus_page_gp.setVgap(15);
        del_cus_page_gp.setHgap(50);

        //Back button
        Button backBt_delCusPage = new Button("Back");

        Image backImage_delCusPage = new Image("back.png");
        ImageView backImageView_delCusPage = new ImageView(backImage_delCusPage);
        backImageView_delCusPage.setFitWidth(30);
        backImageView_delCusPage.setFitHeight(30);

        backBt_delCusPage.setGraphic(backImageView_delCusPage);
        backBt_delCusPage.setGraphicTextGap(15);

        //Find button

        Button findBt_delCusPage = new Button("Find");

        Image findImage_delCusPage = new Image("search.png");
        ImageView findImageView_delCusPage = new ImageView(findImage_delCusPage);
       
        findImageView_delCusPage.setFitWidth(30);
        findImageView_delCusPage.setFitHeight(30);

        findBt_delCusPage.setGraphic(findImageView_delCusPage);
        findBt_delCusPage.setGraphicTextGap(15);

        //Delete button

        Button delBt_delCusPage = new Button("Delete");

        Image delImage_delCusPage = new Image("delete.png");
        ImageView delImageView_delCusPage = new ImageView(delImage_delCusPage);
       
        delImageView_delCusPage.setFitWidth(30);
        delImageView_delCusPage.setFitHeight(30);

        delBt_delCusPage.setGraphic(delImageView_delCusPage);
        delBt_delCusPage.setGraphicTextGap(15);


        //Container for the three buttons

        HBox btContainer_delPage = new HBox();
        btContainer_delPage.setAlignment(Pos.CENTER);
        btContainer_delPage.setSpacing(100);
        btContainer_delPage.getChildren().addAll(backBt_delCusPage,findBt_delCusPage,delBt_delCusPage);

        // adding buttons to the Scene (del page)
        delCusPane.setBottom(btContainer_delPage);
        BorderPane.setAlignment(btContainer_delPage,Pos.CENTER);

        //actions for buttons

        backBt_delCusPage.setOnAction(e-> {
           primaryStage.setScene(customerPage);

            cusIdIn_delPage.clear();
            cusNameIn_delPage.clear();
            cusAddressIn_delPage.clear();
            cusMobileIn_delPage.clear();
            cusPlanIn_delPage.clear();

        });

        findBt_delCusPage.setOnAction(e->{
            String id = cusIdIn_delPage.getText().trim();
            int index = searchCusById(id);
            if(index >=0){
                cusNameIn_delPage.setText(vehicleRental.getCustomers().get(index).getName());
                cusAddressIn_delPage.setText(vehicleRental.getCustomers().get(index).getAddress());
                
                cusPlanIn_delPage.setText(vehicleRental.getCustomers().get(index).getPlan());
            }else {
                
            }

            cusIdIn_delPage.setOnKeyTyped(event->{      //clear text field when the id changed after getting the result
                cusNameIn_delPage.clear();
                cusAddressIn_delPage.clear();
                cusMobileIn_delPage.clear();
                cusPlanIn_delPage.clear();
            });

        });

        delBt_delCusPage.setOnAction(e->{
            String id = cusIdIn_delPage.getText().trim();
            int index = searchCusById(id);
            if (index >=0){
                for (int i = 0; i < vehicleRental.getCustomers().get(index).getRentedVehicleList().size() ; i++) {
                	vehicleRental.returnVehicle(id,vehicleRental.getCustomers().get(index).getRentedVehicleList().get(i));
                }
                vehicleRental.getCustomers().remove(index);
                cusIdIn_delPage.clear();
                cusNameIn_delPage.clear();
                cusAddressIn_delPage.clear();
                cusMobileIn_delPage.clear();
                cusPlanIn_delPage.clear();

                updateAndSaveCustomer();
             

            }

        });
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Customer add page ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        addCusPane.setPadding(new Insets(50,50,50,50));
        addCusPage.getStylesheets().add("mainPageStyle.css");


        //page labels and textField and toggle group
        Label cusIDLabel_addPage =new Label("Customer ID");
        cusIDLabel_addPage.setAlignment(Pos.CENTER);
        TextField cusIdIn_addPage = new TextField();
        cusIdIn_addPage.setPromptText("Enter Customer ID");
        cusIdIn_addPage.setAlignment(Pos.CENTER);


        Label cusNameLabel_addPage =new Label("Customer Name");
        cusNameLabel_addPage.setAlignment(Pos.CENTER);
        TextField cusNameIn_addPage = new TextField();
        cusNameIn_addPage.setPromptText(" Customer Name");
        cusNameIn_addPage.setAlignment(Pos.CENTER);
        cusNameIn_addPage.setDisable(true);

        Label cusAddressLabel_addPage =new Label(" Address");
        cusAddressLabel_addPage.setAlignment(Pos.CENTER);

        TextField cusAddressIn_addPage = new TextField();
        cusAddressIn_addPage.setPromptText("Enter Customer Address");
        cusAddressIn_addPage.setAlignment(Pos.CENTER);
        cusAddressIn_addPage.setDisable(true);

        Label cusMobileLabel_addPage =new Label(" Mobile Number");
        cusMobileLabel_addPage.setAlignment(Pos.CENTER);

        TextField cusMobileIn_addPage = new TextField();
        cusMobileIn_addPage.setPromptText("Enter Customer Mobile Number");
        cusMobileIn_addPage.setAlignment(Pos.CENTER);
        cusMobileIn_addPage.setDisable(true);

        //label for the plan
        Label planSettingLabel = new Label("Plan : ");
        planSettingLabel.setAlignment(Pos.CENTER);
        //toggle group for the plan (2 radio buttons)

        ToggleGroup planSettings = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Limited");
        rb1.setToggleGroup(planSettings);
        rb1.setDisable(true);

        RadioButton rb2 = new RadioButton("Unlimited");
        rb2.setToggleGroup(planSettings);
        rb2.setDisable(true);

        HBox rBContainer = new HBox();
        rBContainer.setAlignment(Pos.CENTER);
        rBContainer.setSpacing(30);
        rBContainer.getChildren().addAll(rb1,rb2);


        //grid pane for the textField and labels
        GridPane add_cus_page_gp = new GridPane();

        add_cus_page_gp.add(cusIDLabel_addPage,0,0);
        add_cus_page_gp.add(cusIdIn_addPage,1,0);

        add_cus_page_gp.add(cusNameLabel_addPage,0,1);
        add_cus_page_gp.add(cusNameIn_addPage,1,1);

        add_cus_page_gp.add(cusAddressLabel_addPage,0,2);
        add_cus_page_gp.add(cusAddressIn_addPage,1,2);

        add_cus_page_gp.add(cusMobileLabel_addPage,0,3);
        add_cus_page_gp.add(cusMobileIn_addPage,1,3);

        add_cus_page_gp.add(planSettingLabel,0,4);
        add_cus_page_gp.add(rBContainer,1,4);

        addCusPane.setCenter(add_cus_page_gp);

        add_cus_page_gp.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(add_cus_page_gp,Pos.CENTER);
        add_cus_page_gp.setVgap(15);
        add_cus_page_gp.setHgap(50);

        //for enabling textField when the previous text is written correctly

        cusIdIn_addPage.setOnKeyReleased(e-> cusNameIn_addPage.setDisable(cusIdIn_addPage.getText().trim().isEmpty() || !cusIdIn_addPage.getText().trim().matches("[0-9]+")));

        cusNameIn_addPage.setOnKeyReleased(e-> cusAddressIn_addPage.setDisable(cusNameIn_addPage.getText().trim().isEmpty() || cusNameIn_addPage.getText().matches(".*\\d.*")));

        cusAddressIn_addPage.setOnKeyReleased(e->cusMobileIn_addPage.setDisable(cusAddressIn_addPage.getText().trim().isEmpty()) );

        cusMobileIn_addPage.setOnKeyReleased(e-> {
            if (!cusMobileIn_addPage.getText().trim().isEmpty() && cusMobileIn_addPage.getText().trim().matches("[0-9]+")){
                rb1.setDisable(false);
                rb2.setDisable(false);
            }else {
                rb1.setDisable(true);
                rb2.setDisable(true);
            }
        }  );

        //add and Back buttons
        Button backBt_addCusPage = new Button("Back");

        Image backImage_addCusPage = new Image("back.png");
        ImageView backImageView_addCusPage = new ImageView(backImage_addCusPage);
        backImageView_addCusPage.setFitWidth(30);
        backImageView_addCusPage.setFitHeight(30);

        backBt_addCusPage.setGraphic(backImageView_addCusPage);
        backBt_addCusPage.setGraphicTextGap(15);

        Button addBT_addCusPage = new Button("Add");
        Image addImage_addCusPage = new Image("plus.png");
        ImageView addImageView_addCusPage = new ImageView(addImage_addCusPage);
       
        addImageView_addCusPage.setFitWidth(30);
        addImageView_addCusPage.setFitHeight(30);

        addBT_addCusPage.setGraphic(addImageView_addCusPage);
        addBT_addCusPage.setGraphicTextGap(15);

        HBox backAddContainer_addCusPage = new HBox();
        backAddContainer_addCusPage.setAlignment(Pos.CENTER);
        backAddContainer_addCusPage.setSpacing(100);
        backAddContainer_addCusPage.getChildren().addAll(backBt_addCusPage,addBT_addCusPage);

        addCusPane.setBottom(backAddContainer_addCusPage);
        BorderPane.setAlignment(backAddContainer_addCusPage,Pos.CENTER);

        //buttons action
        backBt_addCusPage.setOnAction(e-> {
            primaryStage.setScene(customerPage);

            rb1.setSelected(false);      //reset the text field and buttons
            rb2.setSelected(false);
            cusIdIn_addPage.clear();
            cusNameIn_addPage.clear();
            cusAddressIn_addPage.clear();
            cusMobileIn_addPage.clear();
            rb1.setDisable(true);
            rb2.setDisable(true);
            cusNameIn_addPage.setDisable(true);
            cusAddressIn_addPage.setDisable(true);
            cusMobileIn_addPage.setDisable(true);

        });

        addBT_addCusPage.setOnAction(e->{
            if(cusIdIn_addPage.getText().trim().matches("[0-9]+") && !cusNameIn_addPage.getText().matches(".*\\d.*") && cusMobileIn_addPage.getText().trim().matches("[0-9]+") ){
                String id = cusIdIn_addPage.getText();
                String name = cusNameIn_addPage.getText();
                String address = cusAddressIn_addPage.getText();
              

                String plan;
                if (rb1.isSelected()){
                    plan = "limited";
                }else {
                    plan = "unlimited";
                }

                try{
                    vehicleRental.addCustomer(id,name,address,plan);
                
                    updateAndSaveCustomer();
                    

                }catch (Exception exception){
                  
                  
                }
            }else {
               
            }

        });

        cusIdIn_addPage.setOnKeyTyped(event->{      //clear text field when the id changed after getting the result
            cusNameIn_addPage.clear();
            cusNameIn_addPage.setDisable(true);
            cusAddressIn_addPage.clear();
            cusAddressIn_addPage.setDisable(true);
            cusMobileIn_addPage.clear();
            cusMobileIn_addPage.setDisable(true);
            rb1.setSelected(false);
            rb1.setDisable(true);
            rb2.setSelected(false);
            rb2.setDisable(true);
        });
        cusNameIn_addPage.setOnKeyTyped(event -> {

            if(!(cusIdIn_addPage.getText().trim().matches("[0-9]+") && !cusNameIn_addPage.getText().matches(".*\\d.*"))) {
                cusAddressIn_addPage.clear();
                cusAddressIn_addPage.setDisable(true);
                cusMobileIn_addPage.clear();
                cusMobileIn_addPage.setDisable(true);
                rb1.setSelected(false);
                rb1.setDisable(true);
                rb2.setSelected(false);
                rb2.setDisable(true);
            }
        });


        cusMobileIn_addPage.setOnKeyTyped(event -> {

            if(!(cusIdIn_addPage.getText().trim().matches("[0-9]+") && !cusNameIn_addPage.getText().matches(".*\\d.*")&& cusMobileIn_addPage.getText().trim().matches("[0-9]+"))) {
                rb1.setSelected(false);
                rb1.setDisable(true);
                rb2.setSelected(false);
                rb2.setDisable(true);
            }
        });  //done


        primaryStage.setScene(mainPage);

        primaryStage.show();
    }
       
    private static void loadData( Stage primaryStage){
        try {
            File cusInput = new File("CustomerDB.txt");
            Scanner cusReader = new Scanner(cusInput);
            while (cusReader.hasNextLine() ){
                String[] cus = cusReader.nextLine().split(":");
                if(cus.length == 5){
                    vehicleRental.addCustomer(cus[0],cus[1],cus[3],cus[4]);
                    
                }
            }
            cusReader.close();
            } catch (FileNotFoundException e) {
              
            }
        }    
    private static void updateAndSaveCustomer(){
        try {
            File customer = new File("CustomerDB.txt");
            PrintWriter printWriter = new PrintWriter(customer);
            for (int i = 0; i < vehicleRental.getCustomers().size(); i++) {
                printWriter.println(vehicleRental.getCustomers().get(i).getId()+":"+vehicleRental.getCustomers().get(i).getName()+":"+vehicleRental.getCustomers().get(i).getAddress()+":"+vehicleRental.getCustomers().get(i).getPlan());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }      //done
    

    

    public static int searchCusById(String id){     //find the customer and return index
        for (int i = 0; i < vehicleRental.getCustomers().size(); i++) {
            if (id.trim().equalsIgnoreCase(vehicleRental.getCustomers().get(i).getId().trim()))
                return i;
        }
        return -1;
    }
	
    public static void main(String[] args) {
        launch(args);
    }}