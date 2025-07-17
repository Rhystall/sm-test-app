---

# SM Test App

Android native app menggunakan Kotlin dengan XML Views yang terdiri dari 3 layar:

1. **First Screen:** Input nama dan kalimat, cek palindrome dengan tombol Check dan navigasi ke layar kedua.
2. **Second Screen:** Menampilkan nama pengguna, label nama user terpilih, dan tombol pilih user.
3. **Third Screen:** List user dari API dengan pagination dan pull-to-refresh, pilih user akan update label di layar kedua.

## Fitur

* Cek palindrome sederhana dengan dialog hasil
* Navigasi antar fragment menggunakan Jetpack Navigation Component
* Mendapatkan data user dari API [https://reqres.in](https://reqres.in) dengan Retrofit dan Gson
* Menampilkan list user dengan RecyclerView dan Paging 3
* Pull to refresh dan loading pagination otomatis
* Menampilkan empty state jika data kosong
* Material Design Components untuk UI konsisten
* Custom font Poppins global di seluruh aplikasi

## Teknologi

* Kotlin
* Jetpack Navigation Component + Safe Args
* ViewModel + Kotlin Coroutines + Flow
* Retrofit2 + Gson Converter
* RecyclerView + Paging 3 Library
* SwipeRefreshLayout
* Glide (untuk loading gambar avatar)
* CircleImageView (de.hdodenhof)
* Material Components
* Gradle dengan Version Catalog
* Minimum SDK 21, Target SDK 34

## Cara Build dan Run

1. Clone repository
2. Buka di Android Studio Arctic Fox ke atas
3. Sinkronisasi Gradle dan pastikan SDK sudah lengkap
4. Jalankan aplikasi di emulator atau device dengan minimum SDK 21

## Struktur Project

* `fragment.FirstFragment` - layar input dan cek palindrome
* `fragment.SecondFragment` - layar welcome dan pilih user
* `fragment.ThirdFragment` - layar list user dengan pagination
* `adapter.UserAdapter` - RecyclerView adapter untuk user list
* `viewmodel.UserViewModel` - ViewModel untuk paging dan data user
* `network` - Retrofit API service dan model data

## Catatan

* Pastikan koneksi internet aktif untuk load data API
* Font Poppins sudah di-set global di tema aplikasi
* UI mengikuti desain dari prototipe Figma

---