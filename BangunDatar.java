/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum8;

/**
 *
 * @author HP
 */
public abstract class BangunDatar {
    String warna;
    
    public BangunDatar(String warna) {
        this.warna = warna;
    }
    
    // Abstract metod: Tidak memiliki isi, wajib di-override subclass
    public abstract double hitungLuas();
    
    //Concrete method: punya isi, bisa langsung dipakai
    public void cetakWarna() {
        System.out.println("Warna bangun ini adalah: " + warna);
    }
}
