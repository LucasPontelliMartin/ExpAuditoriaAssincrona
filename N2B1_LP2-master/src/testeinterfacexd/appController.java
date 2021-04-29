/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeinterfacexd;


import Dados.Auditoria;
import Dados.SalvarDados;
import Model.ProdutoModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author LENOVO
 */
public class appController implements Initializable {
    
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnAgenda;
    @FXML
    private Pane paneSelected;
    @FXML
    private ImageView imgAgendaBlue;
    @FXML
    private ImageView imgInicioBlue;
    @FXML
    private ImageView imgClienteBlue;
    @FXML
    private Button btnCliente;
    @FXML
    private ImageView imgVendasBlue;
    @FXML
    private Button btnVendas;
    @FXML
    private ImageView imgEstoqueBlue;
    @FXML
    private Button btnEstoque;
    @FXML
    private ImageView imgFinanceiroBlue;
    @FXML
    private Button btnFinanceiro;
    @FXML
    private Pane paneEstoque1;
    @FXML
    private ImageView imgAddProd;
    @FXML
    private Pane paneNovoProd;
    @FXML
    private TableView<ProdutoModel> tbConsumoCliente;
    @FXML
    private TableColumn<ProdutoModel, String> clmCodigo;
    @FXML
    private TableColumn<ProdutoModel, String> clmCategoria;
    @FXML
    private TableColumn<ProdutoModel, String> clmProduto;
    @FXML
    private TableColumn<ProdutoModel, String> clmQuantidade;
    @FXML
    private TableColumn<ProdutoModel, String> clmPrecoCusto;
    @FXML
    private TableColumn<ProdutoModel, String> clmPrecoVenda;
    @FXML
    private TableView<ProdutoModel> tbInsumo;
    @FXML
    private TableColumn<ProdutoModel, String> clmCodigoInsummo;
    @FXML
    private TableColumn<ProdutoModel, String> clmProdutoInsumo;
    @FXML
    private TableColumn<ProdutoModel, String> clmQuantidadeInsumo;
    @FXML
    private TableColumn<ProdutoModel, String> clmPrecoCustoInsumo;
    @FXML
    private ComboBox<String> cmbTipoProd;   
    @FXML
    private ComboBox<String> cmbCategoriaProd;
    @FXML
    private TextField txtNomeProd;
    @FXML
    private TextField txtPrecoCusto;
    @FXML
    private TextField txtPrecoVenda;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private Button btnSalvar;
    
    Alert a = new Alert(AlertType.NONE);
    @FXML
    private ImageView imgInicio;
    @FXML
    private ImageView imgAgenda;
    @FXML
    private ImageView imgCliente;
    @FXML
    private ImageView imgVendas;
    @FXML
    private ImageView imgEstoque;
    @FXML
    private ImageView imgFinanceiro;
    @FXML
    private ImageView imgSair;
    @FXML
    private ImageView imgInsumo;
    @FXML
    private Button btnLimpar;
    @FXML
    private Pane paneInicio;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cmbTipoProd.getItems().addAll("Cliente", "Insumos");
        cmbCategoriaProd.getItems().addAll("Bebida", "Comida");
                
        cmbTipoProd.getEditor().setFont(Font.font("System", FontWeight.BLACK, 20));
        
        btnAgenda.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(455);
            
