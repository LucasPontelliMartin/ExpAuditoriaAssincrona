/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Pc
 */
public class SalvarDados {
    
    public void SalvarProdutos (String conteudo, String nomeArquivo ) throws IOException{
        
        Auditoria.getInstancia().ativar();
        String mensagem = "";
        
        if (nomeArquivo == "Produtos") {
            FileWriter file = new FileWriter("./src/Produtos.txt", true);
                            file.write("\n" + conteudo);
                            file.close();
 
        }
        else if (nomeArquivo == "ProdutosInsumo") {
            FileWriter file = new FileWriter("./src/ProdutosInsumo.txt", true);
                            file.write("\n" + conteudo);
                            file.close();
        }
        
        mensagem = conteudo + " Cadastrado em " + nomeArquivo + ".txt - " + new Date(System.currentTimeMillis());
        Auditoria.getInstancia().adicionaMsgAuditoria("\n Auditoria - " + mensagem);
    }
}
