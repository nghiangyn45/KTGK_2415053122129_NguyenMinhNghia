package com.example.ktgk_2415053122129_nguyenminhnghia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var edtEditTen_129: EditText
    private lateinit var edtEditSoTien_129: EditText
    private lateinit var edtEditGhiChu_129: EditText
    private lateinit var btnLuuChinhSua_129: Button
    private lateinit var btnHuyBo_129: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_chi_tieu)

        supportActionBar?.title = "Nguyễn Minh Nghĩa - 2415053122129 - Quản lý chi tiêu cá nhân"

        edtEditTen_129 = findViewById(R.id.edtEditTen_129)
        edtEditSoTien_129 = findViewById(R.id.edtEditSoTien_129)
        edtEditGhiChu_129 = findViewById(R.id.edtEditGhiChu_129)
        btnLuuChinhSua_129 = findViewById(R.id.btnLuuChinhSua_129)
        btnHuyBo_129 = findViewById(R.id.btnHuyBo_129)

        edtEditTen_129.setText(intent.getStringExtra("TEN_KHOAN_CHI"))
        edtEditSoTien_129.setText(intent.getDoubleExtra("SO_TIEN", 0.0).toString())
        edtEditGhiChu_129.setText(intent.getStringExtra("GHI_CHU"))

        btnLuuChinhSua_129.setOnClickListener {
            val tenMoi_129 = edtEditTen_129.text.toString().trim()
            val soTienStr_129 = edtEditSoTien_129.text.toString().trim()
            val ghiChuMoi_129 = edtEditGhiChu_129.text.toString().trim()

            if (tenMoi_129.isEmpty() || soTienStr_129.isEmpty()) {
                Toast.makeText(this, "Không được để trống thông tin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val soTienMoi_129 = soTienStr_129.toDoubleOrNull() ?: 0.0

            // Tạo đối tượng KhoanChi để gọi các hàm kiểm tra
            val khoanChiCheck_129 = KhoanChi(
                tenKhoanChi = tenMoi_129,
                soTien = soTienMoi_129,
                loaiChi = "Khác",
                ghiChu = ghiChuMoi_129,
                daThanhToan = true
            )

            // Gọi hàm kiểm tra số tiền hợp lệ (> 0)
            if (!khoanChiCheck_129.laSoTienHopLe_129()) {
                Toast.makeText(this, "Số tiền phải lớn hơn 0!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Gọi hàm kiểm tra giới hạn (<= 5 triệu) - Bổ sung 2
            if (!khoanChiCheck_129.laSoTienTrongGioHan_129()) {
                Toast.makeText(this, "Lỗi: Số tiền vượt quá giới hạn 5.000.000 VNĐ!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val resultIntent_129 = Intent().apply {
                putExtra("TEN_KHOAN_CHI", tenMoi_129)
                putExtra("SO_TIEN", soTienMoi_129)
                putExtra("GHI_CHU", ghiChuMoi_129)
            }
            setResult(RESULT_OK, resultIntent_129)
            finish()
        }

        btnHuyBo_129.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}