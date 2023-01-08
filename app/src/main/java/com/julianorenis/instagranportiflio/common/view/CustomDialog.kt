package com.julianorenis.instagranportiflio.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.julianorenis.instagranportiflio.R

class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var dialogLinearlayout: LinearLayout
    private lateinit var txtButtons: Array<TextView>

    private var titleId: Int? = null
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        dialogLinearlayout = findViewById(R.id.dialog_container)
        textView = findViewById(R.id.dialog_title)
    }

    override fun setTitle(title: CharSequence?) {
        super.setTitle(title)
    }

    fun addButtom( vararg texts: Int,listener: View.OnClickListener) {
        txtButtons = Array(texts.size) {
            TextView(context)
        }

        texts.forEachIndexed{index, txtId ->
            txtButtons[index].id = txtId
            txtButtons[index].setText(txtId)
            txtButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()

        titleId?.let {
            textView.setText(it)
        }
        for (textView in txtButtons){

            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(30,50,30,50)
            dialogLinearlayout.addView(textView,layoutParams)
        }
    }
}