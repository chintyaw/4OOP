package Help;

public class Help{
    public Help(){

    }
    public static void HelpMenu(){
        System.out.println ("Hello HIJI Player!");
        System.out.println ("Game HIJI adalah permainan yang diadaptasi dari permainan kartu UNO");
        System.out.println ();
        System.out.println ("KETENTUAN PERMAINAN:");
        System.out.println ("1) HIJI dimainkan oleh 2-6 pemain.");
        System.out.println ("2) Di awal permainan, semua pemain akan mendapatkan 7 buah kartu, dan satu kartu angka dipilih secara acak untuk");
        System.out.println ("   dijadikan kartu awal.");
        System.out.println ("3) Pemain yang akan memulai giliran pertama akan diacak.");
        System.out.println ("4) Aturan permainan adalah sebagai berikut");
        System.out.println ("   a) Pada setiap giliran, pemain boleh mengeluarkan satu atau lebih kartu yang dapat dimainkan pada giliran tersebut.");
        System.out.println ("      Ketentuan kartu apa saja yang boleh dikeluarkan ada pada tabel Jenis Kartu.");
        System.out.println ("   b) Apabila pemain tidak mengeluarkan kartu, pemain wajib mengambil satu kartu dari deck.");
        System.out.println ("   c) Apabila kartu yang baru diambil tersebut bisa dikeluarkan, pemain boleh mengeluarkan kartu tersebut (tidak wajib).");
        System.out.println ("   d) Apabila kartu tersebut tidak dapat dimainkan, maka giliran diselesaikan tanpa mengeluarkan kartu.");
        System.out.println ("5) Beberapa jenis kartu memiliki power tertentu yang dapat memengaruhi jalannya permainan (lihat di bagian selanjutnya).");
        System.out.println ("6) Apabila pemain memiliki sisa satu kartu, maka pemain harus melakukan “Declare HIJI” dalam waktu 3 detik. Apabila tidak,");
        System.out.println ("   pemain wajib mengambil dua kartu dari deck.");
        System.out.println ("7) Pemain dinyatakan menang apabila kartu yang dipegangnya sudah habis, dan permainan selesai.");
        System.out.println ();
        System.out.println ("PERINTAH:");
        System.out.println ("+--------------------+-------------------------------------------------------------------------------------------+");
        System.out.println ("|  COMMAND           |     KETERANGAN                                                                            |");
        System.out.println ("+--------------------+-------------------------------------------------------------------------------------------+");
        System.out.println ("|Start Game          | Memulai permainan                                                                         |");
        System.out.println ("|List Card           | Lihat kartu di tangan pemain yang sedang giliran                                          |");
        System.out.println ("|Discard             | Mengeluarkan kartu dari tangan                                                            |");
        System.out.println ("|Draw                | Mengambil kartu dari deck                                                                 |");
        System.out.println ("|Declare HIJI        | - Wajib diinputkan dalam waktu 3 detik oleh pemain yang sedang giliran dan                |");
        System.out.println ("|                    |   memiliki sisa 1 kartu di tangan. Jika tidak, ambil 2 kartu dari deck                    |");
        System.out.println ("|                    | - Apabila pemain melakukan Declare HIJI pada saat kartu di tangan lebih dari satu, maka   |");
        System.out.println ("|                    |   pemain wajib mengambil 2 kartu dari deck.                                               |");
        System.out.println ("|List Players        | Melihat semua nama pemain, jumlah kartunya, dan apakah sedang dalam giliran               |");
        System.out.println ("|View Player in Turn | Melihat pemain yang sedang dalam giliran dan siapa pemain selanjutnya                     |");
        System.out.println ("|Help                | Melihat deskripsi aturan permainan                                                        |");
        System.out.println ("+--------------------+-------------------------------------------------------------------------------------------+");
        System.out.println ();
        System.out.println ("JENIS KARTU:");
        System.out.println ("+--------------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ("| NO   |  JENIS KARTU      |            DAPAT KELUAR JIKA                  |    POWER                            |");
        System.out.println ("+--------------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ("| 1    | Angka 0-9 warna   | Kartu yang dimainkan sebelumnya berwarna sama | -                                   |");
        System.out.println ("|      | Merah/Hijau/      | atau memiliki angka yang sama                 |                                     |");
        System.out.println ("|      | Kuning/Biru/      |                                               |                                     |");
        System.out.println ("+------+-------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ("| 2    | DrawTwo warna     | Kartu yang dimainkan sebelumnya berwarna sama | Pemain selanjutnya harus mengambil  |");
        System.out.println ("|      | Merah/Hijau/      | atau juga kartu DrawTwo                       | 2 kartu. Apabila pemain tersebut    |");
        System.out.println ("|      | Kuning/Biru/      |                                               | mengeluarkan DrawTwo, maka pemain   |");
        System.out.println ("|      |                   |                                               | selanjutnya mengambil 4, dan        |");
        System.out.println ("|      |                   |                                               | seterusnya. Pemain yang mengambil   |");
        System.out.println ("|      |                   |                                               | kartu tambahan kehilangan gilirannya|");
        System.out.println ("|      |                   |                                               | dan dilewati.                       |");
        System.out.println ("+------+-------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ("| 3    | DrawFour          | Kapanpun                                      | Pemain selanjutnya harus mengambil  |");
        System.out.println ("|      |                   |                                               | 4 kartu, dan pemain yg mengeluarkan |");
        System.out.println ("|      |                   |                                               | kartu DrawFour dapat memilih warna  |");
        System.out.println ("|      |                   |                                               | yang dapat dimainkan selanjutnya.   |");
        System.out.println ("+------+-------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ("| 4    | Wildcard          | Kapanpun                                      | Pemain dapat memilih warna yang     |");
        System.out.println ("|      |                   |                                               | dapat dikeluarkan oleh pemain       |");
        System.out.println ("|      |                   |                                               | selanjutnya.                        |");
        System.out.println ("+------+-------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ("| 5    | Reverse warna     | Kartu yang dimainkan sebelumnya berwarna sama | Urutan pemain dibalik.              |");
        System.out.println ("|      | Merah/Hijau/      | atau juga kartu Reverse                       |                                     |");
        System.out.println ("|      | Kuning/Biru/      |                                               |                                     |");
        System.out.println ("+------+-------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ("| 6    | Skip warna        | Kartu yang dimainkan sebelumnya berwarna sama | Pemain selanjutnya dilewati         |");
        System.out.println ("|      | Merah/Hijau/      | atau juga kartu Skip                          | (kehilangan giliran).               |");
        System.out.println ("|      | Kuning/Biru/      |                                               |                                     |");
        System.out.println ("+------+-------------------+-----------------------------------------------+-------------------------------------+");
        System.out.println ();
        System.out.println ("MULTIPLE DISCARD:");
        System.out.println ("Apabila suatu pemain memiliki lebih dari satu kartu yang sama persis, pemain tersebut dapat mengeluarkan semua");
        System.out.println ("atau sebagian kartu tersebut dalam satu giliran. Apabila kartu tersebut memiliki power, maka:");
        System.out.println ("   1) Untuk kartu DrawTwo, pemain selanjutnya akan mengambil kartu sebanyak dua kali jumlah kartu yang dikeluarkan");
        System.out.println ("   2) Untuk kartu DrawFour, pemain selanjutnya akan mengambil kartu sebanyak empat kali jumlah kartu yang dikeluarkan");
        System.out.println ("      Namun, pemain yang mengeluarkan hanya dapat memilih satu warna saja");
        System.out.println ("   3) Untuk kartu Skip, jumlah pemain yang dilewati sesuai dengan jumlah kartu Skip yang dikeluarkan.");
        System.out.println ("   4) Untuk kartu Reverse, urutan akan membolak-balik sesuai jumlah kartu. Misalnya ada dua kartu Reverse,");
        System.out.println ("      maka urutan pemain tidak berubah.");
        System.out.println ("   5) Untuk kartu Wildcard, pemain tetap hanya dapat memilih satu warna.");
    }
}
