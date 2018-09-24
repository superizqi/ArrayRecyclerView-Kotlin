package id.ceolabs.arrayrecyclerview

import android.content.Intent
import android.content.res.TypedArray
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

        list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
//        list.adapter = RecyclerViewAdapter(this, items)

        list.adapter = RecyclerViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
            val nama = it.name
            val image = it.image.toString()
            val detail = it.detail
            startActivity<Detail>("nama" to nama,"detail" to detail,"image" to image)
//            startActivity<Detail>("detail" to detail)
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.club_detail)
        items.clear()
        for (i in name.indices) {
            items.add(
                    Item(
                     name[i]
                    ,image.getResourceId(i,0)
                    ,detail[i]
                    )
                )
            }

        //Recycle the typed array
        image.recycle()
    }


}
