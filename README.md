# Praktikum8-PBO
### Polimorfisme, Abstract, dan Interface  
A. Implementasi Polymorphism (Method Overriding)  
1. **`Hewan.java`**
```java
   public class Hewan {
    public void bersuara() {
        System.out.println("Hewan ini mengeluarkan suara yang tidak spesifik.");
    }
  }
```
- Berperan sebagai kelas induk (superclass) dari hierarki entitas hewan dan memiliki metode **`bersuara()`** dengan implementasi umum. jika subclass tidak mengubahnya, pesan umum ini yg akan dieksekusi.
2. **`Kucing.java`**
```java
public class Kucing extends Hewan{
    @Override // Anotasi opsional tapi direkomendasikan 
    public void bersuara(){
        System.out.println("Kucing: Meow meow!");
    }
}
```
- ini merupakan sublass yang mewarisi kelas **`Hewan`** menggunakan kata kunci **`extends`**
- Notasi **`@Override`** digunakan untuk menulis ulang metode **`bersuara`** agar             menghasilkan perilaku yg spesifik kucing yaitu **`"Kucing: Meow meow!"`**
  3. **`Anjing.java`**
```java
public class Anjing extends Hewan{
    @Override
    public void bersuara() {
        System.out.println("Anjing: Guk guk!");
    }
}
```
- Merupakan subclass lain yg juga mewarisi class **`Hewan`**
- **`@Override`** metode **`bersuara()`** untuk mencetak suara spesifik anjing yaitu **`"Anjing: Guk guk`**  
  4. **`PoliTester.java`**
  ```java
  public class PoliTester {
    public static void main(String[] args) {
        // Deklarasi array dari tipe Superclass, tetapi diisi dengan objek Subclass
        Hewan[] daftarHewan = new Hewan[3];
        daftarHewan[0] = new Hewan();
        daftarHewan[1] = new Kucing();//Upcasting
        daftarHewan[2] = new Anjing();
        
        //Polimorfisme: pemanggilan method yang sama menghasilkan output berbeda
        for (Hewan h : daftarHewan) {
            h.bersuara();
        }
    }
  ```
  - Class ini digunakan untuk menunjukan penerapan konsep Dynamic Binding atau polimorfisme    yang terjadi saat program dijalankan (Runtime)
  - Membuat array dengan tipe superclass **`(Hewan[] daftarHewan)`**, kemudian diisi dengan    objek dari kelas infuk maupun kelas turunannya, seperti **`Hewan`**, **`Kucing`**, dan      **`Anjing`** melalui proses upcasting
  - Menggunakan perulangan **`for`** untuk menjalankan metode **`bersuara()`** pada setiap     objek dengan cara yang sama, tetapi menghasilkan suara yg berbeda sesuai dengan jenis       objek yang dipanggil.
  B. 
