package com.ddona.demorecycleview.ui.fragment

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.databinding.FragmentNewBinding
import com.ddona.demorecycleview.model.ItemNew
import com.ddona.demorecycleview.ui.FragmentActivity
import com.ddona.demorecycleview.ui.adapter.NewAdapter
import org.jsoup.Jsoup

class NewFragment : Fragment(), NewAdapter.INewAdapter {
    private val itemNews = mutableListOf<ItemNew>()
    private lateinit var binding: FragmentNewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBinding.inflate(
            inflater,
            container,
            false
        )
        binding.rc.layoutManager = LinearLayoutManager(context)
        binding.rc.adapter = NewAdapter(this)
//        "https://genk.vn/mobile.chn"
        getData(arguments!!.getString("LINK")!!)
        return binding.root
    }

    private fun getData(link:String){
        val asyn = object :AsyncTask<String, Void, MutableList<ItemNew>>(){
            override fun doInBackground(vararg params: String?): MutableList<ItemNew> {
                val linkCrawl = params!![0]
                val doc = Jsoup.connect(linkCrawl).get()
                val items = mutableListOf<ItemNew>()
                for (d in doc.select("div.kds-new-stream-wrapper").first().select("li.knswli")){
                    val title = d.select("a").first().attr("title")
                    val linkImage = d.select("a").first().select("img").attr("src")
                    val content = d.select("span").get(3).text()
                    val link = d.select("a").first().attr("href")
                    items.add(
                        ItemNew(linkImage, title, content,
                            "https://genk.vn"+link)
                    )
                }

                return items
            }

            override fun onPostExecute(result: MutableList<ItemNew>) {
                itemNews.clear()
                itemNews.addAll(result)
                binding.rc.adapter!!.notifyDataSetChanged()
            }
        }
        asyn.execute(link)
    }

    override fun getCount() = itemNews.size

    override fun getData(position: Int) = itemNews[position]

    override fun onClickItem(position: Int) {
        //mo fragment detail
        (activity as FragmentActivity).openDetailFragment(
            itemNews[position].link
        )
    }
}