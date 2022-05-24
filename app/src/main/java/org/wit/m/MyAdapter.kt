package org.wit.m

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.jsoup.nodes.Document

class MyAdapter(var context: Context, var urlList:List<String>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgPreview: ImageView? = null
        var txtTitle: TextView? = null
        var txtDescription: TextView? = null
        var layoutPreview: LinearLayout? = null
        var progressBar: CircularProgressIndicator? = null
        var cardView: CardView? = null

        init {
            imgPreview = itemView.findViewById(R.id.Img_preview) as ImageView
            txtTitle = itemView.findViewById(R.id.textView) as TextView
            txtDescription = itemView.findViewById(R.id.txt_description) as TextView
            layoutPreview = itemView.findViewById(R.id.layout_preview) as LinearLayout
            progressBar = itemView.findViewById(R.id.progress_bar) as CircularProgressIndicator
            cardView = itemView.findViewById(R.id.cardView) as CardView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.layout_preview,parent,false))
    }
    override fun getItemCount(): Int {
        return urlList.size

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Utils.getJsoupData(urlList[position])
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {result: Document ->
                val metaTags = result.getElementsByTag("meta")
                for ( element in metaTags)
                {
                    when{
                        element.attr("property").equals("og:image")
                        ->{
                            Picasso.get()
                                .load(element.attr("content"))
                                .into(holder.imgPreview)
                        }
                        element.attr("property").equals("og:url")
                        -> {
                            val browseUrl = element.attr("content")
                            val i = Intent(Intent.ACTION_VIEW)
                            i.data = Uri.parse(browseUrl)
                            context.startActivity(i)
                        }
                        element.attr("name").equals("title")
                        -> holder.txtTitle!!.text=(element.attr("content"))
                        element.attr("name").equals("title")
                        -> holder.txtDescription!!.text=(element.attr("content"))
                    }
                    holder.layoutPreview!!.visibility = View.VISIBLE
                    holder.progressBar!!.visibility = View.GONE
                }
            },

                { error -> Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()})
    }
}