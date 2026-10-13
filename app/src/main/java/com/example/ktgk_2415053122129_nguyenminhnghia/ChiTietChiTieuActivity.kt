package com.example.ktgk_2415053122129_nguyenminhnghia

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var tvThongTinChiTiet_129: TextView
    private lateinit var btnQuayLai_129: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Nguyễn Minh Nghĩa - 2415053122129 - Quản lý chi tiêu cá nhân"

        tvThongTinChiTiet_129 = findViewById(R.id.tvThongTinChiTiet_129)
        btnQuayLai_129 = findViewById(R.id.btnQuayLai_129)

        xuLyNhanDuLieuIntent_129()

        btnQuayLai_129.setOnClickListener { finish() }
    }

    private fun xuLyNhanDuLieuIntent_129() {
        val tenKhoanChi_129 = intent.getStringExtra("TEN_KHOAN_CHI")
        val soTien_129 = intent.getDoubleExtra("SO_TIEN", -1.0)
        val ghiChu_129 = intent.getStringExtra("GHI_CHU") ?: "Không có ghi chú"
        val daThanhToan_129 = intent.getBooleanExtra("DA_THANH_TOAN", false)

        if (tenKhoanChi_129.isNullOrBlank() || soTien_129 <= 0) {
            tvThongTinChiTiet_129.text = "Lỗi: Dữ liệu không hợp lệ hoặc bị thiếu!"
        } else {
            val trangThaiStr_129 = if (daThanhToan_129) "Đã thanh toán" else "Chưa thanh toán"
            tvThongTinChiTiet_129.text = """
                Tên khoản chi: $tenKhoanChi_129
                Số tiền: $soTien_129 VNĐ
                Ghi chú: $ghiChu_129
                Trạng thái: $trangThaiStr_129
            """.trimIndent()
        }
    }
}