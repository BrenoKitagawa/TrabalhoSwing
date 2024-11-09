package apresentacao;

import Negocio.Medicamento;
import persistencia.ControlaMedicamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Principal extends JFrame{
    private JTextField TMedicamento;
    private JTextField TDataFabricacao;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JTextArea tResultado;
    private JPanel MainPanel;
    private JTextField TPrincipioAtivo;
    private JTextField TDataValidade;
    private JList Jlist1;
    private JButton mostrarTudoButton;
    private JTextField UnidadeFarmaco;
    private JTextField RegistroMs;
    private JButton EDITARButton;
    private JButton EXCLUIRButton;

    ControlaMedicamento cm = new ControlaMedicamento();
//    DefaultListModel model = new DefaultListModel();




    public void limparCampos(){
        TMedicamento.setText("");
        TPrincipioAtivo.setText("");
        TDataFabricacao.setText("");
        TDataValidade.setText("");
        TMedicamento.requestFocus();
        UnidadeFarmaco.setText("");
        RegistroMs.setText("");
    }
    DateTimeFormatter formatado= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Principal(){


        setContentPane(MainPanel);
        setTitle("Cadastro de Medicamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700,450);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 if ((!"".equals(TMedicamento.getText())) && (!"".equals(TPrincipioAtivo.getText())) && (!"".equals(TDataFabricacao.getText())) && (!"".equals(TDataValidade.getText())) && (!"".equals(RegistroMs.getText())) && (!"".equals(UnidadeFarmaco.getText()))) {
                     Medicamento medicamento = new Medicamento();

                     int id =   Medicamento.getProximoIdMedicamento();
                     medicamento.setId(id);
                     medicamento.setNome(TMedicamento.getText());
                     medicamento.setPrincipioAtivo(TPrincipioAtivo.getText());
                     medicamento.setDataFabricacao(LocalDate.parse(TDataFabricacao.getText(),formatado));
                     medicamento.setDataValidade(LocalDate.parse(TDataValidade.getText(),formatado));
                     medicamento.setUnidadeFarmaco(UnidadeFarmaco.getText());
                     medicamento.setRegistroMs(RegistroMs.getText());


                     if(cm.addMedicamento(medicamento)){
                         JOptionPane.showMessageDialog(null, "Medicamento cadastrado com sucesso!");
                         limparCampos();
                         tResultado.setText(String.valueOf(cm.mostrarMedicamentos()));

                         /*model.addElement(String.valueOf(cm.mostrarMedicamentos()));

                         Jlist1.setModel(model);*/
                     }else {
                         JOptionPane.showMessageDialog(null, "Erro ao cadastrar medicamento!");
                         limparCampos();
                     }

                 } else {
                     JOptionPane.showMessageDialog(null, "Prenchimento Obrigatório dos campos!");
                     limparCampos();
                 }
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        mostrarTudoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DLMostrarMedicamentos dlg =new DLMostrarMedicamentos(cm);
                dlg.setVisible(true);
            }
        });
        EDITARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarMedicamento editarMedicamento= new EditarMedicamento(cm);
                editarMedicamento.setVisible(true);


            }
        });
        EXCLUIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirMedicamento excluirMe= new excluirMedicamento(cm);
                excluirMe.setVisible(true);
            }
        });
    }


}
