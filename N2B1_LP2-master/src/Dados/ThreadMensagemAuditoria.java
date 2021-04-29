/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class ThreadMensagemAuditoria extends Thread {

    private boolean status;

    @Override
    public void run() {
        setStatus(true);
        while (status) {
            try {
                String msg = Auditoria.getInstancia().retiraMsgAuditoria();
                if (msg != null) {
                    enviaMensagemParaSistemaAuditoria(msg);
                }
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadMensagemAuditoria.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ThreadMensagemAuditoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setStatus(boolean value) {
        status = value;
    }

    private void enviaMensagemParaSistemaAuditoria(String msg) throws InterruptedException, IOException {
        System.out.printf("%s - Valor %s\n", Instant.now().toString(), msg);
        FileWriter file = new FileWriter("./src/Auditoria.txt", true);
                            file.write(msg);
                            file.close();
        Thread.sleep(500);
    }
}
