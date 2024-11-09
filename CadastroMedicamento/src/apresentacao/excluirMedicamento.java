package apresentacao;

import Negocio.Medicamento;
import persistencia.ControlaMedicamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class excluirMedicamento extends JFrame{
    private JTextField idMedicamento;
    private JTextField nomeMedicamento;
    private JTextField registroMs;
    private JButton pesquisarButton;
    private JButton EXCLUIRButton;
    private JButton CANCELARButton;
    private JPanel MainPanel;

    ControlaMedicamento cm;

    public excluirMedicamento(ControlaMedicamento cm){
        setContentPane(MainPanel);
        setTitle("excluir Medicamento");
        setLocationRelativeTo(null);
        setSize(700,300);


        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int id = Integer.parseInt(idMedicamento.getText());
                    Medicamento med = cm.PesquisarMedicamento(id);
                    nomeMedicamento.setText(med.getNome());
                    registroMs.setText(med.getRegistroMs());

                    idMedicamento.setEnabled(false);

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Medicamento não encontrado");
                    nomeMedicamento.setText("");
                    registroMs.setText("");
                    idMedicamento.setEnabled(true);
                }





            }
        });
        EXCLUIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(idMedicamento.getText());

                try{
                cm.RemoverMedicamento(id);
                JOptionPane.showMessageDialog(null,"Medicamento removido com sucesso");
                nomeMedicamento.setText("");
                registroMs.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Medicamento não encontrado");
                    nomeMedicamento.setText("");
                    registroMs.setText("");
                }



            }
        });
        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}
