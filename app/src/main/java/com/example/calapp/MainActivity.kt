package com.example.calapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.v7.app.AlertDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }
    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("数字を入れてください")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->

        }
        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }

    override fun onClick(v: View) {

        if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty()) {
            showAlertDialog()
        }

        val intent = Intent(this, ResultActivity::class.java)
        if (editText1.getText().toString().isNotEmpty() && editText2.getText().toString().isNotEmpty()) {
            val value1 = editText1.text.toString().toDouble()
            val value2 = editText2.text.toString().toDouble()


            if (v.id == R.id.button1) {
                val result = value1 + value2
                textView.text = result.toString()
                intent.putExtra("result", result.toString())
            } else if (v.id == R.id.button2) {
                val result = value1 - value2
                textView.text = result.toString()
                intent.putExtra("result", result.toString())
            } else if (v.id == R.id.button3) {
                val result = value1 * value2
                textView.text = result.toString()
                intent.putExtra("result", result.toString())
            } else if (v.id == R.id.button4) {
                val result = value1 / value2
                textView.text = result.toString()
                intent.putExtra("result", result.toString())


            }
            startActivity(intent)

        }

    }
}




