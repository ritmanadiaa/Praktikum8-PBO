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
