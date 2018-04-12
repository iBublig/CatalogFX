package ru.netcracker.ibublig.client.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.netcracker.ibublig.client.view.model.Category;
import ru.netcracker.ibublig.client.view.model.Item;

public class CatalogController {

    private ObservableList<Item> items = FXCollections.observableArrayList();
    private ObservableList<Category> categories = FXCollections.observableArrayList();

    @FXML
    private ListView<String> listView = new ListView<>();
    @FXML
    private TextField serchField;
    @FXML
    private TableView categoryTableView;
    @FXML
    private TableColumn<Item, String> categoryNameTableColumn;
    @FXML
    private TableColumn<Item, String> categoryDescriptionTableColumn;
    @FXML
    private TableColumn<Item, String> categoryCostTableColumn;
    @FXML
    private TableColumn<Item, String> categoryCountTableColumn;

    @FXML
    private void initialize(){
        //TODO Добавить метод который обращается к серверу за XML
        //XML xml = new XML(items);
        //xml.loadPersonDataFromFile(new File("C:\\Data","Catalog.xml"));

        testData();

        categoryNameTableColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        categoryDescriptionTableColumn.setCellValueFactory(param -> param.getValue().descriptionProperty());
        categoryCostTableColumn.setCellValueFactory(param -> param.getValue().costProperty());
        categoryCountTableColumn.setCellValueFactory(param -> param.getValue().countProperty());
        categoryTableView.setItems(items);

        }
//        //Зачем то создавал, трогать не буду
//        final ObservableList<String> test = FXCollections.observableArrayList();
//
//        for (int i = 0; i < items.size(); i++) {
//            test.add(items.get(i).getName());
//            //System.out.println(test.get(i));
//        }
//
//        listView.setItems(test);

    private void testData(){
        Category telephone = new Category("Телефон");
        telephone.addItems(new Item("Samsung Galaxy J1","Супер телефон 1","1000","5"));
        telephone.addItems(new Item("Samsung Galaxy J3","Супер телефон 2","1000","5"));
        telephone.addItems(new Item("Samsung Galaxy J5","Супер телефон 3","1000","5"));
        telephone.addItems(new Item("Samsung Galaxy J7","Супер телефон 4","1000","5"));
        telephone.addItems(new Item("Ифон С15","Какое то описание","1000000","5"));
        categories.add(telephone);

        Category notebook = new Category("Ноутбук");
        notebook.addItems(new Item("Acer","laptop","15","35"));
        categories.add(notebook);
        }
}
