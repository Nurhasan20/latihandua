package com.example.latihandua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFakData()
        RecyclerView.layoutManager =LinearLayoutManager(this)
        RecyclerView.setHasFixedSize(true)
        RecyclerView.adapter = adapter(testData, { fakItem: data -> ItemClicked(fakItem)})
    }

    private fun ItemClicked(fakItem: data) {
        val showIntent = Intent(this, detail::class.java)
        showIntent.putExtra(Intent.EXTRA_TEXT, fakItem.namaFak.toString())
        showIntent.putExtra(Intent.EXTRA_TEMPLATE, fakItem.desFak.toString())
        showIntent.putExtra(Intent.EXTRA_REFERRER, fakItem.fotoFak.toString())
        showIntent.putExtra(Intent.ACTION_PICK, fakItem.web.toString())
        showIntent.putExtra(Intent.ACTION_CALL, fakItem.email.toString())
        startActivity(showIntent)
    }

    private fun createFakData() : List<data> {
        val partList = ArrayList<data>()
        partList.add(data("Fakultas Ilmu Komputer","Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Teknik Informatika\n" +
                "\t2. Prodi S1 Sistem Informasi\n" +
                "\t3. Prodi S1 Data Science", R.drawable.fik,"http://fik.upnjatim.ac.id/",""))

        partList.add(data("Fakultas Teknik", "Fakultas Teknik merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Teknik Kimia\n" +
                "\t2. Prodi S1 Teknik Industri\n" +
                "\t3. Prodi S1 Teknik Sipil\n" +
                "\t4. Prodi S1 Teknik Lingkungan\n" +
                "\t5. Prodi S1 Teknologi Pangan\n" +
                "\t6. Prodi S1 Teknik Mesin", R.drawable.ft,"http://ft.upnjatim.ac.id/",""))

        partList.add(data("Fakultas Ekonomi Dan Bisnis", "Fakultas Ekonomi Dan Bisnis merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                " \t1. Prodi S1 Ekonomi Pembangunan\n" +
                "\t2. Prodi S1 Akuntansi\n" +
                "\t3. Prodi S1 Manajemen", R.drawable.feb,"http://febis.upnjatim.ac.id/",""))

        partList.add(data("Fakultas Pertanian", "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Agroteknologi\n" +
                "\t2. Prodi S1 Agribisnis", R.drawable.fp,"http://fp.upnjatim.ac.id/",""))

        partList.add(data("Fakultas Arsitektur dan Desain", "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Arsitektur\n" +
                "\t2. Prodi S1 Desain Komunikasi Visual", R.drawable.fad,"http://fad.upnjatim.ac.id/",""))

        partList.add(data("Fakultas Ilmu Sosial dan Ilmu Politik", "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Ilmu Komunikasi\n" +
                "\t2. Prodi S1 Ilmu Administrasi Negara\n" +
                "\t2. Prodi S1 Ilmu Administrasi Bisnis\n" +
                "\t2. Prodi S1 Hubungan Internasional", R.drawable.fisip,"http://fisip.upnjatim.ac.id/","")
        )

        partList.add(data("Fakultas Hukum", "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n\n" +
                "\t1. Prodi S1 Ilmu Hukum\n", R.drawable.fh,"http://fhukum.upnjatim.ac.id/",""))

        partList.add(data("Nur Hasan ",
            "TTL\t\t\t\t\t\t\t\t: Surabaya, 20 Mei 2000\n" +
                    "ALAMAT\t\t\t\t\t: Jl. Setro Baru Utara X/7 Surabaya\n" +
                    "NO.HP\t\t\t\t\t\t\t: +62819-3928-4446\n" +
                    "E-MAIL\t\t\t\t\t\t: www.github.com/fchilmi\n\n" +
                    "RIWAYAT PENDIDIKAN\t:\n"+
                    "\t\t\tSDN Rangkah 6 Surabaya\n" +
                    "\t\t\tSMPN 9 Surabaya\n" +
                    "\t\t\tSMA Muhammadiyah 7 Surabaya\n\n" +
                    "PENGHARGAAN\t\t:", R.drawable.diri, "https://github.com/fchilmi","18082010017@student.upnjatim.ac.id"))
        return partList
    }
}


