# 📱 Praktikum 4 — Menggunakan Navigasi Aplikasi

Praktikum ini membahas **penerapan navigasi aplikasi Android** menggunakan **Activity**, **Intent**, dan **Jetpack Compose Navigation**. Fokus utama praktikum adalah memahami **perpindahan antar layar**, **pengiriman data antar Activity**, **pengelolaan Back Stack**, serta **kombinasi Activity dan Fragment** melalui **Bottom Navigation**. Aplikasi dikembangkan sepenuhnya menggunakan **Jetpack Compose** dengan pendekatan modern dan **Material Design 3 (MD3)**.

**Topik:** App Navigation, Intent, Back Stack, Jetpack Compose Navigation, Activity & Fragment, Material Design 3

---

## 🧑‍🎓 Informasi Mahasiswa

| Informasi          | Data                                                          |
| ------------------ |---------------------------------------------------------------|
| Mata Kuliah        | Pemrograman Mobile                                            |
| Dosen Pengampu     | Muhayat, M.IT                                                 |
| Praktikum / Proyek | P4 – Menggunakan Navigasi Aplikasi                            |
| Nama Mahasiswa     | Husna Norgina                                                 |
| NIM                | 230104040056                                                  |
| Kelas              | TI23B                                                         |
| Repo GitHub        | https://github.com/husna-norgina/p4appnavigation_230104040056 |
| Tanggal Praktikum  | 15-10-2025                                                    |

---

## 🎯 Tujuan Praktikum

1. Memahami konsep navigasi antar **Activity** menggunakan **Intent eksplisit**.
2. Mengirim dan menerima data antar Activity menggunakan **Intent Extras**.
3. Memahami **Activity Lifecycle** saat perpindahan halaman.
4. Mempelajari konsep **Back Stack** pada Android.
5. Mengimplementasikan **navigasi bertingkat (multi-step)**.
6. Menggunakan **Jetpack Compose Navigation** untuk navigasi modern.
7. Mengombinasikan **Activity dan Fragment** dalam satu aplikasi.
8. Menerapkan **Fragment-to-Fragment navigation** berbasis Compose.
9. Menggunakan **Material Design 3 (MD3)**.
10. Menerapkan **tema adaptif (Light, Dark, System)** dan **DataStore**.

---

## 🛠 Tools & Environment

* Android Studio (Narwhal | 2025.1.1)
* Android SDK (compileSdk 35, targetSdk 35, minSdk 24)
* Bahasa pemrograman Kotlin
* Jetpack Compose & Material 3
* Navigation Compose
* Android Emulator / Real Device
* Git & GitHub

---

## 🧱 Struktur Aplikasi

Aplikasi dikembangkan sepenuhnya menggunakan **Jetpack Compose**, dengan struktur utama sebagai berikut:

* **Homescreen.kt** — Halaman utama navigasi aplikasi
* **ActivityA_B.kt** — Navigasi Activity A ke B menggunakan Intent
* **ActivityC_D.kt** — Pengiriman & penerimaan data antar Activity
* **BackStackScreens.kt** — Simulasi Back Stack (Step 1–3)
* **HubScreens.kt** — Dashboard, Messages, Message Detail, Profile
* **NavGraph & Routes** — Pengelolaan alur navigasi
* **DataStore & ViewModel** — Penyimpanan state & preferensi
* **Theme (MD3)** — Light, Dark, dan System Theme

---

## 🧩 Implementasi Praktikum

### 🔹 Navigasi Activity (Intent)

Perpindahan antar Activity dilakukan menggunakan **Intent eksplisit**, termasuk pengiriman data melalui **Intent Extras**.

### 🔹 Jetpack Compose Navigation

Navigasi modern diterapkan menggunakan **NavHostController** dan **Route Arguments**.

### 🔹 Back Stack

Aplikasi memvisualisasikan proses **penambahan, penghapusan, dan pembersihan Back Stack** melalui navigasi bertahap.

### 🔹 Activity + Fragment

Struktur aplikasi modular dengan **Bottom Navigation** yang menampung beberapa Fragment dalam satu Activity.

---

## 📸 Screenshot Praktikum

