Berikut adalah jawaban untuk soal-soal di atas berdasarkan materi yang diberikan (CPMK1, CPMK2, dan CPMK5). Saya akan menjawab secara singkat dan jelas sesuai dengan konteks soal.
1. Materi Uji CPMK1 (Bobot: 10%)
a) Jelaskan apa yang dimaksud dengan basis data!
Basis data adalah kumpulan data yang terorganisasi, biasanya disimpan dan dikelola dalam sistem komputer untuk memudahkan akses, pengelolaan, dan analisis data secara efisien.
b) Jelaskan fungsi dari basis data pada sistem komputer!
Fungsi basis data pada sistem komputer meliputi:  
Menyimpan data secara terstruktur.  
Memungkinkan pengambilan data yang cepat dan akurat.  
Menjaga integritas dan keamanan data.  
Mendukung pengolahan data untuk kebutuhan aplikasi.
2. Materi Uji CPMK2 (Bobot: 10%)
a) Jelaskan apa itu basis data relasional dan ERD!  
Basis data relasional adalah jenis basis data yang menyimpan data dalam bentuk tabel yang saling berhubungan melalui kunci (key).  
ERD (Entity-Relationship Diagram) adalah diagram yang menggambarkan hubungan antara entitas (tabel) dalam basis data, termasuk entitas, atribut, dan relasi.
b) Sebutkan dan jelaskan komponen-komponen penyusun basis data relasional!
Komponen basis data relasional:  
Tabel: Tempat penyimpanan data, terdiri dari baris dan kolom.  
Kolom (Atribut): Menyimpan jenis data tertentu (misalnya, nama, harga).  
Baris (Record): Satu entri data dalam tabel.  
Kunci (Key): Digunakan untuk mengidentifikasi baris secara unik (primary key, foreign key).  
Relasi: Hubungan antar tabel melalui kunci.
c) Jelaskan langkah-langkah pembuatan ERD dengan contoh kasus sistem akademik mahasiswa mengambil kelas mata kuliah!
Langkah-langkah pembuatan ERD:  
Identifikasi Entitas: Misalnya, Mahasiswa, Mata Kuliah, dan Kelas.  
Tentukan Atribut: Mahasiswa (NIM, Nama), Mata Kuliah (Kode_MK, Nama_MK), Kelas (ID_Kelas, Hari).  
Definisikan Relasi: Mahasiswa "Mengambil" Kelas, Mata Kuliah "Diajarkan" di Kelas.  
Buat Diagram: Gambar entitas sebagai kotak, hubungkan dengan garis untuk relasi, dan tambahkan atribut.  
Contoh: Mahasiswa (NIM, Nama) --- Mengambil ---> Kelas (ID_Kelas, Hari) <--- Diajarkan --- Mata Kuliah (Kode_MK, Nama_MK).
3. Materi Uji CPMK5 (Bobot: 10%)
a) Jelaskan perbedaan dari DDL dan DML! (Catatan: perbedaan, bukan definisi)  
DDL (Data Definition Language) digunakan untuk mendefinisikan atau mengubah struktur database (seperti CREATE, ALTER), sedangkan DML (Data Manipulation Language) digunakan untuk mengelola data di dalam tabel (seperti INSERT, UPDATE, DELETE).  
DDL mengubah skema database, sedangkan DML hanya memengaruhi data tanpa mengubah struktur.
b) Tulis contoh perintah SQL untuk membuat sebuah tabel dengan empat kolom:
(i) Terdapat primary key
(ii) Tipe data ada yang numerik (integer) dan ada yang karakter (varchar)
(iii) Terdapat setting nilai default minimal untuk salah satu kolomnya
(iv) Dan keempat kolom tidak boleh berisi nilai null!  
Contoh perintah SQL:  
sql
CREATE TABLE Barang (
    ID_Barang INTEGER PRIMARY KEY NOT NULL,
    Nama_Barang VARCHAR(50) NOT NULL,
    Harga INTEGER DEFAULT 1000 NOT NULL,
    Kategori VARCHAR(30) NOT NULL
);
ID_Barang sebagai primary key (integer, not null).  
Nama_Barang bertipe varchar, not null.  
Harga bertipe integer dengan default 1000, not null.  
Kategori bertipe varchar, not null.
c) Tulis contoh perintah SQL memasukkan tiga baris data ke dalam tabel yang telah dibuat!
Menggunakan tabel Barang dari poin (b):  
sql
INSERT INTO Barang (ID_Barang, Nama_Barang, Harga, Kategori) VALUES 
(1, 'Laptop', 5000, 'Elektronik'),
(2, 'Buku', 200, 'Alat Tulis'),
(3, 'Mouse', 150, 'Aksesoris');
d) Berikan contoh perintah SQL untuk menampilkan data dengan menggunakan aggregate function dan pengurutan (order by)!
Contoh perintah SQL:  
sql
SELECT Kategori, COUNT(*) AS Jumlah_Barang
FROM Barang
GROUP BY Kategori
ORDER BY Jumlah_Barang DESC;
Menggunakan COUNT(*) sebagai fungsi agregasi untuk menghitung jumlah barang per kategori.  
GROUP BY Kategori mengelompokkan data berdasarkan kolom Kategori.  
ORDER BY Jumlah_Barang DESC mengurutkan hasil berdasarkan jumlah barang secara menurun.
Semoga jawaban ini membantu! Jika ada yang perlu diperjelas, beri tahu saya.
