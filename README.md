# Praktikum8-PBO
## Polimorfisme, Abstract, dan Interface  
### A. Implementasi Polymorphism (Method Overriding)  
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
- Merupakan subclass lain yg juga mewarisi class **`Hewan`** dan **`@Override`** metode **`bersuara()`** untuk mencetak suara spesifik anjing yaitu **`"Anjing: Guk guk`**  
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
  - Membuat array dengan tipe superclass **`(Hewan[] daftarHewan)`**, kemudian diisi dengan    objek dari kelas infuk maupun kelas turunannya,       seperti **`Hewan`**, **`Kucing`**, dan      **`Anjing`** melalui proses upcasting
  - Menggunakan perulangan **`for`** untuk menjalankan metode **`bersuara()`** pada setiap     objek dengan cara yang sama, tetapi menghasilkan       suara yg berbeda sesuai dengan jenis objek yang dipanggil.  
  ### B. Implementasi Abstract Class
  1. **`BangunDatar.java`**
  ```java
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
  ```  
- Menggunakan kata kunci **`abstract`** untuk mendefinisikan kelas abstrak yang tidak bisa dibuat   menjadi objek secara langsung.
- Mempunyai atribut **`warna`** serta konstruktor yang berfungsi untuk memberikan nilai awal pada atribut tersebut.
- Menyediakan abstract method **`hitungLuas()`** tanpa implementasi, sehingga kelas turunannya harus memberikan isi metode melalui proses *override*
- Memiliki concrete method **`cetakWarna()`** yang sudah dilengkapi implementasi dan dapat digunakan langsung oleh kelas turunan tanpa perlu mendefinisikannya kembali.  
2. **`Lingkaram.java`**  
```java
public class Lingkaran extends BangunDatar {
    private double jariJari;
    
    public Lingkaran(String warna, double jariJari){
        super(warna);
        this.jariJari = jariJari;
    }
    
    @Override
    public double hitungLuas(){
        return Math.PI * jariJari * jariJari;
    }
}
```  
- Merupakan subclass yang mewarisi kelas abstrak **`BangunDatar`**
- Menambahkan atribut khusus berupa **`jariJari`**
- Menggunakan keyword **`super(warna)`** untuk memanggil konstruktor yang ada di kelas        induknya yaitu **`BangunDatar`**
- Wajib meng-override metode **`hitungLuas()`** untuk menghitung rumus luas lingkaran         secara spesifik yaitu **`Math.PI * jariJari * jariJari`**. Jika metode ini tidak di-        override, IDE akan menampilkan pesan error.  
3. **`TesBangunDatar`**
```java
public class TesBangunDatar {
    public static void main(String[] args) {
        Lingkaran lingkaran = new Lingkaran("Merah", 5);

        lingkaran.cetakWarna();
        System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
    }
}
```  
- **`public class TesBangunDatar`**: Mendefinisikan kelas utama (main class) yang digunakan untuk menjalankan program pengujian atau eksekusi utama.
- **`public static void main(String[] args)`**: Merupakan metode utama *(main method)* yang pertama kali akan dieksekusi oleh Java ketika program dijalankan.
- **`Lingkaran lingkaran = new Lingkaran("Merah", 5);`**: Membuat objek baru dari class **`Lingkaran`** dengan nama variabel **`lingkaran`**. Konstruktor ini mengirimkan dua argumen, yaitu **`"Merah"`** sebagai warna bangun datar dan **`5`** sebagai panjang jari-jari lingkaran.
- **`lingkaran.cetakWarna();`**: Memanggil metode **`cetakWarna()`** yang diwarisi oleh kelas Lingkaran dari kelas abstrak induknya yaitu **`BangunDatar`**. Metode ini menghasilkan output **`"Warna bangun ini adalah: Merah"`**.
- **`System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());`**: Memanggil metode **`hitungLuas()`** yang telah di-override di dalam kelas Lingkaran. Metode ini menghitung luas lingkaran menggunakan rumus, kemudian outputnya akan ditampilkan bersama teks **`"Luas lingkaran: "`**  
### C. Implementasi Interface (Multi Implementation)  
1. **`AlatElektronik.java`**
```java
public interface AlatElektronik {
    void nyalakan();
    void matikan();
}
```
- **`public interface AlatElektronik`** : untuk mendefinisikan kontrak untuk perangkat elektronik
- terdapat dua tanda tangan metode *(method signatures)* tanpa bodi yaitu **`nyalakan()`** dan **`matikan()`**  
2. **`Kamera.java`**
```java
public interface Kamera {
    void ambilFoto();
}
```
- **`public interface Kamera`** : untuk mendefinisikan kontrak khusus untuk perangkat yang memiliki kemampuan fotografi dan berisi satu metode yaitu **`ambilFoto()`**  
3. **`Smartphone,java`**
```java
public class Smartphone implements AlatElektronik, Kamera {
    private String merk;
    
    public Smartphone(String merk) {
        this.merk = merk;
    }
    
    @Override
    public void nyalakan() {
        System.out.println(merk + " menyala. Booting OS...");
    }
    
    @Override
    public void matikan() {
        System.out.println(merk + " dimatikan. Goodbye.");
    }
    
    @Override
    public void ambilFoto() {
        System.out.println("Cekrek! Foto berhasil disimpan di galeri " + merk + ".");
    }
}
```
- **`public class Smartphone implements AlatElektronik, Kamera`** : menunjukan bahwa kelas **`Smartphone,java`** wajib memenuhi semua aturan yg ada pada interface **`AlatElektronik`** maupun **`Kamera``**
- Memiliki atribut **`private String merk`** untuk menyimpan informasi merek dari smartphone
- Konstruktor **`public Smartphone(String merk)`** digunakan untuk menginisialisasi nilai atribut **`merk`** saat objek baru dibuat.
- Menggunakan anotasi **`@Override`** pada metode **`nyalakan()`** untuk mengisi metode bawaan dari interface **`AlatElektronik`** kemudian mencetak teks yang menyatakan perangkat menyala dan melakukan booting sistem
- Meng-override metode **`matikan()`** dari interface **`AlatElektronik`** dan mencetak teks konfirmasi bahwa perangkat dimatikan
- Meng-override metode **`ambilFoto()`** dari interface Kamera kemudian mencetak teks simulasi pengambilan foto dan penyimpanan ke dalam galeri perangkat berdasarkan mereknya.  
4. **`TesSmartphone.java`**  
```java
public class TesSmartphone {
    public static void main(String[] args) {
        Smartphone hp = new Smartphone("Samsung");

        hp.nyalakan();
        hp.ambilFoto();
        hp.matikan();
    }
}
```  
- **`public class TesSmartphone`**: untuk mendefinisikan kelas utama (main class) yang berfungsi untuk menjalankan program pengujian (testing) terhadap kelas **`Smartphone`**
- **`public static void main(String[] args)`**: merupakan metode utama (main method) tempat eksekusi program Java dimulai ketika dijalankan.
- **`Smartphone hp = new Smartphone("Samsung");`**: Membuat objek baru dari class **`Smartphone`** dengan nama variabel **`hp`**. Pada saat instansiasi, argumen **`"Samsung"`** dikirimkan ke konstruktor untuk mengisi atribut **`merk`** pada objek tersebut
- **`hp.nyalakan();`**: untuk memanggil metode **`nyalakan()`** yang telah di-override di dalam kelas Smartphone (berasal dari kontrak interface **`AlatElektronik`**). Kode ini akan mencetak pesan ke layar bahwa perangkat dengan merek Samsung menyala dan melakukan booting OS.
- **`hp.ambilFoto();`**: untuk memanggil metode **`ambilFoto()`** yang di-override dari interface **`Kamera`**. Metode ini mencetak teks simulasi bahwa foto berhasil diambil dan disimpan ke galeri perangkat.
- **`hp.matikan();`**: Memanggil metode **`matikan()`** dari interface **`AlatElektronik`** untuk mencetak pesan konfirmasi bahwa perangkat dimatikan.
  