Berikut merupakan hasil implementasi aplikasi **Navio** pada **Praktikum 4 – Menggunakan Navigasi Aplikasi**:

**Gambar 1.** Screen Utama (Homescreen.kt)
![Screen Utama](evidence/1.%20Screen%20Utama%20(Homescreen.kt).jpg)

**Gambar 2.** Screen Activity A (ActivityA_B.kt)
![Screen Activity A](evidence/2.%20Screen%20Activity%20A%20(ActivityA_B.kt).jpg)

**Gambar 3.** Screen Activity B (ActivityA_B.kt)
![Screen Activity B](evidence/3.%20Screen%20Activity%20B%20(ActivityA_B.kt).jpg)

**Gambar 4.** Screen Activity C (ActivityC_D.kt)
![Screen Activity C](evidence/4.%20Screen%20Activity%20C%20(ActivityC_D.kt).jpg)

**Gambar 5.** Screen Activity D (ActivityC_D.kt)
![Screen Activity D](evidence/5.%20Screen%20Activity%20D%20(ActivityC_D.kt).jpg)

**Gambar 6.** Screen Stack Step 1 (BackStackScreens.kt)
![Back Stack Step 1](evidence/6.%20Screen%20Stack%20Step%201%20(BackStackScreens.kt).jpg)

**Gambar 7.** Screen Stack Step 2 (BackStackScreens.kt)
![Back Stack Step 2](evidence/7.%20Screen%20Stack%20Step%202%20(BackStackScreens.kt).jpg)

**Gambar 8.** Screen Stack Step 3 (BackStackScreens.kt)
![Back Stack Step 3](evidence/8.%20Screen%20Stack%20Step%203%20(BackStackScreens.kt).jpg)

**Gambar 9.** Screen Dashboard Fragment (HubScreens.kt)
![Dashboard Fragment](evidence/9.%20Screen%20Dasboard%20Fragment%20(HubScreens.kt).jpg)

**Gambar 10.** Screen Messages Fragment (HubScreens.kt)
![Messages Fragment](evidence/10.%20Screen%20Messages%20Fragment%20(HubScreens.kt).jpg)

**Gambar 11.** Screen Message Detail (HubScreens.kt)
![Message Detail](evidence/11.%20Screen%20Message%20Detail%20(HubScreens.kt).jpg)

**Gambar 12.** Screen Profile Fragment (HubScreens.kt)
![Profile Fragment](evidence/12.%20Screen%20Profile%20Fragment%20(HubScreens.kt).jpg)

---

## 📄 Laporan Praktikum 4

[230104040056_Husna Norgina_P4.pdf](evidence/230104040056_Husna%20Norgina_P4.pdf)

> Semua screenshot dan laporan praktikum disimpan pada folder:  
> 📂 `./evidence/`

---

## 📊 Analisis Praktikum

* Navigasi antar Activity berhasil diimplementasikan menggunakan Intent.
* Pengiriman data antar Activity berjalan dengan baik.
* Back Stack dikelola sesuai alur navigasi aplikasi.
* Jetpack Compose Navigation mempermudah pengelolaan layar.
* Tampilan aplikasi konsisten dengan Material Design 3.
* Aplikasi berjalan stabil di emulator maupun perangkat fisik.

---

## ✅ Kesimpulan

Berdasarkan hasil **Praktikum 4 – Menggunakan Navigasi Aplikasi**, dapat disimpulkan bahwa navigasi merupakan komponen penting dalam pengembangan aplikasi Android. Melalui penerapan Intent, Back Stack, dan Jetpack Compose Navigation, aplikasi dapat memiliki alur perpindahan layar yang terstruktur, modular, dan modern. Praktikum ini memberikan pemahaman mendalam mengenai pengelolaan navigasi sebagai dasar pengembangan aplikasi Android yang kompleks.

---

## 📌 Catatan

* Praktikum dikerjakan sesuai modul pembelajaran.
* Seluruh fitur navigasi berhasil diimplementasikan.
* Dokumentasi dilakukan secara sistematis melalui screenshot.
* Proyek ini dibuat untuk keperluan pembelajaran.

---

📝 *Disusun oleh Husna Norgina (230104040056) — Praktikum 4 Pemrograman Mobile*

