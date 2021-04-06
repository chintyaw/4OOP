# 4OOP
A UNO Game 'HIJI' Project with Object Oriented Programming (Java)

## How to Run
Jalankan program dengan run Main.java.

Compile
```bash
javac Game/Main.java
```
Run
```bash
java Game.Main
```

## Playing
1. Permainan dimulai dengan tampilan awal yang berisi kalimat pembuka dan juga list dari command - command yang bisa mereka gunakan pada permainan. Setelah itu juga terdapat instruksi untuk memasukkan command yang ingin dimasukkan.  <br />
2. Permainan dimulai ketika user memanggil command Start. Selanjutnya pengguna akan ditanya total pemain sekaligus namanya. Jumlah pemain harus berada di antara 2 hingga 6 pemain. Masing-masing pemain akan mendapatkan 7 kartu secara acak sekaligus mengambil satu kartu angka sebagai kartu acuan awal. Pemain giliran pertama akan di-random secara acak.
3. Perintah ViewPlayerTurn berfungsi untuk melihat giliran pemain saat ini dan pemain yang memiliki giliran selanjutnya.
4. Perintah CardList berfungsi untuk melihat seluruh kartu milik masing-masing pemain.
5. Perintah Playerlist adalah perintah yang digunakan untuk menampilkan nama pemain serta jumlah kartu yang dimiliki. PlayerList juga menampilkan status giliran pemain.
6. Perintah Discard berfungsi untuk mengeluarkan kartu yang dimiliki pemain giliran. Pemain dapat men-discard lebih dari satu kartu dalam sekali kesempatan bermain namun harus sama persis.
7. Perintah Draw berfungsi untuk mengambil satu kartu secara acak dari tumpukan deck Kartu. Pemain dapat melakukan discard satu kali saat kartu yang diambil valid.
8. Perintah HIJI berfungsi untuk mencegah pemain yang kartunya tersisa 1 untuk mendapatkan 2 kartu tambahan. Perintah HIJI harus diketik oleh pemain maksimal 3 detik setelah kartunya tersisa 1 buah saat gilirannya. Apabila pemain tidak mengetik HIJI, maka ia akan mendapatkan 2 kartu tambahan.
9. Perintah Help berfungsi untuk menyediakan bantuan - bantuan dalam game berupa informasi dari permainan. Bantuan terdiri dari beberapa petunjuk yang terbagi menjadi 4 kategori. Petunjuk yang ditampilkan disesuaikan dengan pilihan input user.

## Contributors
Kelompok 4: 4OOP <br />
18219031 Elisabeth Gunawan <br />
18219061 Gian Denggan Benjamin <br />
18219082 Chintya Wijaya <br />
18219094 Muhammad Ichsandro D Noor <br />
18219114 Parnaek Routther Siagian <br />
