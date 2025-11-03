# 🚀 Navio Application

Aplikasi ini dibuat untuk **Praktikum P4 – Menggunakan Navigasi Aplikasi**  
pada mata kuliah **Pemrograman Mobile**, di bawah bimbingan **Bapak Muhayat, M.IT**.  
Tujuan utama proyek ini adalah mempraktikkan konsep navigasi antar layar di Android  
menggunakan **Intent eksplisit** dan **Jetpack Compose Navigation** secara modern dan efisien.

---

## 👩‍💻 Identitas Mahasiswa
- **Nama:** Husna Norgina  
- **NIM:** 230104040056  
- **Kelas:** TI23B  
- **Tanggal Praktikum:** 15 Oktober 2025  

---

## 🎯 Tujuan Praktikum
1. Memahami konsep dasar navigasi antar Activity menggunakan Intent eksplisit.  
2. Mengirim dan menerima data antar Activity menggunakan Intent Extras.  
3. Menjelaskan cara kerja Activity Lifecycle saat perpindahan halaman.  
4. Mempelajari konsep Back Stack dan cara sistem mengelola urutan Activity.  
5. Mengimplementasikan navigasi bertingkat (multi-step).  
6. Menggunakan Jetpack Compose Navigation untuk navigasi modern dan efisien.  
7. Mengombinasikan Activity dengan Fragment dan Bottom Navigation.  
8. Menerapkan Fragment-to-Fragment navigation dengan Compose.  
9. Mengimplementasikan Material Design 3 (MD3) dalam elemen navigasi.  
10. Menerapkan lokalisasi, tema adaptif, dan penyimpanan preferensi (DataStore).  

---

## 🧰 Alat & Bahan

### 🖥️ Perangkat Keras (Hardware)
- Laptop x64 (RAM ≥ 8 GB disarankan)  
- Smartphone Android (USB Debug aktif) atau Emulator Android  

### ⚙️ Perangkat Lunak (Software)
- Android Studio **Narwhal | 2025.1.1**  
- **JDK 17** (bawaan Android Studio)  
- Android SDK: `compileSdk = 35`, `targetSdk = 35`, `minSdk = 24`  
- Android Emulator (API 34/35) atau perangkat fisik  
- Git (opsional untuk versioning)  

### 📚 Library & Tools Pendukung
- **Jetpack Compose + Material 3**  
  - androidx.compose:compose-bom:2024.10.01  
  - androidx.activity:activity-compose:1.9.3  
  - androidx.compose.material3:material3  
  - androidx.compose.material:material-icons-extended  
- **Navigation Compose** → androidx.navigation:navigation-compose:2.8.3  
- **Lifecycle** → androidx.lifecycle:lifecycle-runtime-compose:2.8.6  
- **DataStore (Preferences)** → androidx.datastore:datastore-preferences:1.1.1  
- **Tooling (Debug)** → ui-tooling, ui-test-manifest  
- **Kompiler Compose:** `kotlinCompilerExtensionVersion = 1.5.14`  
- Build Features: `compose true`  

---

## 🗂️ Struktur Proyek
- Semua UI dibuat dengan **Jetpack Compose** (folder `layout/` tidak digunakan).  
- Terdapat **12 layar** di package `screens/`:  
  - Home  
  - Activity A/B  
  - Activity C/D  
  - Back Stack Step 1–3  
  - Hub (Dashboard, Messages, Message Detail, Profile)  
- State persisten (tema, profil, prefill Name/NIM) melalui **DataStore** di `data/`  
- Navigasi dikelola melalui `nav/` (Routes + NavGraph)  
- Tema dan mode Light/Dark/System di `ui/theme/`  

---

## 🧠 Konsep yang Dipelajari
- Intent dan Intent Extras  
- Activity Lifecycle  
- Back Stack Management  
- Fragment-to-Fragment Navigation  
- Jetpack Compose Navigation Graph  
- Material Design 3 Implementation  
- Data Persistence (DataStore)  

---

## 🧩 Kesimpulan
1. Navigasi antar layar dapat dilakukan dengan **Intent eksplisit** atau **Jetpack Compose Navigation** untuk pendekatan yang lebih modern dan fleksibel.  
2. Pengiriman data antar layar bisa menggunakan **Intent Extras** atau **Route Arguments** dalam Compose.  
3. **Back Stack** mengatur urutan layar agar navigasi berjalan lancar.  
4. **Material Design 3 (MD3)** memberikan tampilan yang konsisten dan adaptif terhadap tema (Light, Dark, System).  
5. Praktikum ini memperkuat pemahaman tentang navigasi aplikasi Android yang **modular, efisien, interaktif, stabil, dan sesuai standar pengembangan terkini**.  

---

📅 *Dibuat oleh Husna Norgina – Praktikum Pemrograman Mobile P4 (Navio Application)*
