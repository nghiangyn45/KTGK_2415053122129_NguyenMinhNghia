package com.example.ktgk_2415053122129_nguyenminhnghia

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tiêu đề Toolbar chuẩn theo yêu cầu đề bài
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
    }

    private fun caiDatSuKien_129() {
        // Xử lý nút Thêm khoản chi (Kiểm tra dữ liệu trống và số tiền hợp lệ)
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

        // Ở Câu 1, nút Xem chi tiết tạm thời để thông báo, chưa gọi màn hình mới để tránh lỗi
        btnXemChiTiet_129.setOnClickListener {
            val ten_129 = edtTenKhoanChi_129.text.toString().trim()
            if (ten_129.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tên khoản chi trước khi xem chi tiết!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Đang ở Câu 1 (Màn hình chi tiết sẽ làm ở Câu 2)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}