### ✅ SLIDE 1: Alur Login (AuthController & LoginFrame)

#### Judul Slide:

> **Alur Login: Validasi & Navigasi User**

#### Konten Slide:

* Input username & password
* Validasi via `AuthController`
* Redirect ke: `AdminFrame` atau `CashierFrame`

#### Visual:

Diagram flow:

```
LoginFrame
   ↓  (input user/pass)
AuthController.login()
   ↓  (query ke DB)
   → return User atau null
       ↓
+--------------------------+
| if (admin) → AdminFrame |
| if (kasir) → CashierFrame |
+--------------------------+
```

#### Script Dialog:

"Slide pertama ini membahas proses login. Saat pengguna memasukkan username dan password di `LoginFrame`, proses validasi diteruskan ke `AuthController`. Kalau data cocok, user akan diarahkan ke tampilan yang sesuai: kasir atau admin."

---

### ✅ SLIDE 2: Struktur Folder & Penerapan MVC

#### Judul Slide:

> **Struktur Folder Rapi & Penerapan Pola MVC**

#### Konten Slide:

* Ilustrasi tree folder
* Highlight:

  * `src/` sebagai source utama
  * Folder `controller`, `model`, `view`, `util`
  * Catatan kecil: “Struktur ini memudahkan maintainability & scalability”

#### Visual:

```
src/
├── Main.java
├── controller/
│   ├── AuthController.java
│   └── ProductController.java
├── model/
│   ├── User.java
│   └── Product.java
├── view/
│   ├── LoginFrame.java
│   ├── AdminFrame.java
│   └── CashierFrame.java
├── util/
│   └── DatabaseConnection.java
```

#### Script Dialog:

"Struktur folder ini udah pakai arsitektur MVC. Di controller kita kelola logika, di model ada class data, view untuk UI-nya, dan util buat koneksi database. Dengan ini, pengembangan jadi lebih rapi dan scalable."

---

### ✅ SLIDE 3: Flow AdminFrame (Overview)

#### Judul Slide:

> **AdminFrame: Tampilan Admin & Akses Produk**

#### Konten Slide:

* Menampilkan daftar produk
* Tombol untuk tambah/edit/hapus produk
* Tombol logout dan refresh

#### Visual:

Mockup GUI:

```
+------------------------------------------------------+
| [ Admin Panel ]         [ Logout ] [ Refresh ]       |
|------------------------------------------------------|
| ID | Name       | Price     | Stock | Created At     |
|------------------------------------------------------|
| 1  | Kaos Polo  | 100000.00 | 12    | 2024-01-01     |
| ...                                                |
|------------------------------------------------------|
| [Add] [Edit] [Delete]                                |
+------------------------------------------------------+
```

#### Script Dialog:

"AdminFrame digunakan oleh admin untuk mengelola produk. Di sini ada tabel yang menampilkan seluruh produk dan tombol aksi di bagian bawah untuk tambah/edit/hapus."

---

### ✅ SLIDE 4: Flow loadProducts() (Read Produk)

#### Judul Slide:

> **Menampilkan Daftar Produk dari Database**

#### Konten Slide:

* Method `loadProducts()` di AdminFrame
* Panggil `ProductController.getAllProducts()`
* Isi JTable menggunakan `DefaultTableModel`

#### Visual:

```
AdminFrame.loadProducts()
   ↓
ProductController.getAllProducts()
   ↓
Query: SELECT * FROM products
   ↓
Loop ResultSet → List<Product>
   ↓
Isi JTable
```

#### Script Dialog:

"loadProducts ini dijalankan setiap kali frame dibuka atau tombol refresh ditekan. Dia akan ambil semua data dari DB lewat ProductController, lalu ditampilkan ke tabel di GUI."

---

### ✅ SLIDE 5: Flow Add Product

#### Judul Slide:

> **Menambah Produk Baru**

#### Konten Slide:

* Event tombol `Add`
* Tampilkan input dialog (nama, harga, stok)
* Validasi input
* Eksekusi query INSERT

#### Visual:

```
[Add] button → showAddProductDialog()
   ↓
Input Nama, Harga, Stok
   ↓
ProductController.addProduct(...)
   ↓
Query: INSERT INTO products (...)
   ↓
loadProducts()
```

