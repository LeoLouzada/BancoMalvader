package util;

import model.Conta;

import java.io.*;
import java.util.List;

public class DataManager {

    public static void salvarContas(List<Conta> contas, String filename){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(contas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Conta> carregarContas(String filename){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            return (List<Conta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
