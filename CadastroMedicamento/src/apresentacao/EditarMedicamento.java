package apresentacao;

import Negocio.Medicamento;
import persistencia.ControlaMedicamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarMedicamento extends JFrame{
    private JTextField idMedicamento;
    private JTextField campoMedicamento;
    private JTextField dataF;
    private JTextField dataV;
    private JTextField Principio;
    private JTextField Unfa;
    private JTextField registroMs;
    private JButton SALVARButton;
    private JButton CANCELARButton;
    private JButton PROCURARButton;
    private JPanel MainPanel;
    private JPanel campoInfos;

    ControlaMedicamento cm;

    DateTimeFormatter formatado= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public EditarMedicamento(ControlaMedicamento cm){

    setContentPane(MainPanel);
    setTitle("Editar Medicamento");
    setLocationRelativeTo(null);
    setSize(700,500);



        PROCURARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                try{
                    int id = Integer.parseInt(idMedicamento.getText());
                    Medicamento med = cm.PesquisarMedicamento(id);
                    campoMedicamento.setText(med.getNome());
                    dataF.setText(med.getDataFabricacao().format(formatado));
                    dataV.setText(med.getDataValidade().format(formatado));
                    Principio.setText(med.getPrincipioAtivo());
                    registroMs.setText(med.getRegistroMs());
                    Unfa.setText(med.getUnidadeFarmaco());
                    campoInfos.setEnabled(true);
                    idMedicamento.setEnabled(false);



                } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null,"Medicamento não encontrado");
                       idMedicamento.setText("");
                    campoMedicamento.setText("");
                    dataF.setText("");
                    dataV.setText("");
                    Principio.setText("");
                    registroMs.setText("");
                    Unfa.setText("");

                    idMedicamento.setEnabled(true);
                    campoInfos.setEnabled(false);

                }


            }
        });
        SALVARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                int id = Integer.parseInt(idMedicamento.getText());
                Medicamento med = cm.PesquisarMedicamento(id);
                med.setNome(campoMedicamento.getText());
                med.setPrincipioAtivo(Principio.getText());
                med.setRegistroMs(registroMs.getText());
                med.setUnidadeFarmaco(Unfa.getText());
                med.setDataValidade(LocalDate.parse(dataV.getText(),formatado));
                med.setDataFabricacao(LocalDate.parse(dataF.getText(),formatado));

                JOptionPane.showMessageDialog(null,"Registros atualizados com sucesso");
                    idMedicamento.setText("");
                    campoMedicamento.setText("");
                    dataF.setText("");
                    dataV.setText("");
                    Principio.setText("");
                    registroMs.setText("");
                    Unfa.setText("");


                    idMedicamento.setEnabled(true);
                    campoInfos.setEnabled(false);

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"ERROR");

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