#### Script Dialog:

"Saat admin menekan tombol Add, akan muncul form untuk input produk baru. Data dikirim ke controller lalu disimpan ke DB. Setelah itu tampilan tabel otomatis di-refresh."

---

### ✅ SLIDE 6: Flow Edit Product

#### Judul Slide:

> **Mengubah Data Produk**

#### Konten Slide:

* Tombol `Edit`
* Ambil row yang dipilih
* Tampilkan form dengan data awal
* Update DB

#### Visual:

```
[Edit] button → showEditProductDialog()
   ↓
Ambil ID produk
   ↓
ProductController.updateProduct(...)
   ↓
Query: UPDATE products SET ...
   ↓
loadProducts()
```

#### Script Dialog:

"Fitur Edit ini memungkinkan admin memperbarui informasi produk. ID produk tetap, hanya nama, harga, atau stok-nya aja yang bisa diubah."

---

### ✅ SLIDE 7: Flow Delete Product

#### Judul Slide:

> **Menghapus Produk**

#### Konten Slide:

* Tombol `Delete`
* Konfirmasi sebelum hapus
* Eksekusi DELETE dari database

#### Visual:

```
[Delete] button → konfirmasi JOptionPane
   ↓
ProductController.deleteProduct(id)
   ↓
Query: DELETE FROM products WHERE id = ?
   ↓
loadProducts()
```

#### Script Dialog:

"Untuk menghindari kesalahan, admin akan diminta konfirmasi dulu sebelum menghapus produk. Jika setuju, maka produk akan dihapus dari database dan tampilan di-refresh."

---

### ✅ SLIDE 8: Flow Logout (Admin)

#### Judul Slide:

> **Logout & Kembali ke Login**

#### Konten Slide:

* Klik tombol `Logout`
* Dispose current frame
* Tampilkan LoginFrame

#### Visual:

```
Logout button
   ↓
AuthController.logout()
   ↓
new LoginFrame()
   ↓
AdminFrame.dispose()
```

#### Script Dialog:

"Fitur logout memungkinkan admin atau kasir keluar dari sesi aplikasi dengan aman. Arahannya akan kembali ke tampilan login awal."

---

### ✅ SLIDE 9: Flow CashierFrame (Kasir Mode)

#### Judul Slide:

> **Kasir: Menambahkan Produk ke Transaksi**

#### Konten Slide:

* Kasir memilih produk dari list
* Input jumlah beli
* Klik `Tambah`
* Hitung subtotal dan total

#### Visual:

```
CashierFrame:
  [Tabel Produk] → Pilih
     ↓
  Input Jumlah → Tambah ke Tabel Transaksi
     ↓
  subtotal = harga * jumlah
     ↓
  total = sum(subtotal)
```

#### Script Dialog:

"CashierFrame dipakai oleh kasir untuk mencatat pembelian. Produk dipilih dari list, jumlahnya diinput, lalu dimasukkan ke daftar transaksi dengan total harga yang terus dihitung otomatis."

---

### ✅ SLIDE 10: Flow CashierFrame (Lanjutan)

#### Judul Slide:

> **Melihat Seluruh Riwayat Transaksi Kasir**

#### Konten Slide:

* Klik tombol "Riwayat"
* Menampilkan `TransactionHistoryFrame`
* Menampilkan tabel semua transaksi (ID, Kasir, Tanggal, Total)
* Klik satu transaksi → tampilkan detail transaksi (produk, harga, qty, subtotal)

#### Visual:

```
[Riwayat] button
   ↓
new TransactionHistoryFrame()
   ↓
loadTransactions() → TransactionController.getTransactionsHistory()
   ↓
Tabel atas: semua transaksi
   ↓
Klik salah satu → showTransactionDetails()
   ↓
Tabel bawah: detail produk di transaksi tersebut
```

#### Script Dialog:

"Kasir juga bisa melihat semua transaksi yang pernah dilakukan lewat tombol Riwayat. Frame ini akan menampilkan daftar transaksi dan juga rincian item yang dibeli saat transaksi tersebut. Cocok untuk verifikasi atau cetak ulang data."

---
