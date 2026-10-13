package com.example.ktgk_2415053122129_nguyenminhnghia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvThongTinChiTiet_129: TextView
    private lateinit var btnQuayLai_129: Button

    private var khoanChiHienTai_129 = KhoanChi(
        maKhoanChi = "KC_129",
        tenKhoanChi = "Khoản chi mẫu",
        soTien = 150000.0,
        loaiChi = "Khác",
        ghiChu = "Không có",
        daThanhToan = true
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Nguyễn Minh Nghĩa - 2415053122129 - Quản lý chi tiêu cá nhân"

        tvThongTinChiTiet_129 = findViewById(R.id.tvThongTinChiTiet_129)
        btnQuayLai_129 = findViewById(R.id.btnQuayLai_129)

        val intentTen = intent.getStringExtra("TEN_KHOAN_CHI")
        val intentSoTien = intent.getDoubleExtra("SO_TIEN", -1.0)
        val intentLoaiChi = intent.getStringExtra("LOAI_CHI") ?: "Khác"
        val intentGhiChu = intent.getStringExtra("GHI_CHU")

        if (!intentTen.isNullOrBlank() && intentSoTien > 0) {
            khoanChiHienTai_129.tenKhoanChi = intentTen
            khoanChiHienTai_129.soTien = intentSoTien
            khoanChiHienTai_129.loaiChi = intentLoaiChi
            if (intentGhiChu != null) khoanChiHienTai_129.ghiChu = intentGhiChu
        }

        tvThongTinChiTiet_129.text = khoanChiHienTai_129.layThongTin_129()

        btnQuayLai_129.setOnClickListener { finish() }
    }
}