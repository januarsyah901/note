Berikut adalah **struktur SQL lengkap** untuk web manajemen kontak sederhana, mencakup 3 tabel utama:

* `users` → Menyimpan data pengguna.
* `kategori` → Menyimpan kategori kontak (keluarga, teman, kerja, dll).
* `kontak` → Menyimpan detail kontak yang dimiliki oleh user dan dikelompokkan berdasarkan kategori.

---

### 📦 1. Struktur Tabel `users`

```sql
CREATE TABLE users (
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

### 🗂️ 2. Struktur Tabel `kategori`

```sql
CREATE TABLE kategori (
    id_kategori INT PRIMARY KEY AUTO_INCREMENT,
    nama_kategori VARCHAR(100) NOT NULL
);
```

---

### 📇 3. Struktur Tabel `kontak`

```sql
CREATE TABLE kontak (
    id_kontak INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT,
    id_kategori INT,
    nama_kontak VARCHAR(100) NOT NULL,
    nomor_hp VARCHAR(20),
    email_kontak VARCHAR(100),
    alamat TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_kategori) REFERENCES kategori(id_kategori) ON DELETE SET NULL
);
```

---

### 📌 Contoh Data Dummy (Opsional)

```sql
-- Insert user
INSERT INTO users (nama, email, password) VALUES
('Andi', 'andi@example.com', 'hashed_password');

-- Insert kategori
INSERT INTO kategori (nama_kategori) VALUES
('Keluarga'), ('Teman'), ('Pekerjaan');

-- Insert kontak
INSERT INTO kontak (id_user, id_kategori, nama_kontak, nomor_hp, email_kontak, alamat)
VALUES
(1, 1, 'Budi', '08123456789', 'budi@mail.com', 'Jl. Merpati No. 1'),
(1, 2, 'Citra', '08987654321', 'citra@mail.com', 'Jl. Kenanga No. 5');
```

---

### 🔍 Contoh Query untuk Menampilkan Kontak User

```sql
SELECT 
    k.id_kontak,
    k.nama_kontak,
    k.nomor_hp,
    k.email_kontak,
    k.alamat,
    kat.nama_kategori
FROM kontak k
JOIN kategori kat ON k.id_kategori = kat.id_kategori
WHERE k.id_user = 1;
```

---

Kalau kamu ingin versi **REST API backend** (misal pakai Laravel atau Go) atau **fitur tambahan** seperti favorit, pencarian, pagination, atau multi-user access, bilang saja ya!
