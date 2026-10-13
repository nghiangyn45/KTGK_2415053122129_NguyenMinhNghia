package com.example.ktgk_2415053122129_nguyenminhnghia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtTenKhoanChi_129: EditText
    private lateinit var edtSoTien_129: EditText
    private lateinit var edtGhiChu_129: EditText
    private lateinit var btnThemKhoanChi_129: Button
    private lateinit var btnXemChiTiet_129: Button
    private lateinit var btnChinhSuaMain_129: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tiêu đề ActionBar chuẩn theo yêu cầu
        supportActionBar?.title = "Nguyễn Minh Nghĩa - 2415053122129 - Quản lý chi tiêu cá nhân"

        khoiTaoThanhPhan_129()
        caiDatSuKien_129()
    }

    private fun khoiTaoThanhPhan_129() {
        edtTenKhoanChi_129 = findViewById(R.id.edtTenKhoanChi_129)
        edtSoTien_129 = findViewById(R.id.edtSoTien_129)
        edtGhiChu_129 = findViewById(R.id.edtGhiChu_129)
        btnThemKhoanChi_129 = findViewById(R.id.btnThemKhoanChi_129)
        btnXemChiTiet_129 = findViewById(R.id.btnXemChiTiet_129)
        btnChinhSuaMain_129 = findViewById(R.id.btnChinhSuaMain_129)
    }

    private fun caiDatSuKien_129() {
        // 1. Nút Thêm khoản chi: Kiểm tra dữ liệu nhập
        btnThemKhoanChi_129.setOnClickListener {
            val ten_129 = edtTenKhoanChi_129.text.toString().trim()
            val soTienStr_129 = edtSoTien_129.text.toString().trim()

            if (ten_129.isEmpty() || soTienStr_129.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ tên khoản chi và số tiền!", Toast.LENGTH_SHORT).show()
            } else {
                val soTien_129 = soTienStr_129.toDoubleOrNull() ?: 0.0
                if (soTien_129 <= 0) {
                    Toast.makeText(this, "Số tiền phải lớn hơn 0!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Thêm khoản chi thành công: $ten_129", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // 2. Nút Chi tiết khoản chi: Truyền dữ liệu sang ChiTietChiTieuActivity
        btnXemChiTiet_129.setOnClickListener {
            val ten_129 = edtTenKhoanChi_129.text.toString().trim()
            val soTienStr_129 = edtSoTien_129.text.toString().trim()
            val ghiChu_129 = edtGhiChu_129.text.toString().trim()
            if (ten_129.isEmpty() || soTienStr_129.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập thông tin trước khi xem chi tiết!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val soTien_129 = soTienStr_129.toDoubleOrNull() ?: 0.0
            if (soTien_129 <= 0) {
                Toast.makeText(this, "Số tiền phải lớn hơn 0!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent_129 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra("TEN_KHOAN_CHI", ten_129)
                putExtra("SO_TIEN", soTien_129)
                putExtra("GHI_CHU", ghiChu_129.ifEmpty { "Không có ghi chú" })
                putExtra("DA_THANH_TOAN", true)
            }
            startActivity(intent_129)
        }

        // 3. Nút Sửa khoản chi: Nhảy sang màn hình ChinhSuaChiTieuActivity
        btnChinhSuaMain_129.setOnClickListener {
            val ten_129 = edtTenKhoanChi_129.text.toString().trim()
            val soTien_129 = edtSoTien_129.text.toString().toDoubleOrNull() ?: 100000.0
            val ghiChu_129 = edtGhiChu_129.text.toString().trim()

            val intent_129 = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
                putExtra("TEN_KHOAN_CHI", ten_129.ifEmpty { "Khoản chi mẫu" })
                putExtra("SO_TIEN", soTien_129)
                putExtra("GHI_CHU", ghiChu_129.ifEmpty { "Không có ghi chú" })
            }
            startActivity(intent_129)
        }
    }
}