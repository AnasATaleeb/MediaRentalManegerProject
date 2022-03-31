package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {
	public static MediaRentalManeger dataBase = new MediaRentalManeger();
	public static String id,mobile,name,address,plan,rating,title,songs,artist,code;
	public static int copiesAvailable,value,chMedia;
	public static double weight;
	public static ArrayList<String> mediaTitle = new ArrayList<>();
	public static ArrayList<String> rentSave = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	Scene welcomeScene,cutomerScene,mediaScene,rentScene;
	@Override
	public void start(Stage primaryStage) {
		try {
		readFile();
		primaryStage.setMaximized(true);
		GridPane gridPane =  new GridPane();
		gridPane.setStyle("-fx-fill-color:red;");

		Image customer = new Image("tt.png");
		ImageView customers =  new ImageView(customer);
		customers.setFitHeight(127);
		customers.setFitWidth(200);
		Button customerButton = new Button("Customer",customers);
		customerButton.setFont(new Font("Times New Roman",30));
		customerButton.setPrefHeight(150);
		customerButton.setPrefWidth(380);
		customerButton.setEffect(new DropShadow());
		butoonEffect(customerButton);

		customerButton.setOnAction(e -> {
			cutomerButtonAction(primaryStage);
		});

		Image media = new Image("mediaa.png");
		ImageView medias =  new ImageView(media);
		medias.setFitHeight(146);
		medias.setFitWidth(160);
		Button mediaButton = new Button(" Media",medias);
		mediaButton.setFont(new Font("Times New Roman",30));
		mediaButton.setPrefHeight(150);
		mediaButton.setPrefWidth(380);
		mediaButton.setEffect(new DropShadow());
		butoonEffect(mediaButton);

		mediaButton.setOnAction(e -> {
			mediaButtonAction(primaryStage);
		});

		Image rent = new Image("Rent.png");
		ImageView rents =  new ImageView(rent);
		rents.setFitHeight(150);
		rents.setFitWidth(150);
		Button rentButton = new Button("Rent",rents); 
		rentButton.setFont(new Font("Times New Roman",30));
		rentButton.setPrefHeight(150);
		rentButton.setPrefWidth(380);
		rentButton.setEffect(new DropShadow());
		butoonEffect(rentButton);

		rentButton.setOnAction(e ->{
			rentButtonAction(primaryStage);
		});

		VBox vbox = new VBox(30, customerButton, mediaButton, rentButton);
		vbox.setPadding(new Insets(80));
		vbox.setAlignment(Pos.CENTER_RIGHT);
		gridPane.add(vbox, 0, 0);
		gridPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Image a = new Image("storeMedia.png");
		ImageView as =  new ImageView(a);
		as.setFitHeight(700);
		as.setFitWidth(750);
		gridPane.add(as, 1, 0);
		gridPane.setAlignment(Pos.CENTER);
		welcomeScene = new Scene(gridPane,1600,800);
		primaryStage.setScene(welcomeScene);
		primaryStage.show();
		}catch (Exception e) {
			System.out.println(e);
		}
	}


	public static void main(String[] args) {
		launch(args);
	}

	private void cutomerButtonAction(Stage primaryStage){
		BorderPane borderPane = new BorderPane();
		Label welcomeCustomer = new Label("Customer Window");
		welcomeCustomer.setFont(new Font("Times New Roman",60));
		welcomeCustomer.setPadding(new Insets(40));
		borderPane.setTop(welcomeCustomer);
		borderPane.setAlignment(welcomeCustomer, Pos.CENTER);

		GridPane gridPaneCustomer = new GridPane();
		Image addCus = new Image("add-customer1.png");
		ImageView addCust =  new ImageView(addCus);
		addCust.setFitHeight(150);
		addCust.setFitWidth(150);
		Button addCustomer = new Button("add Customer",addCust);
		addCustomer.setFont(new Font("Times New Roman",25));
		addCustomer.setPrefHeight(200);
		addCustomer.setPrefWidth(400); 
		addCustomer.setEffect(new DropShadow());
		addCustomer.setStyle("-fx-background-radius: 25");

		addCustomer.setOnAction(e ->{
			addCustomerAction(primaryStage);
		});

		Image removeCus = new Image("remove-cutomer.png");
		ImageView removeCust =  new ImageView(removeCus);
		removeCust.setFitHeight(150);
		removeCust.setFitWidth(150);
		Button deleteCustomer = new Button("delete cutomer",removeCust);
		deleteCustomer.setPrefHeight(200);
		deleteCustomer.setPrefWidth(400);
		deleteCustomer.setFont(new Font("Times New Roman",25));
		deleteCustomer.setEffect(new DropShadow());
		deleteCustomer.setStyle("-fx-background-radius: 25");

		deleteCustomer.setOnAction(e ->{
			deleteCustomerAction(primaryStage);
		});
		Image updateCus = new Image("update-customer.png");
		ImageView updateCust =  new ImageView(updateCus);
		updateCust.setFitHeight(150);
		updateCust.setFitWidth(150);
		Button updateInfo = new Button("Update Information",updateCust);
		updateInfo.setPrefHeight(200);
		updateInfo.setPrefWidth(400);
		updateInfo.setFont(new Font("Times New Roman",25)); 
		updateInfo.setEffect(new DropShadow());
		updateInfo.setStyle("-fx-background-radius: 25");

		updateInfo.setOnAction(e -> {
			updateInfoAboutCustomer(primaryStage);
		});
		Image serchCus = new Image("serch-customer.png");
		ImageView serchCust =  new ImageView(serchCus);
		serchCust.setFitHeight(150);
		serchCust.setFitWidth(150);
		Button serch = new Button("serch a customer",serchCust);
		serch.setPrefHeight(200);
		serch.setPrefWidth(400);
		serch.setFont(new Font("Times New Roman",25)); 
		serch.setEffect(new DropShadow());
		serch.setStyle("-fx-background-radius: 25");

		serch.setOnAction(e ->{
			serchById(primaryStage);
		});

		Image ret = new Image("return.png");
		ImageView retMainPage =  new ImageView(ret);
		retMainPage.setFitHeight(150);
		retMainPage.setFitWidth(150);
		Button back = new Button("Return to main page",retMainPage);
		back.setPrefHeight(200);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(e -> {
			writeFile();
			primaryStage.setScene(welcomeScene);
			primaryStage.show();
		});

		HBox v1 = new HBox(100 , addCustomer , deleteCustomer , updateInfo);
		v1.setAlignment(Pos.CENTER);
		HBox v2 = new HBox(100 , serch , back );
		v2.setAlignment(Pos.CENTER);
		v1.setPadding(new Insets(40));
		v2.setPadding(new Insets(70));
		gridPaneCustomer.add(v1, 0, 0);
		gridPaneCustomer.add(v2, 0, 1);
		gridPaneCustomer.setAlignment(Pos.CENTER_LEFT);

		borderPane.setCenter(gridPaneCustomer);

		borderPane.setPadding(new Insets(30));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");
		cutomerScene = new Scene(borderPane,1600,800);
		primaryStage.setMaximized(true);
		primaryStage.setScene(cutomerScene);
		primaryStage.show();
	}

	private void mediaButtonAction(Stage primaryStage) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label welcome = new Label("Media Window");
		welcome.setFont(new Font("Times New Roman",60));
		welcome.setPadding(new Insets(40));
		borderPane.setTop(welcome);
		borderPane.setAlignment(welcome, Pos.CENTER);


		GridPane gridPane = new GridPane();

		Image addmedia = new Image("add media.png");
		ImageView addmedias =  new ImageView(addmedia);
		addmedias.setFitHeight(150);
		addmedias.setFitWidth(150);
		Button addMedia = new Button("Add Media",addmedias);
		addMedia.setFont(new Font("Times New Roman",25));
		addMedia.setPrefHeight(200);
		addMedia.setPrefWidth(400);
		addMedia.setEffect(new DropShadow());
		addMedia.setStyle("-fx-background-radius: 25");

		addMedia.setOnAction(e ->{
			addMediaAction(primaryStage);
		});

		Image deletemedia = new Image("delete media.png");
		ImageView deletemedias =  new ImageView(deletemedia);
		deletemedias.setFitHeight(150);
		deletemedias.setFitWidth(150);
		Button deleteMedia = new Button("Delete Media",deletemedias);
		deleteMedia.setPrefHeight(200);
		deleteMedia.setPrefWidth(400);
		deleteMedia.setFont(new Font("Times New Roman",25));
		deleteMedia.setEffect(new DropShadow());
		deleteMedia.setStyle("-fx-background-radius: 25");

		deleteMedia.setOnAction(e ->{
			deleteMediaAction(primaryStage);
		});

		Image updatemedia = new Image("updating1.png");
		ImageView updatemedias =  new ImageView(updatemedia);
		updatemedias.setFitHeight(150);
		updatemedias.setFitWidth(150);
		Button updateInfo = new Button("Update Information",updatemedias);
		updateInfo.setPrefHeight(200);
		updateInfo.setPrefWidth(400);
		updateInfo.setFont(new Font("Times New Roman",25)); 
		updateInfo.setEffect(new DropShadow());
		updateInfo.setStyle("-fx-background-radius: 25");

		updateInfo.setOnAction(e ->{
			updateMediaAction(primaryStage);
		});

		Image serchemedia = new Image("serch media.png");
		ImageView serchemedias =  new ImageView(serchemedia);
		serchemedias.setFitHeight(150);
		serchemedias.setFitWidth(150);
		Button serch = new Button("Serch a Media",serchemedias);
		serch.setPrefHeight(200);
		serch.setPrefWidth(400);
		serch.setFont(new Font("Times New Roman",25));
		serch.setEffect(new DropShadow());
		serch.setStyle("-fx-background-radius: 25");

		serch.setOnAction(e ->{
			serchByCode(primaryStage);
		});

		Image printmedia = new Image("printer (1).png");
		ImageView printmedias =  new ImageView(printmedia);
		printmedias.setFitHeight(90);
		printmedias.setFitWidth(90);
		Button printInfo = new Button("Print all media information",printmedias);
		printInfo.setPrefHeight(200);
		printInfo.setPrefWidth(400);
		printInfo.setFont(new Font("Times New Roman",25));
		printInfo.setEffect(new DropShadow());
		printInfo.setStyle("-fx-background-radius: 25");

		printInfo.setOnAction(e ->{
			printAllMediaAction(primaryStage);
		});

		Image ret = new Image("return.png");
		ImageView retMainPage =  new ImageView(ret);
		retMainPage.setFitHeight(150);
		retMainPage.setFitWidth(150); 
		Button back = new Button("Return to main page",retMainPage);
		back.setPrefHeight(200);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(welcomeScene);
			primaryStage.show();
		});

		HBox v1 = new HBox(35 , addMedia , deleteMedia, updateInfo);
		v1.setAlignment(Pos.CENTER);
		HBox v2 = new HBox(35 , serch , printInfo, back );
		v2.setAlignment(Pos.CENTER);
		v1.setPadding(new Insets(20));
		v2.setPadding(new Insets(50));
		gridPane.add(v1, 0, 0);
		gridPane.add(v2, 0, 1);
		gridPane.setAlignment(Pos.CENTER);

		borderPane.setCenter(gridPane);
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		mediaScene= new Scene(borderPane,1600,800);
		primaryStage.setScene(mediaScene);
		primaryStage.show();

	}

	private void printAllMediaAction(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label media = new Label("Print All Media Informtation");
		media.setFont(new Font("Times New Roman",35));
		media.setPadding(new Insets(15));

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		Label mInfo = new Label("All\nMedia's\nInformation :\n ");
		mInfo.setFont(new Font("Times New Roman",30));
		TextArea  tInfo = new TextArea();
		tInfo.setMaxHeight(482.5);
		tInfo.setMaxWidth(860);

		mInfo.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 170;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		tInfo.setStyle("-fx-border-radius: 0 0 0 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;");	

		HBox cInfoBox = new HBox();

		cInfoBox.getChildren().addAll(mInfo,tInfo);
		cInfoBox.setAlignment(Pos.CENTER);

		borderPane.setCenter(cInfoBox);
		borderPane.setAlignment(cInfoBox, Pos.CENTER_LEFT);


		Image pri = new Image("printer.png");
		ImageView prin =  new ImageView(pri);
		prin.setFitHeight(90);
		prin.setFitWidth(90);
		Button print = new Button(" Print Media",prin);
		print.setFont(new Font("Times New Roman",25));
		print.setPrefHeight(100);
		print.setPrefWidth(300);
		print.setEffect(new DropShadow());
		print.setStyle("-fx-background-radius: 25");

		print.setOnAction(e ->{
			tInfo.setText(dataBase.getAllMediaInfo());
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(100, print, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);

		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene printMedia = new Scene(borderPane,1600,800);
		primaryStage.setScene(printMedia);
		primaryStage.show();

	}


	private void serchByCode(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label media = new Label("Serch Media By Code ");
		media.setFont(new Font("Times New Roman",35));
		media.setPadding(new Insets(15));

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		Label mCode = new Label("   Code :                                                 ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		TextField tCode = new TextField();
		tCode.setMinHeight(70);
		tCode.setMinWidth(860);		
		IconedTextFieled(mCode, tCode);

		Label mInfo = new Label("Media\nInformation : ");
		mInfo.setFont(new Font("Times New Roman",30));
		TextArea  tInfo = new TextArea();
		tInfo.setMaxHeight(410);
		tInfo.setMaxWidth(860);

		mInfo.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 170;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		tInfo.setStyle("-fx-border-radius: 0 0 0 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;");	

		HBox cIdBox = new HBox();
		HBox cInfoBox = new HBox();
		cIdBox.getChildren().addAll(mCode,tCode);
		cIdBox.setAlignment(Pos.CENTER);


		cInfoBox.getChildren().addAll(mInfo,tInfo);
		cInfoBox.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,cIdBox,cInfoBox);
		inf.setAlignment(Pos.CENTER);
		inf.setPadding(new Insets(5));
		borderPane.setCenter(inf);
		borderPane.setAlignment(inf, Pos.CENTER_LEFT);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button serch = new Button("Serch Media",fin);
		serch.setFont(new Font("Times New Roman",25));
		serch.setPrefHeight(100);
		serch.setPrefWidth(300);
		serch.setEffect(new DropShadow());
		serch.setStyle("-fx-background-radius: 25");

		serch.setOnAction(e ->{
			for (int i = 0; i < dataBase.getMedia().size(); i++) {
				if(dataBase.getMedia().get(i).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(i) instanceof Movie ) {
						tInfo.setText("Code : " +dataBase.getMedia().get(i).getCode() +"\n"
								+ "Title :" + dataBase.getMedia().get(i).getTitle()+ "\n"
								+ "Number of copies : "+ dataBase.getMedia().get(i).getNumOfCopies() + "\n"
								+ "Rate : " + ((Movie)dataBase.getMedia().get(i)).getRate() );
					}
					else if(dataBase.getMedia().get(i) instanceof Album ) {
						tInfo.setText("Code : " +dataBase.getMedia().get(i).getCode() +"\n"
								+ "Title : " + dataBase.getMedia().get(i).getTitle()+ "\n"
								+ "Number of copies : "+ dataBase.getMedia().get(i).getNumOfCopies() + "\n"
								+ "Artist : " + ((Album)dataBase.getMedia().get(i)).getArtist() + "\n"
								+ "Songs : " + ((Album)dataBase.getMedia().get(i)).getSongs()+ "\n");
					}
					else if(dataBase.getMedia().get(i) instanceof Game ) {
						tInfo.setText("Code : " +dataBase.getMedia().get(i).getCode() +"\n"
								+ "Title :" + dataBase.getMedia().get(i).getTitle()+ "\n"
								+ "Number of copies : "+ dataBase.getMedia().get(i).getNumOfCopies() + "\n"
								+ "Weight : " + ((Game)dataBase.getMedia().get(i)).getWeight() );
					}
				}
			}

		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(100, serch, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);

		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addToCartScene = new Scene(borderPane,1600,800);
		primaryStage.setScene(addToCartScene);
		primaryStage.show();

	}


	private void updateMediaAction(Stage primaryStage) {
		BorderPane bd = new BorderPane();
		Label media = new Label("Update Media Window");
		media.setFont(new Font("Times New Roman",35));


		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		TextField tCode = new TextField();
		tCode.setMinHeight(70);
		tCode.setMinWidth(860);

		IconedTextFieled(mCode, tCode);

		HBox code = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		find.setOnAction(e ->{
			for (int i = 0; i < dataBase.getMedia().size(); i++) {
				if(dataBase.getMedia().get(i).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(i) instanceof Movie ) {
						updateMovieAction(primaryStage,i);
					}
					else if(dataBase.getMedia().get(i) instanceof Album ) {
						updateAlbumAction(primaryStage,i);
					}
					else if(dataBase.getMedia().get(i) instanceof Game ) {
						updateGameAction(primaryStage,i);
					}
				}
			}
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox box = new HBox(50,find,back);
		box.setAlignment(Pos.CENTER);

		bd.setTop(media);
		bd.setAlignment(media, Pos.CENTER);
		bd.setCenter(code);
		bd.setAlignment(code, Pos.CENTER);
		bd.setBottom(box);
		bd.setAlignment(back, Pos.CENTER);
		bd.setPadding(new Insets(25));
		bd.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addMediaScene = new Scene(bd,1600,800);
		primaryStage.setScene(addMediaScene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}


	private void updateGameAction(Stage primaryStage, int i) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Update Game");
		media.setFont(new Font("Times New Roman",35));

		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label weight = new Label("Weight :                  ");
		weight.setFont(new Font("Times New Roman",30));
		weight.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();
		TextField tWeight = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);
		tWeight.setMinHeight(70);
		tWeight.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);
		IconedTextFieled(weight, tWeight);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		HBox wights = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);
		wights.getChildren().addAll(weight, tWeight);
		wights.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,wights);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		tCode.setText(dataBase.getMedia().get(i).getCode());
		tTitle.setText(dataBase.getMedia().get(i).getTitle());
		tNumOfCopie.setText(""+dataBase.getMedia().get(i).getNumOfCopies());
		tWeight.setText( ((Game)dataBase.getMedia().get(i)).getWeight()+ "");		

		find.setOnAction(e ->{
			for (int j = 0; j < dataBase.getMedia().size(); j++) {
				if(dataBase.getMedia().get(j).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(j) instanceof Movie ) {
						updateMovieAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Album ) {
						updateAlbumAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Game ) {
						updateGameAction(primaryStage,j);
					}
				}
			}
		});

		Image pros = new Image("system-update1.png");
		ImageView pross =  new ImageView(pros);
		pross.setFitHeight(90);
		pross.setFitWidth(90);
		Button updateGame = new Button("Update Game",pross);
		updateGame.setFont(new Font("Times New Roman",25));
		updateGame.setPrefHeight(100);
		updateGame.setPrefWidth(300);
		updateGame.setEffect(new DropShadow());
		updateGame.setStyle("-fx-background-radius: 25");

		updateGame.setOnAction(e ->{
			dataBase.getMedia().get(i).setCode(tCode.getText());
			dataBase.getMedia().get(i).setTitle(tTitle.getText());
			dataBase.getMedia().get(i).setNumOfCopies(Integer.parseInt( tNumOfCopie.getText()));
			((Game)dataBase.getMedia().get(i)).setWeight(Double.parseDouble(tWeight.getText())) ;
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
			tWeight.clear();
		});


		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, find, updateGame, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER); 
		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();		

	}


	private void updateAlbumAction(Stage primaryStage, int i) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Update Album");
		media.setFont(new Font("Times New Roman",35));

		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label artist = new Label("Artist :                     ");
		artist.setFont(new Font("Times New Roman",30));
		artist.setPadding(new Insets(18));
		Label songs = new Label("Songs :                     ");
		songs.setFont(new Font("Times New Roman",30));
		songs.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();
		TextField tArtist = new TextField();
		TextField tSongs = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);
		tArtist.setMinHeight(70);
		tArtist.setMinWidth(860);
		tSongs.setMinHeight(70);
		tSongs.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);
		IconedTextFieled(artist, tArtist);
		IconedTextFieled(songs, tSongs);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		HBox art = new HBox();
		HBox song = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);
		art.getChildren().addAll(artist, tArtist);
		art.setAlignment(Pos.CENTER);
		song.getChildren().addAll(songs, tSongs);
		song.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,art,song);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		tCode.setText(dataBase.getMedia().get(i).getCode());
		tTitle.setText(dataBase.getMedia().get(i).getTitle());
		tNumOfCopie.setText("" + dataBase.getMedia().get(i).getNumOfCopies());
		tArtist.setText(((Album)dataBase.getMedia().get(i)).getArtist());
		tSongs.setText(((Album)dataBase.getMedia().get(i)).getSongs());

		find.setOnAction(e ->{
			for (int j = 0; j < dataBase.getMedia().size(); j++) {
				if(dataBase.getMedia().get(j).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(j) instanceof Movie ) {
						updateMovieAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Album ) {
						updateAlbumAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Game ) {
						updateGameAction(primaryStage,j);
					}
				}
			}
		});

		Image pros = new Image("system-update1.png");
		ImageView pross =  new ImageView(pros);
		pross.setFitHeight(90);
		pross.setFitWidth(90);
		Button updateAlbum = new Button("Update Album",pross);
		updateAlbum.setFont(new Font("Times New Roman",25));
		updateAlbum.setPrefHeight(100);
		updateAlbum.setPrefWidth(300);
		updateAlbum.setEffect(new DropShadow());
		updateAlbum.setStyle("-fx-background-radius: 25");

		updateAlbum.setOnAction(e ->{
			dataBase.getMedia().get(i).setCode(tCode.getText());
			dataBase.getMedia().get(i).setTitle(tTitle.getText());
			dataBase.getMedia().get(i).setNumOfCopies(Integer.parseInt( tNumOfCopie.getText()));
			((Album)dataBase.getMedia().get(i)).setArtist(tArtist.getText());
			((Album)dataBase.getMedia().get(i)).setSongs(tSongs.getText());
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
			tArtist.clear();
			tSongs.clear();
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, find, updateAlbum, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER); 

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);
		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();			

	}


	private void updateMovieAction(Stage primaryStage, int i) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Update Movie");
		media.setFont(new Font("Times New Roman",35));

		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label rate = new Label("Rate :                      ");
		rate.setFont(new Font("Times New Roman",30));
		rate.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);


		RadioButton hr  = new RadioButton("HR");
		RadioButton dr  = new RadioButton("DR");
		RadioButton ac  = new RadioButton("AC");
		ToggleGroup tg = new ToggleGroup();
		hr.setToggleGroup(tg);
		dr.setToggleGroup(tg);
		ac.setToggleGroup(tg);
		hr.setFont(new Font("Times New Roman",25));
		dr.setFont(new Font("Times New Roman",25));
		ac.setFont(new Font("Times New Roman",25));
		HBox rateBox = new HBox(100,hr,dr,ac);
		rateBox.setPrefSize(860, 70);
		rateBox.setAlignment(Pos.CENTER);

		rate.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		rateBox.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");

		HBox theRate = new HBox();
		theRate.getChildren().addAll(rate, rateBox);
		theRate.setAlignment(Pos.CENTER);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,theRate);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		tCode.setText(dataBase.getMedia().get(i).getCode());
		tTitle.setText(dataBase.getMedia().get(i).getTitle());
		tNumOfCopie.setText(Integer.toString(dataBase.getMedia().get(i).getNumOfCopies()));
		if(((Movie)dataBase.getMedia().get(i)).getRate().equalsIgnoreCase("HR")) {
			hr.setSelected(true);
		}
		else if(((Movie)dataBase.getMedia().get(i)).getRate().equalsIgnoreCase("DR")) {
			dr.setSelected(true);
		}
		else if(((Movie)dataBase.getMedia().get(i)).getRate().equalsIgnoreCase("AC")) {
			ac.setSelected(true);
		}


		find.setOnAction(e ->{
			for (int j = 0; j < dataBase.getMedia().size(); j++) {
				if(dataBase.getMedia().get(j).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(j) instanceof Movie ) {
						updateMovieAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Album ) {
						updateAlbumAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Game ) {
						updateGameAction(primaryStage,j);
					}
				}
			}
		});

		Image pros = new Image("system-update1.png");
		ImageView pross =  new ImageView(pros);
		pross.setFitHeight(90);
		pross.setFitWidth(90);
		Button updateGame = new Button("Update Movie",pross);
		updateGame.setFont(new Font("Times New Roman",25));
		updateGame.setPrefHeight(100);
		updateGame.setPrefWidth(300);
		updateGame.setEffect(new DropShadow());
		updateGame.setStyle("-fx-background-radius: 25");

		updateGame.setOnAction(e ->{
			dataBase.getMedia().get(i).setCode(tCode.getText());
			dataBase.getMedia().get(i).setTitle(tTitle.getText());
			dataBase.getMedia().get(i).setNumOfCopies(Integer.parseInt(tNumOfCopie.getText()));

			if(  ((RadioButton) tg.getSelectedToggle()).getText().equalsIgnoreCase("HR") )
				((Movie)dataBase.getMedia().get(i)).setRate("HR");
			else if(  ((RadioButton) tg.getSelectedToggle()).getText().equalsIgnoreCase("DR") )
				((Movie)dataBase.getMedia().get(i)).setRate("DR");
			else if(  ((RadioButton) tg.getSelectedToggle()).getText().equalsIgnoreCase("AC") )
				((Movie)dataBase.getMedia().get(i)).setRate("AC");

			tg.selectToggle(null);
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
		});


		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, find, updateGame, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER); 
		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);
		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();

	}


	private void rentButtonAction(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label welcomeCustomer = new Label("Rent Window");
		welcomeCustomer.setFont(new Font("Times New Roman",60));
		welcomeCustomer.setPadding(new Insets(40));
		borderPane.setTop(welcomeCustomer);
		borderPane.setAlignment(welcomeCustomer, Pos.CENTER);
		GridPane gridPaneRent = new GridPane();

		Image addCart = new Image("add to cart.png");
		ImageView addCarts =  new ImageView(addCart);
		addCarts.setFitHeight(150);
		addCarts.setFitWidth(150);
		Button addToCart = new Button("Add to cart",addCarts);
		addToCart.setFont(new Font("Times New Roman",25));
		addToCart.setPrefHeight(200);
		addToCart.setPrefWidth(400); 
		addToCart.setEffect(new DropShadow());
		addToCart.setStyle("-fx-background-radius: 25");

		addToCart.setOnAction(e ->{
			addToCartAction(primaryStage);
		});

		Image print = new Image("printer 1.png");
		ImageView prints =  new ImageView(print);
		prints.setFitHeight(150);
		prints.setFitWidth(150);
		Button printCart = new Button(" Print Cart",prints);
		printCart.setPrefHeight(200);
		printCart.setPrefWidth(400);
		printCart.setFont(new Font("Times New Roman",25));
		printCart.setEffect(new DropShadow());
		printCart.setStyle("-fx-background-radius: 25");

		printCart.setOnAction(e ->{
			printCartAction(primaryStage);
		});
		Image print1 = new Image("printer (2).png");
		ImageView print1s  =  new ImageView(print1);
		print1s.setFitHeight(150);
		print1s.setFitWidth(150);
		Button printRent = new Button(" Print Rent",print1s);
		printRent.setPrefHeight(200);
		printRent.setPrefWidth(400);
		printRent.setFont(new Font("Times New Roman",25)); 
		printRent.setEffect(new DropShadow());
		printRent.setStyle("-fx-background-radius: 25");

		printRent.setOnAction(e -> {
			printRentAction(primaryStage);
		});

		Image returns = new Image("shopping-cart1.png");
		ImageView returnss =  new ImageView(returns);
		returnss.setFitHeight(150);
		returnss.setFitWidth(150);
		Button returnMedia = new Button("Return Media",returnss);
		returnMedia.setPrefHeight(200);
		returnMedia.setPrefWidth(400);
		returnMedia.setFont(new Font("Times New Roman",25)); 
		returnMedia.setEffect(new DropShadow());
		returnMedia.setStyle("-fx-background-radius: 25");

		returnMedia.setOnAction(e ->{
			returnMediaAction(primaryStage);
		});
		
		Image ret = new Image("return.png");
		ImageView retMainPage =  new ImageView(ret);
		retMainPage.setFitHeight(150);
		retMainPage.setFitWidth(150);
		Button back = new Button("Return to main page",retMainPage);
		back.setPrefHeight(200);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(welcomeScene);
			primaryStage.show();
		});

		HBox v1 = new HBox(80 , addToCart , printCart , printRent);
		v1.setAlignment(Pos.CENTER);
		HBox v2 = new HBox(80 , returnMedia , back );
		v2.setAlignment(Pos.CENTER);
		v1.setPadding(new Insets(40));
		v2.setPadding(new Insets(70));
		gridPaneRent.add(v1, 0, 0);
		gridPaneRent.add(v2, 0, 1);
		gridPaneRent.setAlignment(Pos.CENTER_LEFT);

		borderPane.setCenter(gridPaneRent);

		borderPane.setPadding(new Insets(30));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		rentScene = new Scene(borderPane,1600,800);
		primaryStage.setMaximized(true);
		primaryStage.setScene(rentScene);
		primaryStage.show();
	}

	private void addCustomerAction(Stage primaryStage) {
		primaryStage.setMaximized(true);


		BorderPane borderPane = new BorderPane();
		Label welcome = new Label("Add Customer Window");
		welcome.setFont(new Font("Times New Roman",60));
		welcome.setPadding(new Insets(40));
		borderPane.setTop(welcome);
		borderPane.setAlignment(welcome, Pos.CENTER);

		Label cId = new Label("Customer ID :          ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(18));
		Label cName = new Label("Customer Name :     ");
		cName.setFont(new Font("Times New Roman",30));
		cName.setPadding(new Insets(18));
		Label cAddress = new Label("Customer Address : ");
		cAddress.setFont(new Font("Times New Roman",30));
		cAddress.setPadding(new Insets(18));
		Label cMobile = new Label("Customer Moblie :  ");
		cMobile.setFont(new Font("Times New Roman",30));
		cMobile.setPadding(new Insets(18));

		TextField tId = new TextField();
		TextField tName = new TextField();
		TextField tAddress = new TextField();
		TextField tMobile = new TextField();

		tId.setMinHeight(70);
		tId.setMinWidth(860);
		tName.setMinHeight(70);
		tName.setMinWidth(860);
		tAddress.setMinHeight(70);
		tAddress.setMinWidth(860);
		tMobile.setMinHeight(70);
		tMobile.setMinWidth(860);

		IconedTextFieled(cId, tId);
		IconedTextFieled(cName, tName);
		IconedTextFieled(cAddress, tAddress);
		IconedTextFieled(cMobile, tMobile);

		HBox id = new HBox();
		HBox name = new HBox();
		HBox adders = new HBox();
		HBox mobile = new HBox();
		id.getChildren().addAll(cId, tId);
		id.setAlignment(Pos.CENTER);
		name.getChildren().addAll(cName, tName);
		name.setAlignment(Pos.CENTER);
		adders.getChildren().addAll(cAddress, tAddress);
		adders.setAlignment(Pos.CENTER);
		mobile.getChildren().addAll(cMobile, tMobile);
		mobile.setAlignment(Pos.CENTER);


		RadioButton limit  = new RadioButton("LIMITED");
		RadioButton unlimit  = new RadioButton("UNLIMITED");
		ToggleGroup tg = new ToggleGroup();
		limit.setToggleGroup(tg);
		unlimit.setToggleGroup(tg);
		limit.setFont(new Font("Times New Roman",25));
		unlimit.setFont(new Font("Times New Roman",25));
		HBox planBox = new HBox(100,limit,unlimit);
		limit.setSelected(true);
		planBox.setPrefSize(860, 70);
		planBox.setAlignment(Pos.CENTER);

		Label plan = new Label("Customer Plan :      ");
		plan.setFont(new Font("Times New Roman",30));
		plan.setPadding(new Insets(18));

		plan.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		planBox.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");

		HBox thePlan = new HBox();
		thePlan.getChildren().addAll(plan, planBox);
		thePlan.setAlignment(Pos.CENTER);

		VBox inf = new VBox(30,id,name,adders,mobile,thePlan);
		inf.setAlignment(Pos.CENTER);

		borderPane.setCenter(inf);

		Image addCus = new Image("add-customer1.png");
		ImageView addCust =  new ImageView(addCus);
		addCust.setFitHeight(100);
		addCust.setFitWidth(100);
		Button addCustomer = new Button("Add Customer",addCust);
		addCustomer.setFont(new Font("Times New Roman",25));
		addCustomer.setPrefHeight(100);
		addCustomer.setPrefWidth(400);
		addCustomer.setEffect(new DropShadow());
		addCustomer.setStyle("-fx-background-radius: 25");

		addCustomer.setOnAction(e ->{
			String planSelect = ((RadioButton)tg.getSelectedToggle()).getText();
			dataBase.addCustomer(tId.getText(),tName.getText() , tAddress.getText(), tMobile.getText(),planSelect);
			tg.selectToggle(null);
			tAddress.clear();
			tId.clear();
			tMobile.clear();
			tName.clear();
		});
		Image backCus = new Image("ret-costomer.png");
		ImageView backCust =  new ImageView(backCus);
		backCust.setFitHeight(100);
		backCust.setFitWidth(100);
		Button back = new Button("Return to customer page",backCust);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");
		back.setFont(new Font("Times New Roman",25)); 

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(cutomerScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(35, addCustomer, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void deleteCustomerAction(Stage primaryStage) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label welcome = new Label("Delete Customer Window");
		welcome.setFont(new Font("Times New Roman",60));
		welcome.setPadding(new Insets(18));
		borderPane.setTop(welcome);
		borderPane.setAlignment(welcome, Pos.CENTER);

		Label cId = new Label("Customer ID :          ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(18));
		Label cName = new Label("Customer Name :     ");
		cName.setFont(new Font("Times New Roman",30));
		cName.setPadding(new Insets(18));
		Label cAddress = new Label("Customer Address : ");
		cAddress.setFont(new Font("Times New Roman",30));
		cAddress.setPadding(new Insets(18));
		Label cMobile = new Label("Customer Moblie :  ");
		cMobile.setFont(new Font("Times New Roman",30));
		cMobile.setPadding(new Insets(18));

		TextField tId = new TextField();
		TextField tName = new TextField();
		TextField tAddress = new TextField();
		TextField tMobile = new TextField();

		tName.setEditable(false);
		tAddress.setEditable(false);
		tMobile.setEditable(false);

		tId.setMinHeight(70);
		tId.setMinWidth(860);
		tName.setMinHeight(70);
		tName.setMinWidth(860);
		tAddress.setMinHeight(70);
		tAddress.setMinWidth(860);
		tMobile.setMinHeight(70);
		tMobile.setMinWidth(860);

		IconedTextFieled(cId, tId);
		IconedTextFieled(cName, tName);
		IconedTextFieled(cAddress, tAddress);
		IconedTextFieled(cMobile, tMobile);

		HBox id = new HBox();
		HBox name = new HBox();
		HBox adders = new HBox();
		HBox mobile = new HBox();
		id.getChildren().addAll(cId, tId);
		id.setAlignment(Pos.CENTER);
		name.getChildren().addAll(cName, tName);
		name.setAlignment(Pos.CENTER);
		adders.getChildren().addAll(cAddress, tAddress);
		adders.setAlignment(Pos.CENTER);
		mobile.getChildren().addAll(cMobile, tMobile);
		mobile.setAlignment(Pos.CENTER);

		RadioButton limit  = new RadioButton("LIMITED");
		RadioButton unlimit  = new RadioButton("UNLIMITED");
		ToggleGroup tg = new ToggleGroup();
		limit.setToggleGroup(tg);
		unlimit.setToggleGroup(tg);
		limit.setDisable(true);
		unlimit.setDisable(true);
		limit.setFont(new Font("Times New Roman",25));
		unlimit.setFont(new Font("Times New Roman",25));
		HBox planBox = new HBox(100,limit,unlimit);
		planBox.setPrefSize(860, 70);
		planBox.setAlignment(Pos.CENTER);

		Label plan = new Label("Customer Plan :      ");
		plan.setFont(new Font("Times New Roman",30));
		plan.setPadding(new Insets(18));

		plan.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		planBox.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");

		HBox thePlan = new HBox();
		thePlan.getChildren().addAll(plan, planBox);
		thePlan.setAlignment(Pos.CENTER);

		VBox inf = new VBox(30,id,name,adders,mobile,thePlan);
		inf.setAlignment(Pos.CENTER);

		borderPane.setCenter(inf);

		Image findCus = new Image("find (2).png");
		ImageView findCust =  new ImageView(findCus);
		findCust.setFitHeight(100);
		findCust.setFitWidth(100);
		Button find = new Button("Find Customer",findCust);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		find.setOnAction(e ->{
			Boolean flag = true;
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equalsIgnoreCase(tId.getText()) ){
					flag = false;
					tName.setText(dataBase.getCustomer().get(i).getName());
					tAddress.setText(dataBase.getCustomer().get(i).getAddress());
					tMobile.setText(dataBase.getCustomer().get(i).getMobile());
					if(dataBase.getCustomer().get(i).getPlan().equalsIgnoreCase("Limited"))
						limit.setSelected(true);
					else
						unlimit.setSelected(true);
				}
			}
			if(flag) {
				tg.selectToggle(null);
				tAddress.clear();
				tMobile.clear();
				tName.clear();
				tName.setEditable(false);
				tAddress.setEditable(false);
				tMobile.setEditable(false);
				limit.setDisable(true);
				unlimit.setDisable(true);
			}
		});
		Image deleteCus = new Image("fired.png");
		ImageView deleteCust =  new ImageView(deleteCus);
		deleteCust.setFitHeight(100);
		deleteCust.setFitWidth(100);
		Button delete = new Button("Delete Customer",deleteCust);
		delete.setFont(new Font("Times New Roman",25));
		delete.setPrefHeight(100);
		delete.setPrefWidth(350);
		delete.setEffect(new DropShadow());
		delete.setStyle("-fx-background-radius: 25");

		delete.setOnAction(e ->{
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equalsIgnoreCase(tId.getText())){
					dataBase.getCustomer().remove(i);
				}
			}

			tg.selectToggle(null);
			tAddress.clear();
			tId.clear();
			tMobile.clear();
			tName.clear();

		});

		Image backCus = new Image("ret-costomer.png");
		ImageView backCust =  new ImageView(backCus);
		backCust.setFitHeight(100);
		backCust.setFitWidth(100);
		Button back = new Button("Return to customer page",backCust);
		back.setPrefHeight(100);
		back.setPrefWidth(400); 
		back.setFont(new Font("Times New Roman",25));
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(cutomerScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(50, find,delete, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");



		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void serchById(Stage primaryStage) {
		primaryStage.setMaximized(true);


		BorderPane borderPane = new BorderPane();
		Label welcome = new Label("Serch Customer By ID Window");
		welcome.setFont(new Font("Times New Roman",60));
		welcome.setPadding(new Insets(40));
		borderPane.setTop(welcome);
		borderPane.setAlignment(welcome, Pos.CENTER);

		Label cId = new Label("Customer ID :          ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(18));
		Label cName = new Label("Customer Name :     ");
		cName.setFont(new Font("Times New Roman",30));
		cName.setPadding(new Insets(18));
		Label cAddress = new Label("Customer Address : ");
		cAddress.setFont(new Font("Times New Roman",30));
		cAddress.setPadding(new Insets(18));
		Label cMobile = new Label("Customer Moblie :  ");
		cMobile.setFont(new Font("Times New Roman",30));
		cMobile.setPadding(new Insets(18));

		TextField tId = new TextField();
		tId.promptTextProperty().set("Enter Id and press on find button to find Information");
		TextField tName = new TextField();
		TextField tAddress = new TextField();
		TextField tMobile = new TextField();

		tName.setEditable(false);
		tAddress.setEditable(false);
		tMobile.setEditable(false);

		tId.setMinHeight(70);
		tId.setMinWidth(860);
		tName.setMinHeight(70);
		tName.setMinWidth(860);
		tAddress.setMinHeight(70);
		tAddress.setMinWidth(860);
		tMobile.setMinHeight(70);
		tMobile.setMinWidth(860);

		IconedTextFieled(cId, tId);
		IconedTextFieled(cName, tName);
		IconedTextFieled(cAddress, tAddress);
		IconedTextFieled(cMobile, tMobile);

		HBox id = new HBox();
		HBox name = new HBox();
		HBox adders = new HBox();
		HBox mobile = new HBox();
		id.getChildren().addAll(cId, tId);
		id.setAlignment(Pos.CENTER);
		name.getChildren().addAll(cName, tName);
		name.setAlignment(Pos.CENTER);
		adders.getChildren().addAll(cAddress, tAddress);
		adders.setAlignment(Pos.CENTER);
		mobile.getChildren().addAll(cMobile, tMobile);
		mobile.setAlignment(Pos.CENTER);

		RadioButton limit  = new RadioButton("LIMITED");
		RadioButton unlimit  = new RadioButton("UNLIMITED");
		ToggleGroup tg = new ToggleGroup();
		limit.setToggleGroup(tg);
		unlimit.setToggleGroup(tg);
		limit.setDisable(true);
		unlimit.setDisable(true);
		limit.setFont(new Font("Times New Roman",25));
		unlimit.setFont(new Font("Times New Roman",25));
		HBox planBox = new HBox(100,limit,unlimit);
		planBox.setPrefSize(860, 70);
		planBox.setAlignment(Pos.CENTER);

		Label plan = new Label("Customer Plan :      ");
		plan.setFont(new Font("Times New Roman",30));
		plan.setPadding(new Insets(18));

		plan.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		planBox.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");

		HBox thePlan = new HBox();
		thePlan.getChildren().addAll(plan, planBox);
		thePlan.setAlignment(Pos.CENTER);

		VBox inf = new VBox(30,id,name,adders,mobile,thePlan);
		inf.setAlignment(Pos.CENTER);

		borderPane.setCenter(inf);

		Image findCus = new Image("find (2).png");
		ImageView findCust =  new ImageView(findCus);
		findCust.setFitHeight(100);
		findCust.setFitWidth(100);
		Button find = new Button("Find Customer",findCust);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		find.setOnAction(e ->{
			Boolean flag = true;
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equalsIgnoreCase(tId.getText()) ){
					flag = false;
					tName.setText(dataBase.getCustomer().get(i).getName());
					tAddress.setText(dataBase.getCustomer().get(i).getAddress());
					tMobile.setText(dataBase.getCustomer().get(i).getMobile());
					if(dataBase.getCustomer().get(i).getPlan().equalsIgnoreCase("Limited"))
						limit.setSelected(true);
					else
						unlimit.setSelected(true);

				}
			}
			if(flag) {
				tg.selectToggle(null);
				tAddress.clear();
				tMobile.clear();
				tName.clear();
				tName.setEditable(false);
				tAddress.setEditable(false);
				tMobile.setEditable(false);
				limit.setDisable(true);
				unlimit.setDisable(true);
			}
		});

		Image backCus = new Image("ret-costomer.png");
		ImageView backCust =  new ImageView(backCus);
		backCust.setFitHeight(100);
		backCust.setFitWidth(100);
		Button back = new Button("Return to customer page",backCust);
		back.setPrefHeight(100);
		back.setPrefWidth(400); 
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(cutomerScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(50, find, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");



		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void updateInfoAboutCustomer(Stage primaryStage) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label welcome = new Label("Ubdate Information About Customer Window");
		welcome.setFont(new Font("Times New Roman",60));
		welcome.setPadding(new Insets(40));
		borderPane.setTop(welcome);
		borderPane.setAlignment(welcome, Pos.CENTER);

		Label cId = new Label("Customer ID :          ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(18));
		Label cName = new Label("Customer Name :     ");
		cName.setFont(new Font("Times New Roman",30));
		cName.setPadding(new Insets(18));
		Label cAddress = new Label("Customer Address : ");
		cAddress.setFont(new Font("Times New Roman",30));
		cAddress.setPadding(new Insets(18));
		Label cMobile = new Label("Customer Moblie :  ");
		cMobile.setFont(new Font("Times New Roman",30));
		cMobile.setPadding(new Insets(18));

		TextField tId = new TextField();
		TextField tName = new TextField();
		TextField tAddress = new TextField();
		TextField tMobile = new TextField();

		tName.setEditable(false);
		tAddress.setEditable(false);
		tMobile.setEditable(false);

		tId.setMinHeight(70);
		tId.setMinWidth(860);
		tName.setMinHeight(70);
		tName.setMinWidth(860);
		tAddress.setMinHeight(70);
		tAddress.setMinWidth(860);
		tMobile.setMinHeight(70);
		tMobile.setMinWidth(860);

		IconedTextFieled(cId, tId);
		IconedTextFieled(cName, tName);
		IconedTextFieled(cAddress, tAddress);
		IconedTextFieled(cMobile, tMobile);

		HBox id = new HBox();
		HBox name = new HBox();
		HBox adders = new HBox();
		HBox mobile = new HBox();
		id.getChildren().addAll(cId, tId);
		id.setAlignment(Pos.CENTER);
		name.getChildren().addAll(cName, tName);
		name.setAlignment(Pos.CENTER);
		adders.getChildren().addAll(cAddress, tAddress);
		adders.setAlignment(Pos.CENTER);
		mobile.getChildren().addAll(cMobile, tMobile);
		mobile.setAlignment(Pos.CENTER);

		RadioButton limit  = new RadioButton("LIMITED");
		RadioButton unlimit  = new RadioButton("UNLIMITED");
		ToggleGroup tg = new ToggleGroup();
		limit.setToggleGroup(tg);
		unlimit.setToggleGroup(tg);
		limit.setDisable(true);
		unlimit.setDisable(true);
		limit.setFont(new Font("Times New Roman",25));
		unlimit.setFont(new Font("Times New Roman",25));
		HBox planBox = new HBox(100,limit,unlimit);
		planBox.setPrefSize(860, 70);
		planBox.setAlignment(Pos.CENTER);

		Label plan = new Label("Customer Plan :      ");
		plan.setFont(new Font("Times New Roman",30));
		plan.setPadding(new Insets(18));

		plan.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		planBox.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");

		HBox thePlan = new HBox();
		thePlan.getChildren().addAll(plan, planBox);
		thePlan.setAlignment(Pos.CENTER);

		VBox inf = new VBox(30,id,name,adders,mobile,thePlan);
		inf.setAlignment(Pos.CENTER);

		borderPane.setCenter(inf);

		Image findCus = new Image("find (2).png");
		ImageView findCust =  new ImageView(findCus);
		findCust.setFitHeight(100);
		findCust.setFitWidth(100);
		Button find = new Button("Find Customer",findCust);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		find.setOnAction(e ->{
			Boolean flag= true;
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equalsIgnoreCase(tId.getText()) ){
					flag = false;
					tName.setEditable(true);
					tAddress.setEditable(true);
					tMobile.setEditable(true);
					limit.setDisable(false);
					unlimit.setDisable(false);
					tName.setText(dataBase.getCustomer().get(i).getName());
					tAddress.setText(dataBase.getCustomer().get(i).getAddress());
					tMobile.setText(dataBase.getCustomer().get(i).getMobile());
					if(dataBase.getCustomer().get(i).getPlan().equalsIgnoreCase("Limited"))
						limit.setSelected(true);
					else
						unlimit.setSelected(true);
				}
			}
			if(flag) {
				tg.selectToggle(null);
				tAddress.clear();
				tMobile.clear();
				tName.clear();
				tName.setEditable(false);
				tAddress.setEditable(false);
				tMobile.setEditable(false);
				limit.setDisable(true);
				unlimit.setDisable(true);
			}
		});
		Image updatCus = new Image("updating.png");
		ImageView updatCust =  new ImageView(updatCus);
		updatCust.setFitHeight(100);
		updatCust.setFitWidth(100);
		Button ubdate = new Button("Update Customer",updatCust);
		ubdate.setFont(new Font("Times New Roman",25));
		ubdate.setPrefHeight(100);
		ubdate.setPrefWidth(350);
		ubdate.setEffect(new DropShadow());
		ubdate.setStyle("-fx-background-radius: 25");

		ubdate.setOnAction(e ->{
			String planSelect = ((RadioButton)tg.getSelectedToggle()).getText();

			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equalsIgnoreCase(tId.getText())){
					dataBase.getCustomer().get(i).setName(tName.getText());
					dataBase.getCustomer().get(i).setMobile(tMobile.getText());
					dataBase.getCustomer().get(i).setAddress(tAddress.getText());

					if ( planSelect.equalsIgnoreCase("limited"))
						dataBase.getCustomer().get(i).setPlan("LIMITED");
					else
						dataBase.getCustomer().get(i).setPlan("UNLIMITED");

					tg.selectToggle(null);
					tAddress.clear();
					tId.clear();
					tMobile.clear();
					tName.clear();
				}
			}

			tName.setEditable(false);
			tAddress.setEditable(false);
			tMobile.setEditable(false);
			limit.setDisable(true);
			unlimit.setDisable(true);

		});

		Image backCus = new Image("ret-costomer.png");
		ImageView backCust =  new ImageView(backCus);
		backCust.setFitHeight(100);
		backCust.setFitWidth(100);
		Button back = new Button("Return to customer page",backCust);
		back.setPrefHeight(100);
		back.setPrefWidth(400); 
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(cutomerScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(50, find,ubdate, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");



		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void addMediaAction(Stage primaryStage) {
		BorderPane bd = new BorderPane();
		Label media = new Label("Media Type : ");
		media.setFont(new Font("Times New Roman",35));

		ComboBox<String> typeOfMedia = new ComboBox<>();
		typeOfMedia.setPrefSize(300,50);
		typeOfMedia.setStyle("-fx-font-size: 20;");
		typeOfMedia.setPromptText("Choice type of media ");
		typeOfMedia.getItems().addAll("Movie","Album","Game");

		typeOfMedia.setOnAction(e ->{
			if(typeOfMedia.getValue().equals("Movie")) {
				addMovieAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Album")) {
				addAlbumAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Game")) {
				addGameAction(primaryStage);
			}
		});

		HBox hbox = new HBox(10, media,typeOfMedia);
		hbox.setPadding(new Insets(20));
		hbox.setAlignment(Pos.CENTER);

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		bd.setTop(hbox);
		bd.setBottom(back);
		bd.setAlignment(back, Pos.CENTER);
		bd.setPadding(new Insets(25));
		bd.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addMediaScene = new Scene(bd,1600,800);
		primaryStage.setScene(addMediaScene);
		primaryStage.setMaximized(true);
		primaryStage.show();

	}

	private void addMovieAction(Stage primaryStage) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Add Movie :                 			    Media Type : ");
		media.setFont(new Font("Times New Roman",35));
		Label movie = new Label("Add Movie : ");

		ComboBox<String> typeOfMedia = new ComboBox<>();
		typeOfMedia.setPrefSize(300,50);
		typeOfMedia.setStyle("-fx-font-size: 20;");
		typeOfMedia.setPromptText("Choice type of media ");
		typeOfMedia.getItems().addAll("Movie","Album","Game");

		typeOfMedia.setOnAction(e ->{
			if(typeOfMedia.getValue().equals("Movie")) {
				addMovieAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Album")) {
				addAlbumAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Game")) {
				addGameAction(primaryStage);
			}
		});

		HBox hbox = new HBox(10, media,typeOfMedia);
		hbox.setPadding(new Insets(35));
		hbox.setAlignment(Pos.CENTER_LEFT);

		Label mCode = new Label("Code :                   ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :          ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label rate = new Label("Rate :                      ");
		rate.setFont(new Font("Times New Roman",30));
		rate.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);

		RadioButton hr  = new RadioButton("HR");
		RadioButton dr  = new RadioButton("DR");
		RadioButton ac  = new RadioButton("AC");
		ToggleGroup tg = new ToggleGroup();
		hr.setToggleGroup(tg);
		dr.setToggleGroup(tg);
		ac.setToggleGroup(tg);
		hr.setFont(new Font("Times New Roman",25));
		dr.setFont(new Font("Times New Roman",25));
		ac.setFont(new Font("Times New Roman",25));
		HBox rateBox = new HBox(100,hr,dr,ac);
		rateBox.setPrefSize(860, 70);
		rateBox.setAlignment(Pos.CENTER);

		rate.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		rateBox.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");

		HBox theRate = new HBox();
		theRate.getChildren().addAll(rate, rateBox);
		theRate.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,theRate);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image addAlb = new Image("album.png");
		ImageView addAlbum =  new ImageView(addAlb);
		addAlbum.setFitHeight(90);
		addAlbum.setFitWidth(90);
		Button addMovie = new Button("Add Movie",addAlbum);
		addMovie.setFont(new Font("Times New Roman",25));
		addMovie.setPrefHeight(100);
		addMovie.setPrefWidth(300);
		addMovie.setEffect(new DropShadow());
		addMovie.setStyle("-fx-background-radius: 25");

		addMovie.setOnAction(e ->{
			dataBase.getMedia().add(new Movie(tCode.getText(), tTitle.getText(),Integer.parseInt(tNumOfCopie.getText()), ((RadioButton)tg.getSelectedToggle()).getText()));
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
			tg.selectToggle(null);
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, addMovie, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER);

		borderPane.setTop(hbox);
		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void addAlbumAction(Stage primaryStage) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Add Album :                 			    Media Type : ");
		media.setFont(new Font("Times New Roman",35));

		ComboBox<String> typeOfMedia = new ComboBox<>();
		typeOfMedia.setPrefSize(300,50);
		typeOfMedia.setStyle("-fx-font-size: 20;");
		typeOfMedia.setPromptText("Choice type of media ");
		typeOfMedia.getItems().addAll("Movie","Album","Game");

		typeOfMedia.setOnAction(e ->{
			if(typeOfMedia.getValue().equals("Movie")) {
				addMovieAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Album")) {
				addAlbumAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Game")) {
				addGameAction(primaryStage);
			}
		});

		HBox hbox = new HBox(10, media,typeOfMedia);
		hbox.setPadding(new Insets(20));
		hbox.setAlignment(Pos.CENTER_LEFT);

		Label mCode = new Label("Code :                     ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label artist = new Label("Artist :                     ");
		artist.setFont(new Font("Times New Roman",30));
		artist.setPadding(new Insets(18));
		Label songs = new Label("Songs :                     ");
		songs.setFont(new Font("Times New Roman",30));
		songs.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();
		TextField tArtist = new TextField();
		TextField tSongs = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);
		tArtist.setMinHeight(70);
		tArtist.setMinWidth(860);
		tSongs.setMinHeight(70);
		tSongs.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);
		IconedTextFieled(artist, tArtist);
		IconedTextFieled(songs, tSongs);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		HBox art = new HBox();
		HBox song = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);
		art.getChildren().addAll(artist, tArtist);
		art.setAlignment(Pos.CENTER);
		song.getChildren().addAll(songs, tSongs);
		song.setAlignment(Pos.CENTER);

		VBox inf = new VBox(30,code,title,num,art,song);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image alb = new Image("music.png");
		ImageView albu =  new ImageView(alb);
		albu.setFitHeight(90);
		albu.setFitWidth(90);
		Button addAlbum = new Button("Add Album",albu);
		addAlbum.setFont(new Font("Times New Roman",25));
		addAlbum.setPrefHeight(100);
		addAlbum.setPrefWidth(300);
		addAlbum.setEffect(new DropShadow());
		addAlbum.setStyle("-fx-background-radius: 25");

		addAlbum.setOnAction(e ->{
			dataBase.getMedia().add(new Album(tCode.getText(), tTitle.getText(),Integer.parseInt(tNumOfCopie.getText()), tArtist.getText(), tSongs.getText()));
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
			tArtist.clear();
			tSongs.clear();
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, addAlbum, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER);

		borderPane.setTop(hbox);
		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void addGameAction(Stage primaryStage) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Add Game :                 			    Media Type : ");
		media.setFont(new Font("Times New Roman",35));

		ComboBox<String> typeOfMedia = new ComboBox<>();
		typeOfMedia.setPrefSize(300,50);
		typeOfMedia.setStyle("-fx-font-size: 20;");
		typeOfMedia.setPromptText("Choice type of media ");
		typeOfMedia.getItems().addAll("Movie","Album","Game");

		typeOfMedia.setOnAction(e ->{
			if(typeOfMedia.getValue().equals("Movie")) {
				addMovieAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Album")) {
				addAlbumAction(primaryStage);
			}
			else if(typeOfMedia.getValue().equals("Game")) {
				addGameAction(primaryStage);
			}
		});

		HBox hbox = new HBox(10, media,typeOfMedia);
		hbox.setPadding(new Insets(20));
		hbox.setAlignment(Pos.CENTER_LEFT);

		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label weight = new Label("Weight :                  ");
		weight.setFont(new Font("Times New Roman",30));
		weight.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();
		TextField tWeight = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);
		tWeight.setMinHeight(70);
		tWeight.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);
		IconedTextFieled(weight, tWeight);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		HBox wights = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);
		wights.getChildren().addAll(weight, tWeight);
		wights.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,wights);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);


		Image add = new Image("game.png");
		ImageView addg =  new ImageView(add);
		addg.setFitHeight(90);
		addg.setFitWidth(90);
		Button addGame = new Button(" Add Game",addg);
		addGame.setFont(new Font("Times New Roman",25));
		addGame.setPrefHeight(100);
		addGame.setPrefWidth(300);
		addGame.setEffect(new DropShadow());
		addGame.setStyle("-fx-background-radius: 25");

		addGame.setOnAction(e ->{
			dataBase.addGame(tCode.getText(), tTitle.getText(), Integer.parseInt(tNumOfCopie.getText()), Double.parseDouble(tWeight.getText()));
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
			tWeight.clear();
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, addGame, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER); 

		borderPane.setTop(hbox);
		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void deleteMediaAction(Stage primaryStage) {
		BorderPane bd = new BorderPane();
		Label media = new Label("Delete Media Window");
		media.setFont(new Font("Times New Roman",35));


		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		TextField tCode = new TextField();
		tCode.setMinHeight(70);
		tCode.setMinWidth(860);

		IconedTextFieled(mCode, tCode);

		HBox code = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		find.setOnAction(e ->{
			for (int i = 0; i < dataBase.getMedia().size(); i++) {
				if(dataBase.getMedia().get(i).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(i) instanceof Movie ) {
						deleteMovieAction(primaryStage,i);
					}
					else if(dataBase.getMedia().get(i) instanceof Album ) {
						deleteAlbumAction(primaryStage,i);
					}
					else if(dataBase.getMedia().get(i) instanceof Game ) {
						deleteGameAction(primaryStage,i);
					}
				}
			}
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox box = new HBox(50,find,back);
		box.setAlignment(Pos.CENTER);

		bd.setTop(media);
		bd.setAlignment(media, Pos.CENTER);
		bd.setCenter(code);
		bd.setAlignment(code, Pos.CENTER);
		bd.setBottom(box);
		bd.setAlignment(back, Pos.CENTER);
		bd.setPadding(new Insets(25));
		bd.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addMediaScene = new Scene(bd,1600,800);
		primaryStage.setScene(addMediaScene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	private void deleteGameAction(Stage primaryStage,int i) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Delete Game");
		media.setFont(new Font("Times New Roman",35));

		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label weight = new Label("Weight :                  ");
		weight.setFont(new Font("Times New Roman",30));
		weight.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();
		TextField tWeight = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);
		tWeight.setMinHeight(70);
		tWeight.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);
		IconedTextFieled(weight, tWeight);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		HBox wights = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);
		wights.getChildren().addAll(weight, tWeight);
		wights.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,wights);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		tCode.setText(dataBase.getMedia().get(i).getCode());
		tTitle.setText(dataBase.getMedia().get(i).getTitle());
		tNumOfCopie.setText(""+dataBase.getMedia().get(i).getNumOfCopies());
		tWeight.setText( ((Game)dataBase.getMedia().get(i)).getWeight()+ "");		

		find.setOnAction(e ->{
			for (int j = 0; j < dataBase.getMedia().size(); j++) {
				if(dataBase.getMedia().get(j).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(j) instanceof Movie ) {
						deleteMovieAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Album ) {
						deleteAlbumAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Game ) {
						deleteGameAction(primaryStage,j);
					}
				}
			}
		});

		Image dele = new Image("game-r.png");
		ImageView deleteg =  new ImageView(dele);
		deleteg.setFitHeight(90);
		deleteg.setFitWidth(90);
		Button deleteGame = new Button(" Delete Game",deleteg);
		deleteGame.setFont(new Font("Times New Roman",25));
		deleteGame.setPrefHeight(100);
		deleteGame.setPrefWidth(300);
		deleteGame.setEffect(new DropShadow());
		deleteGame.setStyle("-fx-background-radius: 25");

		deleteGame.setOnAction(e ->{
			dataBase.getMedia().remove(i);
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
			tWeight.clear();
		});


		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, find, deleteGame, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER); 
		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}


	private void deleteAlbumAction(Stage primaryStage,int i) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Delete Album");
		media.setFont(new Font("Times New Roman",35));

		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label artist = new Label("Artist :                     ");
		artist.setFont(new Font("Times New Roman",30));
		artist.setPadding(new Insets(18));
		Label songs = new Label("Songs :                     ");
		songs.setFont(new Font("Times New Roman",30));
		songs.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();
		TextField tArtist = new TextField();
		TextField tSongs = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);
		tArtist.setMinHeight(70);
		tArtist.setMinWidth(860);
		tSongs.setMinHeight(70);
		tSongs.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);
		IconedTextFieled(artist, tArtist);
		IconedTextFieled(songs, tSongs);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		HBox art = new HBox();
		HBox song = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);
		art.getChildren().addAll(artist, tArtist);
		art.setAlignment(Pos.CENTER);
		song.getChildren().addAll(songs, tSongs);
		song.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,art,song);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		tCode.setText(dataBase.getMedia().get(i).getCode());
		tTitle.setText(dataBase.getMedia().get(i).getTitle());
		tNumOfCopie.setText("" + dataBase.getMedia().get(i).getNumOfCopies());
		tArtist.setText(((Album)dataBase.getMedia().get(i)).getArtist());
		tSongs.setText(((Album)dataBase.getMedia().get(i)).getSongs());

		find.setOnAction(e ->{
			for (int j = 0; j < dataBase.getMedia().size(); j++) {
				if(dataBase.getMedia().get(j).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(j) instanceof Movie ) {
						deleteMovieAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Album ) {
						deleteAlbumAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Game ) {
						deleteGameAction(primaryStage,j);
					}
				}
			}
		});

		Image alb = new Image("music-R.png");
		ImageView albu =  new ImageView(alb);
		albu.setFitHeight(90);
		albu.setFitWidth(90);
		Button deleteAlbum = new Button("Delete Album",albu);
		deleteAlbum.setFont(new Font("Times New Roman",25));
		deleteAlbum.setPrefHeight(100);
		deleteAlbum.setPrefWidth(300);
		deleteAlbum.setEffect(new DropShadow());
		deleteAlbum.setStyle("-fx-background-radius: 25");

		deleteAlbum.setOnAction(e ->{
			dataBase.getMedia().remove(i);
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
			tArtist.clear();
			tSongs.clear();
		});

		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, find, deleteAlbum, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER); 

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);
		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();				
	}


	private void deleteMovieAction(Stage primaryStage, int i) {
		primaryStage.setMaximized(true);

		BorderPane borderPane = new BorderPane();
		Label media = new Label("Delete Movie");
		media.setFont(new Font("Times New Roman",35));

		Label mCode = new Label("Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		Label mTitle = new Label("Media Title :           ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(18));
		Label numberOfCopies = new Label("Number of copies : ");
		numberOfCopies.setFont(new Font("Times New Roman",30));
		numberOfCopies.setPadding(new Insets(18));
		Label rate = new Label("Rate :                      ");
		rate.setFont(new Font("Times New Roman",30));
		rate.setPadding(new Insets(18));

		TextField tCode = new TextField();
		TextField tTitle = new TextField();
		TextField tNumOfCopie = new TextField();

		tCode.setMinHeight(70);
		tCode.setMinWidth(860);
		tTitle.setMinHeight(70);
		tTitle.setMinWidth(860);
		tNumOfCopie.setMinHeight(70);
		tNumOfCopie.setMinWidth(860);

		IconedTextFieled(mCode, tCode);
		IconedTextFieled(mTitle, tTitle);
		IconedTextFieled(numberOfCopies, tNumOfCopie);


		RadioButton hr  = new RadioButton("HR");
		RadioButton dr  = new RadioButton("DR");
		RadioButton ac  = new RadioButton("AC");
		ToggleGroup tg = new ToggleGroup();
		hr.setToggleGroup(tg);
		dr.setToggleGroup(tg);
		ac.setToggleGroup(tg);
		hr.setFont(new Font("Times New Roman",25));
		dr.setFont(new Font("Times New Roman",25));
		ac.setFont(new Font("Times New Roman",25));
		HBox rateBox = new HBox(100,hr,dr,ac);
		rateBox.setPrefSize(860, 70);
		rateBox.setAlignment(Pos.CENTER);

		rate.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		rateBox.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");

		HBox theRate = new HBox();
		theRate.getChildren().addAll(rate, rateBox);
		theRate.setAlignment(Pos.CENTER);

		HBox code = new HBox();
		HBox title = new HBox();
		HBox num = new HBox();
		code.getChildren().addAll(mCode, tCode);
		code.setAlignment(Pos.CENTER);
		title.getChildren().addAll(mTitle, tTitle);
		title.setAlignment(Pos.CENTER);
		num.getChildren().addAll(numberOfCopies, tNumOfCopie);
		num.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,code,title,num,theRate);
		inf.setAlignment(Pos.CENTER);
		borderPane.setCenter(inf);

		Image fi = new Image("search (3).png");
		ImageView fin =  new ImageView(fi);
		fin.setFitHeight(90);
		fin.setFitWidth(90);
		Button find = new Button("Find", fin);
		find.setFont(new Font("Times New Roman",25));
		find.setPrefHeight(100);
		find.setPrefWidth(300);
		find.setEffect(new DropShadow());
		find.setStyle("-fx-background-radius: 25");

		tCode.setText(dataBase.getMedia().get(i).getCode());
		tTitle.setText(dataBase.getMedia().get(i).getTitle());
		tNumOfCopie.setText(Integer.toString(dataBase.getMedia().get(i).getNumOfCopies()));
		if(((Movie)dataBase.getMedia().get(i)).getRate().equalsIgnoreCase("HR")) {
			hr.setSelected(true);
		}
		else if(((Movie)dataBase.getMedia().get(i)).getRate().equalsIgnoreCase("DR")) {
			dr.setSelected(true);
		}
		else if(((Movie)dataBase.getMedia().get(i)).getRate().equalsIgnoreCase("AC")) {
			ac.setSelected(true);
		}


		find.setOnAction(e ->{
			for (int j = 0; j < dataBase.getMedia().size(); j++) {
				if(dataBase.getMedia().get(j).getCode().equalsIgnoreCase(tCode.getText())) {
					if(dataBase.getMedia().get(j) instanceof Movie ) {
						deleteMovieAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Album ) {
						deleteAlbumAction(primaryStage,j);
					}
					else if(dataBase.getMedia().get(j) instanceof Game ) {
						deleteGameAction(primaryStage,j);
					}
				}
			}
		});

		Image mov = new Image("album-R.png");
		ImageView movi =  new ImageView(mov);
		movi.setFitHeight(90);
		movi.setFitWidth(90);
		Button deleteMovie = new Button("Delete Movie", movi);
		deleteMovie.setFont(new Font("Times New Roman",25));
		deleteMovie.setPrefHeight(100);
		deleteMovie.setPrefWidth(300);
		deleteMovie.setEffect(new DropShadow());
		deleteMovie.setStyle("-fx-background-radius: 25");

		deleteMovie.setOnAction(e ->{
			dataBase.getMedia().remove(i);
			tg.selectToggle(null);
			tCode.clear();
			tTitle.clear();
			tNumOfCopie.clear();
		});


		Image backmed = new Image("back-media.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Media page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(400);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(mediaScene);
			primaryStage.show();
		});

		HBox hbox1 = new HBox(20, find, deleteMovie, back);
		hbox1.paddingProperty().set(new Insets(5));
		hbox1.setAlignment(Pos.CENTER); 
		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);
		borderPane.setBottom(hbox1);
		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene scene = new Scene(borderPane,1600,800);
		primaryStage.setScene(scene);
		primaryStage.show();				

	}


	private void returnMediaAction(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label media = new Label("Return Media From Cart Window : ");
		media.setFont(new Font("Times New Roman",35));
		media.setPadding(new Insets(25));

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		Label cId = new Label("Customer ID : ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(60));
		TextField tId = new TextField();
		tId.setMinHeight(156);
		tId.setMinWidth(860);		
		IconedTextFieled(cId, tId);

		Label mTitle = new Label("Media Title :   ");
		mTitle.setFont(new Font("Times New Roman",30));
		mTitle.setPadding(new Insets(60));
		TextField tTitle = new TextField();
		tTitle.setMinHeight(156);
		tTitle.setMinWidth(860);		
		IconedTextFieled(mTitle, tTitle);

		Label cInfo = new Label("Massege :        ");
		cInfo.setPadding(new Insets(60));
		cInfo.setFont(new Font("Times New Roman",30));
		TextArea  tInfo = new TextArea();
		tInfo.setMaxHeight(156);
		tInfo.setMaxWidth(860);

		cInfo.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		tInfo.setStyle("-fx-border-radius: 0 0 0 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;");

		HBox cIdBox = new HBox();
		HBox mTitleBox = new HBox();
		HBox cInfoBox = new HBox();
		cIdBox.getChildren().addAll(cId,tId);
		cIdBox.setAlignment(Pos.CENTER);
		mTitleBox.getChildren().addAll(mTitle, tTitle);
		mTitleBox.setAlignment(Pos.CENTER);
		cInfoBox.getChildren().addAll(cInfo,tInfo);
		cInfoBox.setAlignment(Pos.CENTER);

		VBox inf = new VBox(35,cIdBox,mTitleBox,cInfoBox);
		inf.setAlignment(Pos.CENTER);
		inf.setPadding(new Insets(5));
		borderPane.setCenter(inf);
		borderPane.setAlignment(inf, Pos.CENTER_LEFT);

		Image retu = new Image("trolley-cart.png");
		ImageView retur =  new ImageView(retu);
		retur.setFitHeight(90);
		retur.setFitWidth(90);
		Button ret = new Button("Return Media",retur);
		ret.setFont(new Font("Times New Roman",25));
		ret.setPrefHeight(100);
		ret.setPrefWidth(300);
		ret.setEffect(new DropShadow());
		ret.setStyle("-fx-background-radius: 25");


		ret.setOnAction(e ->{
			boolean flag = true;
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equals(tId.getText())) {
					flag=false;
					if( dataBase.returnMedia(dataBase.getCustomer().get(i).getName(), tTitle.getText()) ){
						tInfo.setText("Return Sucsessfuly.");
					}
					else
						tInfo.setText("Error !! --> Media title doesn't found. ");
				}
			}
			if(flag)
				tInfo.setText("Error !! --> Customer name doesn't found. ");

		});

		Image backmed = new Image("back-arrow.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Rent page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(350);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(rentScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(100, ret, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);

		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addToCartScene = new Scene(borderPane,1600,800);
		primaryStage.setScene(addToCartScene);
		primaryStage.show();

	}


	private void printRentAction(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label media = new Label("Print Rent Media Cart Window : ");
		media.setFont(new Font("Times New Roman",35));
		media.setPadding(new Insets(15));

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		Label cId = new Label("   Customer ID :                                       ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(18));
		TextField tId = new TextField();
		tId.setMinHeight(70);
		tId.setMinWidth(860);		
		IconedTextFieled(cId, tId);

		Label cInfo = new Label("Rented Cart : ");
		cInfo.setFont(new Font("Times New Roman",30));
		TextArea  tInfo = new TextArea();
		tInfo.setMaxHeight(375);
		tInfo.setMaxWidth(860);

		cInfo.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 170;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		tInfo.setStyle("-fx-border-radius: 0 0 0 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;");	

		HBox cIdBox = new HBox();
		HBox cInfoBox = new HBox();
		cIdBox.getChildren().addAll(cId,tId);
		cIdBox.setAlignment(Pos.CENTER);


		cInfoBox.getChildren().addAll(cInfo,tInfo);
		cInfoBox.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,cIdBox,cInfoBox);
		inf.setAlignment(Pos.CENTER);
		inf.setPadding(new Insets(5));
		borderPane.setCenter(inf);
		borderPane.setAlignment(inf, Pos.CENTER_LEFT);

		Image pri = new Image("printer.png");
		ImageView prin =  new ImageView(pri);
		prin.setFitHeight(90);
		prin.setFitWidth(90);
		Button print = new Button(" Print cart",prin);
		print.setFont(new Font("Times New Roman",25));
		print.setPrefHeight(100);
		print.setPrefWidth(300);
		print.setEffect(new DropShadow());
		print.setStyle("-fx-background-radius: 25");

		print.setOnAction(e ->{
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equals(tId.getText())) {
					if(dataBase.getCustomer().get(i).getRented().size() == 0) {
						tInfo.setText("The cart is empty.");
					}
					else {
						String element = "" ;
						for (int j = 0; j < dataBase.getCustomer().get(i).getRented().size(); j++) {
							element += (j+1) +"- " +dataBase.getCustomer().get(i).getRented().get(j) + "\n";
						}

						tInfo.setText(""+ element);
					}
				}
			}
		});

		Image backmed = new Image("back-arrow.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Rent page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(350);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(rentScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(100, print, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);

		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addToCartScene = new Scene(borderPane,1600,800);
		primaryStage.setScene(addToCartScene);
		primaryStage.show();
	}


	private void printCartAction(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label media = new Label("Print Intrested Media Cart Window : ");
		media.setFont(new Font("Times New Roman",35));
		media.setPadding(new Insets(15));

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		Label cId = new Label("   Customer ID :                                       ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(18));
		TextField tId = new TextField();
		tId.setMinHeight(70);
		tId.setMinWidth(860);		
		IconedTextFieled(cId, tId);

		Label cInfo = new Label("Intersted Cart : ");
		cInfo.setFont(new Font("Times New Roman",30));
		TextArea  tInfo = new TextArea();
		tInfo.setMaxHeight(375);
		tInfo.setMaxWidth(860);

		cInfo.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 170;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		tInfo.setStyle("-fx-border-radius: 0 0 0 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;");	

		HBox cIdBox = new HBox();
		HBox cInfoBox = new HBox();
		cIdBox.getChildren().addAll(cId,tId);
		cIdBox.setAlignment(Pos.CENTER);


		cInfoBox.getChildren().addAll(cInfo,tInfo);
		cInfoBox.setAlignment(Pos.CENTER);


		VBox inf = new VBox(30,cIdBox,cInfoBox);
		inf.setAlignment(Pos.CENTER);
		inf.setPadding(new Insets(5));
		borderPane.setCenter(inf);
		borderPane.setAlignment(inf, Pos.CENTER_LEFT);

		Image pri = new Image("printer.png");
		ImageView prin =  new ImageView(pri);
		prin.setFitHeight(90);
		prin.setFitWidth(90);
		Button print = new Button(" Print cart",prin);
		print.setFont(new Font("Times New Roman",25));
		print.setPrefHeight(100);
		print.setPrefWidth(300);
		print.setEffect(new DropShadow());
		print.setStyle("-fx-background-radius: 25");

		print.setOnAction(e ->{
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equals(tId.getText())) {
					if(dataBase.getCustomer().get(i).getCart().size() == 0) {
						tInfo.setText("The cart is empty.");
					}
					else {
						String element = "" ;
						for (int j = 0; j < dataBase.getCustomer().get(i).getCart().size(); j++) {
							element += (j+1) +"- " +dataBase.getCustomer().get(i).getCart().get(j) + "\n";
						}
						tInfo.setText(""+ element);
					}
				}
			}
		});

		Image backmed = new Image("back-arrow.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Rent page",backmedia);
		back.setPrefHeight(100);
		back.setPrefWidth(350);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(rentScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(100, print, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);

		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addToCartScene = new Scene(borderPane,1600,800);
		primaryStage.setScene(addToCartScene);
		primaryStage.show();
	}


	private void addToCartAction(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label media = new Label("Add to cart window : ");
		media.setFont(new Font("Times New Roman",35));
		media.setPadding(new Insets(15));

		borderPane.setTop(media);
		borderPane.setAlignment(media, Pos.CENTER);

		Label cId = new Label("   Customer ID :                    ");
		cId.setFont(new Font("Times New Roman",30));
		cId.setPadding(new Insets(18));
		TextField tId = new TextField();
		tId.setMinHeight(70);
		tId.setMinWidth(860);		
		IconedTextFieled(cId, tId);

		Label cInfo = new Label("Customer Information : ");
		cInfo.setFont(new Font("Times New Roman",30));
		cInfo.setPadding(new Insets(46));
		TextArea  tInfo = new TextArea();
		tInfo.setMaxHeight(130);
		tInfo.setMaxWidth(860);

		tInfo.setEditable(false);
		tInfo.setPromptText("Write Id and press (Enter) to show customer information");
		tId.setOnAction(e ->{
			boolean flag = true;
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				if(dataBase.getCustomer().get(i).getId().equals(tId.getText())) {
					flag = false;
					tInfo.setText("ID : "+ dataBase.getCustomer().get(i).getId() +"\n"
							+ "Name : " + dataBase.getCustomer().get(i).getName() +"\n"
							+ "Plan : "+ dataBase.getCustomer().get(i).getPlan()+"\n"
							+ "Mobile : " + dataBase.getCustomer().get(i).getMobile()+"\n"
							+ "Cart : " + dataBase.getCustomer().get(i).getCart() +"\n"
							+ "Rent : " + dataBase.getCustomer().get(i).getRented()+"\n" );
				}
			}
			if(flag) {
				tInfo.clear();
			}
		});

		cInfo.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		tInfo.setStyle("-fx-border-radius: 0 0 0 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;");		

		Label mCode = new Label("  Media Code :                      ");
		mCode.setFont(new Font("Times New Roman",30));
		mCode.setPadding(new Insets(18));
		TextField tCode = new TextField();
		tCode.setMinHeight(70);
		tCode.setMinWidth(860);

		IconedTextFieled(mCode, tCode);

		Label mInfo = new Label("Media Information :     ");
		mInfo.setFont(new Font("Times New Roman",30));
		mInfo.setPadding(new Insets(50));
		TextArea  mtInfo = new TextArea ();
		mtInfo.setMinHeight(130);
		mtInfo.setMaxWidth(860);

		mtInfo.setEditable(false);
		mtInfo.setPromptText("Write code and press (Enter) to show media information");
		tCode.setOnAction(e ->{
			boolean flag = true;
			for (int i = 0; i < dataBase.getMedia().size(); i++) {
				if(dataBase.getMedia().get(i).getCode().equals(tCode.getText())) {
					flag = false;
					if(dataBase.getMedia().get(i) instanceof Movie ) {
						mtInfo.setText("Code : " +dataBase.getMedia().get(i).getCode() +"\n"
								+ "Title :" + dataBase.getMedia().get(i).getTitle()+ "\n"
								+ "Number of copies : "+ dataBase.getMedia().get(i).getNumOfCopies() + "\n"
								+ "Rate : " + ((Movie)dataBase.getMedia().get(i)).getRate() );
					}
					else if(dataBase.getMedia().get(i) instanceof Album ) {
						mtInfo.setText("Code : " +dataBase.getMedia().get(i).getCode() +"\n"
								+ "Title : " + dataBase.getMedia().get(i).getTitle()+ "\n"
								+ "Number of copies : "+ dataBase.getMedia().get(i).getNumOfCopies() + "\n"
								+ "Artist : " + ((Album)dataBase.getMedia().get(i)).getArtist() + "\n"
								+ "Songs : " + ((Album)dataBase.getMedia().get(i)).getSongs()+ "\n");
					}
					else if(dataBase.getMedia().get(i) instanceof Game ) {
						mtInfo.setText("Code : " +dataBase.getMedia().get(i).getCode() +"\n"
								+ "Title :" + dataBase.getMedia().get(i).getTitle()+ "\n"
								+ "Number of copies : "+ dataBase.getMedia().get(i).getNumOfCopies() + "\n"
								+ "Weight : " + ((Game)dataBase.getMedia().get(i)).getWeight() );
					}
				}
			}
			if(flag) {
				tCode.clear();
			}
		});

		mInfo.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		mtInfo.setStyle("-fx-border-radius: 0 0 0 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;");	

		Label date = new Label("  Date :                                  ");
		date.setFont(new Font("Times New Roman",30));
		date.setPadding(new Insets(18));
		TextField tdate = new TextField();
		tdate.setMinHeight(70);
		tdate.setMinWidth(860);
		IconedTextFieled(date, tdate);
		tdate.setEditable(false);
		Date date1 = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy"); 
		tdate.setText(sf.format(date1));
		HBox cIdBox = new HBox();
		HBox cInfoBox = new HBox();
		HBox mCodeBox = new HBox();
		HBox mInfoBox = new HBox();
		HBox rentDate = new HBox();


		cIdBox.getChildren().addAll(cId,tId);
		cIdBox.setAlignment(Pos.CENTER);
		cInfoBox.getChildren().addAll(cInfo,tInfo);
		cInfoBox.setAlignment(Pos.CENTER);
		mCodeBox.getChildren().addAll(mCode,tCode);
		mCodeBox.setAlignment(Pos.CENTER);
		mInfoBox.getChildren().addAll(mInfo,mtInfo);
		mInfoBox.setAlignment(Pos.CENTER);
		rentDate.getChildren().addAll(date, tdate);
		rentDate.setAlignment(Pos.CENTER);

		VBox inf = new VBox(20,cIdBox,cInfoBox,mCodeBox,mInfoBox,rentDate);
		inf.setAlignment(Pos.CENTER);
		inf.setPadding(new Insets(5));
		borderPane.setCenter(inf);
		borderPane.setAlignment(inf, Pos.CENTER);

		Image addc = new Image("shopping-cart (2).png");
		ImageView addca =  new ImageView(addc);
		addca.setFitHeight(90);
		addca.setFitWidth(90);
		Button add = new Button("Add to cart",addca);
		add.setFont(new Font("Times New Roman",25));
		add.setPrefHeight(90);
		add.setPrefWidth(300);
		add.setEffect(new DropShadow());
		add.setStyle("-fx-background-radius: 25");


		//hon lazem adef el title + code ?	

		add.setOnAction(e ->{
			try {
				
			for (int j = 0; j < dataBase.getCustomer().size(); j++) {
				if( dataBase.getCustomer().get(j).getId().equals(tId.getText())) {
					for (int i = 0; i < dataBase.getMedia().size(); i++) {
						if( dataBase.getMedia().get(i).getCode().equals(tCode.getText()) ) {
							dataBase.addToCart(dataBase.getCustomer().get(j).getName(), dataBase.getMedia().get(i).getTitle());				
						}
					}
				}
			}
			}catch (IllegalArgumentException r) {
				System.out.println(r);
			}
		});


		Image pros = new Image("system-update1.png");
		ImageView pross =  new ImageView(pros);
		pross.setFitHeight(90);
		pross.setFitWidth(90);
		Button process = new Button("Process cart",pross);
		process.setFont(new Font("Times New Roman",25));
		process.setPrefHeight(90);
		process.setPrefWidth(300);
		process.setEffect(new DropShadow());
		process.setStyle("-fx-background-radius: 25");

		process.setOnAction(e ->{
			dataBase.processRequests();
		});

		Image backmed = new Image("previous.png");
		ImageView backmedia =  new ImageView(backmed);
		backmedia.setFitHeight(90);
		backmedia.setFitWidth(90);
		Button back = new Button(" Return to Rent page",backmedia);
		back.setPrefHeight(90);
		back.setPrefWidth(350);
		back.setFont(new Font("Times New Roman",25)); 
		back.setEffect(new DropShadow());
		back.setStyle("-fx-background-radius: 25");

		back.setOnAction(r -> {
			writeFile();
			primaryStage.setScene(rentScene);
			primaryStage.show();
		});

		HBox hbox = new HBox(25, add,process, back);
		hbox.paddingProperty().set(new Insets(20));;
		hbox.setAlignment(Pos.CENTER);

		borderPane.setBottom(hbox);

		borderPane.setPadding(new Insets(20));
		borderPane.setStyle("-fx-background-color: linear-gradient(to right, #acb6e5, #86fde8);");

		Scene addToCartScene = new Scene(borderPane,1600,800);
		primaryStage.setScene(addToCartScene);
		primaryStage.show();

	}

	private void IconedTextFieled(Node l, Node t) {
		l.setStyle("-fx-border-color: #d8d9e0;" +
				"-fx-border-width: 1;" +
				"-fx-border-radius: 50;" +
				"-fx-background-color:#d8d9e0;" +
				"-fx-background-radius: 50 0 0 50");

		t.setStyle("-fx-border-radius: 0 50 50 0;\n" +
				"-fx-font-size: 30;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				"-fx-background-color: #f6f6f6;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 0 50 50 0");
	}
	
	
	private void butoonEffect(Button b) {
		b.setStyle("-fx-border-radius: 25 25 25 25;\n" +
				"-fx-font-size: 25;\n" +
				"-fx-font-family: Times New Roman;\n" +
				"-fx-font-weight: Bold;\n" +
				" -fx-text-fill: #f2f3f4;\n"+
				"-fx-background-color: transparent;\n" +
				"-fx-border-color: #d8d9e0;\n" +
				"-fx-border-width:  3.5;" +
				"-fx-background-radius: 25 25 25 25");
		
		b.setOnMouseMoved(e ->{
			b.setStyle("-fx-border-radius: 25 25 25 25;\n" +
					"-fx-font-size: 25;\n" +
					"-fx-font-family: Times New Roman;\n" +
					"-fx-font-weight: Bold;\n" +
					" -fx-text-fill: #CE2029;\n"+
					"-fx-background-color: #d8d9e0;\n" +
					"-fx-border-color: #d8d9e0;\n" +
					"-fx-border-width:  3.5;" +
					"-fx-background-radius: 25 25 25 25");
		});

		b.setOnMouseExited(e ->{
			b.setStyle("-fx-border-radius: 25 25 25 25;\n" +
					"-fx-font-size: 25;\n" +
					"-fx-font-family: Times New Roman;\n" +
					"-fx-font-weight: Bold;\n" +
					" -fx-text-fill: #f2f3f4;\n"+
					"-fx-background-color: transparent;\n" +
					"-fx-border-color: #d8d9e0;\n" +
					"-fx-border-width:  3.5;" +
					"-fx-background-radius: 25 25 25 25");
		});

	}

	private void readFile() {
		//define files
		File customerInput = new File("Customers.txt");
		File mediaInput = new File("Medias.txt");
		File cartInput = new File("Carts.txt");
		File rentedInput = new File("Renteds.txt");
		String tok;
		// TO READ FROM FILES
		try {
			Scanner in = new Scanner(customerInput);
			if(customerInput.canRead()) {
				if(in.hasNext()) {	
					in.nextLine();
					in.nextLine();
					in.nextLine();
					in.nextLine();
				}
				while(in.hasNext()) {
					tok = in.nextLine();
					id = tok.substring((tok.indexOf("| ")+2), tok.indexOf(" | ")).trim();
					tok = tok.substring((tok.indexOf(id)), tok.length());
					tok = tok.substring((tok.indexOf("|")), tok.length());
					name = tok.substring((tok.indexOf("|")+2), tok.indexOf(" | ")).trim();
					tok = tok.substring((tok.indexOf(name)), tok.length());
					tok = tok.substring((tok.indexOf("|")), tok.length());
					mobile = tok.substring((tok.indexOf("|")+2), tok.indexOf(" | ")).trim();
					tok = tok.substring((tok.indexOf(mobile)), tok.length());
					tok = tok.substring((tok.indexOf("|")), tok.length());
					plan = tok.substring((tok.indexOf("|")+2), tok.indexOf(" | ")).trim();
					tok = tok.substring((tok.indexOf(plan)), tok.length());
					tok = tok.substring((tok.indexOf("|")), tok.length());
					address = tok.substring((tok.indexOf("|")+2), tok.lastIndexOf("|")).trim();
					dataBase.addCustomer(id, name, address, mobile, plan);
				} 
				in.close();
				try { 
					in = new Scanner(mediaInput);
					if(mediaInput.canRead()) {
						if(in.hasNext()) {								
							in.nextLine();
							in.nextLine();
						}
						while(in.hasNext()) {
							tok = in.nextLine();
							if( tok.contains("Album")) {
								code = tok.substring((tok.indexOf("Code = ")+7), tok.indexOf(","));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								title = tok.substring((tok.indexOf("Title = ")+8), tok.indexOf(","));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								copiesAvailable =  Integer.parseInt(tok.substring((tok.indexOf("Number Of Copies = ")+19), tok.indexOf(",")-1));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								artist = tok.substring((tok.indexOf("Artist=")+7), tok.indexOf(","));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								songs = tok.substring((tok.indexOf("Songs=")+6), tok.length()-1);
								dataBase.addAlbum(code,title, copiesAvailable, artist, songs);
							}
							else if( tok.contains("Movie")) {
								code = tok.substring((tok.indexOf("Code = ")+7), tok.indexOf(","));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								title = tok.substring((tok.indexOf("Title = ")+8), tok.indexOf(","));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								copiesAvailable =  Integer.parseInt(tok.substring((tok.indexOf("Number Of Copies = ")+19), tok.indexOf(",")-1));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								rating = tok.substring((tok.indexOf("Rate = ")+7), (tok.length()-1));
								dataBase.addMovie(code,title, copiesAvailable, rating);
							}
							else if( tok.contains("Game")) { 
								code = tok.substring((tok.indexOf("Code = ")+7), tok.indexOf(","));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								title = tok.substring((tok.indexOf("Title = ")+8), tok.indexOf(","));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								copiesAvailable =  Integer.parseInt(tok.substring((tok.indexOf("Number Of Copies = ")+19), tok.indexOf(",")-1));
								tok = tok.substring((tok.indexOf(",")+1), tok.length());
								weight = Double.parseDouble(tok.substring((tok.indexOf("Weight = ")+9), tok.lastIndexOf("]")));
								dataBase.addGame(code,title, copiesAvailable, weight);
							}
						} 
						in.close();
					}
					else
						System.out.println("| The File Medias.txt can't read. ");
				}
				catch (FileNotFoundException e) {
					System.out.println("| "+ e+ "\n| Error!! : File Medias.txt doesn't found. ");
				}
				try {
					in = new Scanner(cartInput);
					if(cartInput.canRead()) {
						if(in.hasNext()) {								
							in.nextLine();
							in.nextLine();
							in.nextLine();
							in.nextLine();
							while(in.hasNext()) {
								tok = in.nextLine();
								name = tok.substring((tok.indexOf("| ")+2), tok.indexOf(" |")).trim();
								title = tok.substring((tok.indexOf("[")+1), tok.indexOf("]"));
								if(!title.equalsIgnoreCase("")) {
									mediaTitle.removeAll(mediaTitle);
									String [] splt = title.split(",");
									for (int i = 0; i < splt.length; i++) {
										mediaTitle.add(splt[i].trim());
									}
									for (int i = 0; i < dataBase.getCustomer().size(); i++) {
										if(name.equals(dataBase.getCustomer().get(i).getName())) {										
											dataBase.getCustomer().get(i).setCart(mediaTitle);
										}
									}
								}
							}
						}
						in.close();
					}
					else
						System.out.println("| The File Carts.txt can't read. "); 
				}
				catch (FileNotFoundException e) {
					System.out.println("| "+ e+ "\n| Error!! : File Carts.txt doesn't found. ");
				}
				try {
					in = new Scanner(rentedInput);
					if(rentedInput.canRead()) {
						if(in.hasNext()) {								
							in.nextLine();
							in.nextLine();
							in.nextLine();
							in.nextLine();
							while(in.hasNext()) {
								tok = in.nextLine();
								name = tok.substring((tok.indexOf("| ")+2), tok.indexOf(" |")).trim();
								title = tok.substring((tok.indexOf("[")+1), tok.indexOf("]"));
								if(!title.equalsIgnoreCase("")) {
									rentSave.removeAll(rentSave);
									String [] splt = title.split(",");
									for (int i = 0; i < splt.length; i++) {
										rentSave.add(splt[i].trim());
									}
									for (int i = 0; i < dataBase.getCustomer().size(); i++) {
										if(dataBase.getCustomer().get(i).getName().equals(name)) {										
											dataBase.getCustomer().get(i).setRented(rentSave);
										}
									}
								}
							}
						}
						in.close();
					}
					else
						System.out.println("| The File Renteds.txt can't read. ");
				}
				catch (FileNotFoundException e) {
					System.out.println("| "+ e+ "\n| Error!! : File Renteds.txt doesn't found. ");
				}
			}else
				System.out.println("| The File Customers.txt can't read. ");
		}
		catch (FileNotFoundException e) {
			System.out.println("| "+ e+ "\n| Error!! : File Customers.txt doesn't found. ");
		}
	}

	private void writeFile() {
		PrintWriter output = null;
		try {
			output = new PrintWriter("Customers.txt");
			output.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->| CUSTOMERS |<--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
			output.println("|----------------------------------------------------------------------------------------------------------------------------------|");
			output.println("|      CUSTOMER ID      |     CUSTOMER NAME     |     CUSTOMER MOBILE     |     CUSTOMER PLAN     |             ADDRESS            |");
			output.println("|----------------------------------------------------------------------------------------------------------------------------------|");
			for (int i = 0; i < dataBase.getCustomer().size(); i++) {
				output.printf("| %-21s | %-21s | %-23s | %-21s | %-30s |\n",dataBase.getCustomer().get(i).getId(),dataBase.getCustomer().get(i).getName() ,dataBase.getCustomer().get(i).getMobile(),dataBase.getCustomer().get(i).getPlan() ,dataBase.getCustomer().get(i).getAddress() );
			}
			output.close();				

		} catch (FileNotFoundException e) {
			System.out.println("| "+ e+ " Error!! : File Customers.txt doesn't found. ");
		}
		try {
			output = new PrintWriter("Medias.txt");
			output.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->| MEDIA |<--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
			output.println("|--------------------------------------------------------------------------------------------------|");
			for (int i = 0; i < dataBase.getMedia().size(); i++) {
				if(dataBase.getMedia().get(i) instanceof Movie)
					output.println(dataBase.getMedia().get(i).toString());
				else if(dataBase.getMedia().get(i) instanceof Game)
					output.println(dataBase.getMedia().get(i).toString());
				else if(dataBase.getMedia().get(i) instanceof Album)
					output.println(dataBase.getMedia().get(i).toString());				
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("| "+ e+ " Error!! : File Medias.txt doesn't found. ");
		}
		try {
			output = new PrintWriter("Carts.txt");
			output.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->| CART |<--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
			output.println("|--------------------------------------------------------------------------------------------------------------|");
			output.println("|     CUSTOMER NAME     |                                         CART                                         |");
			output.println("|--------------------------------------------------------------------------------------------------------------|");
			for (int j = 0; j < dataBase.getCustomer().size(); j++) {
				output.printf("| %-21s | %-84s |\n" ,dataBase.getCustomer().get(j).getName(),dataBase.getCustomer().get(j).getCart());
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("| "+ e+ " Error!! : File Carts.txt doesn't found. ");
		}
		try {
			output = new PrintWriter("Renteds.txt");
			output.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->| RENTED |<--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
			output.println("|--------------------------------------------------------------------------------------------------------------|");
			output.println("|     CUSTOMER NAME     |                                        RENTED                                        |");
			output.println("|--------------------------------------------------------------------------------------------------------------|");
			for (int j = 0; j < dataBase.getCustomer().size(); j++) {
				output.printf("| %-21s | %-84s |\n" , dataBase.getCustomer().get(j).getName(), dataBase.getCustomer().get(j).getRented());
			}
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("| "+ e+ " Error!! : File Renteds.txt doesn't found. ");
		}
	}

}