            btnInicio.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnAgenda.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(true);
            imgInicioBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false);        
        });
        
        btnInicio.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(400);
            
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnInicio.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgInicioBlue.setVisible(true);
            imgClienteBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
            
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(true);  
            
        });
        
        btnCliente.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(510);
            
            btnAgenda.setTextFill(Color.BLACK);
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnCliente.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgClienteBlue.setVisible(true);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false);  
        });
        
        btnVendas.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(578);
            
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);

            btnVendas.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgVendasBlue.setVisible(true);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false);  
            
        });
       
        btnEstoque.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(632);
            
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnEstoque.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(true);
            imgFinanceiroBlue.setVisible(false);
            
            paneEstoque1.setVisible(true);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false);  
            initTable();
            initTableInsumo();
        });
        
        btnFinanceiro.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(693);
            
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            
            btnFinanceiro.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(true);
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false);  
        });
        
        /**/
  
       imgAddProd.setOnMouseClicked((Event event) -> {
           paneEstoque1.setVisible(false);
           paneNovoProd.setVisible(true);
        });
       
       cmbTipoProd.setOnAction((ActionEvent event) -> {
           if ("Insumos".equals(cmbTipoProd.getValue())) {
               cmbCategoriaProd.setDisable(true);
               txtPrecoVenda.setEditable(false);
           }
           else{
               cmbCategoriaProd.setDisable(false);
               txtPrecoVenda.setEditable(true);
           }               
        });
       
        btnSalvar.setOnAction((ActionEvent event) -> {
            try {
                SalvarDados salvar = new SalvarDados();
                if (null == cmbTipoProd.getValue()) {
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText("Selecione o tipo do produto!");
                    a.show();
                }
                
                else switch (cmbTipoProd.getValue()) {
                    case "Cliente":
                        {
                            String conteudo = "0510" + " - " + cmbCategoriaProd.getValue() + " - " + txtNomeProd.getText() + " - " + txtQuantidade.getText() + " - " + txtPrecoCusto.getText() + " - " + txtPrecoVenda.getText();
                            
                            salvar.SalvarProdutos(conteudo, "Produtos");
                            
                            
                            a.setAlertType(AlertType.CONFIRMATION);
                            a.setHeaderText("Produto Cadastrado!");
                            a.show();
                            paneEstoque1.setVisible(true);
                            paneNovoProd.setVisible(false);
                            break;
                        }
                    case "Insumos":
                        {
                            String conteudo = "0510" + " - " + txtNomeProd.getText() + " - " + txtQuantidade.getText() + " - " + txtPrecoCusto.getText();
                            
                            salvar.SalvarProdutos(conteudo, "ProdutosInsumo");
                            
                            
                            a.setAlertType(AlertType.CONFIRMATION);
                            a.setHeaderText("Produto Cadastrado!");
                            a.show();
                            paneEstoque1.setVisible(true);
                            paneNovoProd.setVisible(false);
                            break;
                        }
                    default:
                        a.setAlertType(AlertType.ERROR);
                        a.setHeaderText("Selecione o tipo do produto!");
                        a.show();
                        paneEstoque1.setVisible(true);
                        paneNovoProd.setVisible(false);
                        break;
                }
                
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Erro ao cadastrar o produto, verifique os campos!");
            }
        });
       
    }
      
    public void initTable(){

                clmCodigo.setCellValueFactory(new PropertyValueFactory("id"));
                clmCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
                clmProduto.setCellValueFactory(new PropertyValueFactory("produto"));
                clmQuantidade.setCellValueFactory(new PropertyValueFactory("quantidade"));
                clmPrecoCusto.setCellValueFactory(new PropertyValueFactory("valorCusto"));
                clmPrecoVenda.setCellValueFactory(new PropertyValueFactory("valorVenda"));
                
                tbConsumoCliente.setItems(atualizaTabela());
    }
    
    public ObservableList<ProdutoModel> atualizaTabela (){
        List<ProdutoModel> dados = new ArrayList<>();

        File arquivo = new File("./src/Produtos.txt" );
        if (arquivo.exists()) {
            String dadosConta[] = new String[6];
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                    
                dadosConta = (in.readLine().split(Pattern.quote(" - ")));
                    
                ProdutoModel prod = new ProdutoModel();
                prod.setId("        " + dadosConta[0]);
                prod.setCategoria("    " + dadosConta[1]);
                prod.setProduto("      " + dadosConta[2]);
                prod.setQuantidade("        " + dadosConta[3]);
                prod.setValorCusto("        " + dadosConta[4]);
                prod.setValorVenda("        " + dadosConta[5]);
                dados.add(prod);
                }
                in.close();
            } catch (IOException ex) {
            
        }
        } else {
            System.out.println("Erro na leitura do arquivo.");
        }        // TODO add your handling code here:

                
            return  FXCollections.observableArrayList(dados);   
    }
    
    
      
    public void initTableInsumo(){

                clmCodigoInsummo.setCellValueFactory(new PropertyValueFactory("id"));
                clmProdutoInsumo.setCellValueFactory(new PropertyValueFactory("produto"));
                clmQuantidadeInsumo.setCellValueFactory(new PropertyValueFactory("quantidade"));
                clmPrecoCustoInsumo.setCellValueFactory(new PropertyValueFactory("valorCusto"));
                
                tbInsumo.setItems(atualizaTabelaInsumo());
    }
    
    public ObservableList<ProdutoModel> atualizaTabelaInsumo (){
        List<ProdutoModel> dados = new ArrayList<>();

        File arquivo = new File("./src/ProdutosInsumo.txt" );
        if (arquivo.exists()) {
            String dadosConta[] = new String[4];
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                    
                dadosConta = (in.readLine().split(Pattern.quote(" - ")));
                    
                ProdutoModel prod = new ProdutoModel();
                prod.setId("        " + dadosConta[0]);
                prod.setProduto("      " + dadosConta[1]);
                prod.setQuantidade("        " + dadosConta[2]);
                prod.setValorCusto("        " + dadosConta[3]);
                dados.add(prod);
                }
                in.close();
            } catch (IOException ex) {
            
        }
        } else {
            System.out.println("Erro na leitura do arquivo.");
        }        // TODO add your handling code here:

                
            return  FXCollections.observableArrayList(dados);   
    }
    
}
