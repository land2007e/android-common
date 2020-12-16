package com.ddona.demorecycleview.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.ui.dialog.CustomDialog

class DemoDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_dialog)


        findViewById<View>(R.id.btn_show).setOnClickListener({
            val dia = CustomDialog(DemoDialogActivity@ this)
            dia.functionOk = { isOk, name ->
                {
                    Toast.makeText(DemoDialogActivity@ this,
                    "Ahihi", Toast.LENGTH_LONG).show()
                }
            }
            dia.create()
            dia.show()
        })
    }


    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Confirm")
            .setMessage("Do you want to exit this screen?")
//            .setPositiveButton("Ok", object : DialogInterface.OnClickListener{
//                override fun onClick(dialog: DialogInterface, which: Int) {
//
//                }
//            })
            .setPositiveButton("Ok", { dialog, which ->
                run {
                    DemoDialogActivity@ finish()
                }
            })
            .setNegativeButton("Cancel", { dialog, which ->
                {

                }
            })
            .show()
    }
}