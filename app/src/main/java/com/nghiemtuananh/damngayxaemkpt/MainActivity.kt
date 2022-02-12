package com.nghiemtuananh.damngayxaemkpt

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val simpleDateFormat: SimpleDateFormat
    val calendarOne: Calendar
    val calendarTwo: Calendar

    init {
        simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        calendarOne = Calendar.getInstance()
        calendarTwo = Calendar.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edt_date_one.setOnClickListener {
            chonNgay1()
        }
        edt_date_two.setOnClickListener {
            chonNgay2()
        }
        btn_tinh.setOnClickListener {
            val ngayXaNhau: Int =
                ((calendarTwo.timeInMillis - calendarOne.timeInMillis) / (1000 * 60 * 60 * 24)).toInt()
            if (ngayXaNhau < 0) {
                Toast.makeText(this, "Vui lòng chọn ngày thứ 2 sau ngày thứ 1", Toast.LENGTH_LONG)
                    .show()
            } else {
                tv_result.setText("Số ngày xa nhau là: $ngayXaNhau")
            }
        }
    }

    private fun chonNgay1() {
        val ngay = calendarOne.get(Calendar.DATE)
        val thang = calendarOne.get(Calendar.MONTH)
        val nam = calendarOne.get(Calendar.YEAR)
        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                calendarOne.set(year, month, dayOfMonth)
                edt_date_one.setText(simpleDateFormat.format(calendarOne.time))
            },
            nam,
            thang,
            ngay)
        datePickerDialog.show()
    }

    private fun chonNgay2() {
        val ngay = calendarTwo.get(Calendar.DATE)
        val thang = calendarTwo.get(Calendar.MONTH)
        val nam = calendarTwo.get(Calendar.YEAR)
        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                calendarTwo.set(year, month, dayOfMonth)
                edt_date_two.setText(simpleDateFormat.format(calendarTwo.time))
            },
            nam,
            thang,
            ngay)
        datePickerDialog.show()
    }
}