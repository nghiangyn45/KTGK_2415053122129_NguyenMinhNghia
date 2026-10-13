package com.example.ktgk_2415053122129_nguyenminhnghia

data class KhoanChi(
    val maKhoanChi: String = "KC_129",
    var tenKhoanChi: String,
    var soTien: Double,
    var loaiChi: String, // Bổ sung loại chi tiêu
    var ghiChu: String,
    var daThanhToan: Boolean
) {
    fun layThongTin_129(): String {
        val trangThai_129 = if (daThanhToan) "Đã thanh toán" else "Chưa thanh toán"
        return "Mã: $maKhoanChi\nTên: $tenKhoanChi\nLoại: $loaiChi\nSố tiền: $soTien VNĐ\nGhi chú: $ghiChu\nTrạng thái: $trangThai_129"
    }

    fun laSoTienHopLe_129(): Boolean {
        return soTien > 0.0
    }
}