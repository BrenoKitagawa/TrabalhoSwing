package persistencia;

import Negocio.Medicamento;

import javax.swing.*;
import java.util.ArrayList;

public class ControlaMedicamento {
    private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();

    public boolean addMedicamento(Medicamento m){
        if(m != null){
            medicamentos.add(m);
            return true;
        }else{
            return false;
        }
    }

    public Medicamento PesquisarMedicamento(int id) {

        for(int i = 0; i <= medicamentos.size(); i++) {
            if (medicamentos.get(i).getId().equals(id)) {
                return medicamentos.get(i);
            }
        };
        return  null;

    };



    public void RemoverMedicamento(int id){
        for(int i = 0; i <= medicamentos.size(); i++) {
            if (medicamentos.get(i).getId().equals(id)){
                    medicamentos.remove(i);
            }
        };

    }

    public ArrayList<Medicamento> mostrarMedicamentos() {
        return medicamentos;
    }

    @Override
    public String toString() {
        return "" + medicamentos;
    }
}
