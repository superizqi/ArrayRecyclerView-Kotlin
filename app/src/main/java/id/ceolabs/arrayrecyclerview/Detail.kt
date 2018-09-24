package id.ceolabs.arrayrecyclerview

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.widget.TextView
import id.ceolabs.arrayrecyclerview.R.color.colorAccent
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class Detail : AppCompatActivity() {

    private var nama: String = ""
    private var detail: String = ""
    private var gambar: String = ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        nama = intent.getStringExtra("nama")
        detail = intent.getStringExtra("detail")
        gambar = intent.getStringExtra("image")

        verticalLayout{


            imageView(R.drawable.img_barca).
                    lparams(width = dip(80), height = dip(80)) {
                        padding = dip(50)
                        margin = dip(30)
                    }

            val teksNama = textView() {
                text = nama
                backgroundColor = ContextCompat.getColor(context, colorAccent)
                textColor = Color.WHITE
                padding = dip(20)

            }



            val teksDetail = textView(){
                text = gambar
                padding = dip(10)

            }

        }

    }
}