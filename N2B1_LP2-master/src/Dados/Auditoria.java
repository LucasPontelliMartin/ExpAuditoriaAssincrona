/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class Auditoria {
    
    ConcurrentLinkedQueue<String> filaMensagens;
    
    private static Auditoria instancia;
    
     private Auditoria() {
        filaMensagens = new ConcurrentLinkedQueue<>();
        //filaMensagens = new LinkedList<>();
    }
     
    public static Auditoria getInstancia() {
        if (instancia == null) {
            instancia = new Auditoria();
        }
        return instancia;
    }

    /* Fim da implementação do Singleton */
    ThreadMensagemAuditoria thread;

    public void adicionaMsgAuditoria(String msgAuditoria) {
        filaMensagens.add(msgAuditoria);
    }

    String retiraMsgAuditoria() {
        String msg = filaMensagens.poll();
        return msg;
    }
    
    void ativar(){
        if (thread == null){
            thread = new ThreadMensagemAuditoria();
            thread.start();
        }
    }
    
    void desativar(){
        if (thread != null) {
            thread.setStatus(false);
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (thread.isAlive())
                thread.interrupt();
        }
    } 
}
