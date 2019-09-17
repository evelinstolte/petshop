/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import tela.manutencao.Manutencaopetshop;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
import dao.Daopetshop;
import javax.swing.JOptionPane;
import modelo.Petshop;
import tela.manutencao.Manutencaopetshop;

public class Controladorpetshop {

    public static void inserir(Manutencaopetshop man){
        Petshop objeto = new Petshop();
        objeto.setAvaliacao (Integer.parseInt(man.jtfavaliacao.getText()));
        objeto.setNumero (Integer.parseInt(man.jtfnumero.getText()));
        objeto.setEndereco(man.jtfendereco.getText());
        objeto.setNome(man.jtfnome.getText());
        
        boolean resultado = Daopetshop.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

   public static void alterar(Manutencaopetshop man){
        Petshop objeto = new Petshop();
        //definir todos os atributos
        objeto.setAvaliacao(Integer.parseInt(man.jtfavaliacao.getText()));
        objeto.setNumero(Integer.parseInt(man.jtfnumero.getText()));
        objeto.setEndereco(man.jtfendereco.getText());
        objeto.setNome(man.jtfnome.getText());
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText()));
        
        boolean resultado = Daopetshop.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(Manutencaopetshop man){
        Petshop objeto = new Petshop();
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = Daopetshop.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Avaliaçao");
        modelo.addColumn("Número");
        modelo.addColumn("Endereço");
        modelo.addColumn("Nome");
        modelo.addColumn("Código");
        
        List<Petshop> resultados = Daopetshop.consultar();
        for (Petshop objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getAvaliacao());
            linha.add(objeto.getNumero());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getNome());
            linha.add(objeto.getCodigo());
            
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}
