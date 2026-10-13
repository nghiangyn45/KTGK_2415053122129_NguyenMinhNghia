package com.example.ktgk_2415053122129_nguyenminhnghia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvThongTinChiTiet_129: TextView
    private lateinit var btnMoManHinhSua_129: Button
    private lateinit var btnQuayLai_129: Button

    private var khoanChiHienTai_129 = KhoanChi(
        maKhoanChi = "KC_129",
        tenKhoanChi = "Mua sách học lập trình",
        soTien = 250000.0,
        ghiChu = "Sách Kotlin Android",
        daThanhToan = true
    )

    private val editLauncher_129 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val tenMoi = data?.getStringExtra("TEN_KHOAN_CHI")
            val soTienMoi = data?.getDoubleExtra("SO_TIEN", -1.0)
            val ghiChuMoi = data?.getStringExtra("GHI_CHU")

            if (!tenMoi.isNullOrBlank() && soTienMoi != null && soTienMoi > 0) {
                khoanChiHienTai_129.tenKhoanChi = tenMoi
                khoanChiHienTai_129.soTien = soTienMoi
                if (ghiChuMoi != null) khoanChiHienTai_129.ghiChu = ghiChuMoi

                hienThiThongTin_129()
                Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Đã hủy chỉnh sửa, giữ nguyên dữ liệu cũ.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Nguyễn Minh Nghĩa - 2415053122129 - Quản lý chi tiêu cá nhân"

        tvThongTinChiTiet_129 = findViewById(R.id.tvThongTinChiTiet_129)
        btnMoManHinhSua_129 = findViewById(R.id.btnMoManHinhSua_129)
        btnQuayLai_129 = findViewById(R.id.btnQuayLai_129)

        val intentTen = intent.getStringExtra("TEN_KHOAN_CHI")
        val intentSoTien = intent.getDoubleExtra("SO_TIEN", -1.0)
        val intentGhiChu = intent.getStringExtra("GHI_CHU")

        if (!intentTen.isNullOrBlank() && intentSoTien > 0) {
            khoanChiHienTai_129.tenKhoanChi = intentTen
            khoanChiHienTai_129.soTien = intentSoTien
            if (intentGhiChu != null) khoanChiHienTai_129.ghiChu = intentGhiChu
        }

        hienThiThongTin_129()

        btnMoManHinhSua_129.setOnClickListener {
            val intent_129 = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
                putExtra("TEN_KHOAN_CHI", khoanChiHienTai_129.tenKhoanChi)
                putExtra("SO_TIEN", khoanChiHienTai_129.soTien)
                putExtra("GHI_CHU", khoanChiHienTai_129.ghiChu)
            }
            editLauncher_129.launch(intent_129)
        }

        btnQuayLai_129.setOnClickListener { finish() }
    }

    private fun hienThiThongTin_129() {
        tvThongTinChiTiet_129.text = khoanChiHienTai_129.layThongTin_129()
    }
}