/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;

/**
 *
 * @author isabellaqv
 */
public class Cliente {
    String Nombre;
    int pedido;

    public Cliente(String Nombre, int pedido) {
        this.Nombre = Nombre;
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nombre=" + Nombre + ", pedido=" + pedido + '}';
    }
    
}
