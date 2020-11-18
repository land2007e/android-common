package com.ddona.demorecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.demorecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemInterface{
    private lateinit var binding: ActivityMainBinding
    private val itemDatas = mutableListOf<ItemData>()
    private lateinit var adapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        initsData()

        //dua adapter len recycleview de hien thi
        binding.rcImg.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, false
            )
//        GridLayoutManager
        adapter = ImageAdapter(itemDatas)
        adapter.setInterface(this)
        binding.rcImg.adapter = adapter

    }

    override fun clickItem(position:Int) {
//        val intent = Intent()
//        intent.setClass(this, DetailActivity::class.java)
//        intent.putExtra("DATA", titleItem)
//        startActivity(intent)
        itemDatas.removeAt(position)
        //cap nhat lai giao dien cho adapter
//        adapter.notifyDataSetChanged()

        //xoa view tai position
        adapter.notifyItemRemoved(position)
    }




    private fun initsData() {
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/ca/67/9d/ca679de60e519a538a6b37714f594841.jpg",
                "Áo Dài Việt Nam | Áo dài, Phụ nữ, Con gái",
                "Description"
            )
        )


        itemDatas.add(
            ItemData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQckj7EFkFC4lbvh19v444jfEW8yWr_dmhxA&usqp=CAU",
                "Vẻ đẹp tà áo dài Việt Nam được ca ngợi ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://kenh14cdn.com/thumb_w/640/2018/7/15/photo1531655303866-15316553038661598351328.jpg",
                "Pin on Vietnamese long dress",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://vietnamtinhhoa.net/wp-content/uploads/2019/11/12004230023_da7a7d11f4_b.jpg",
                "Những lỗi khi diện áo dài nữ sinh nên lưu ý",
                "Description"
            )
        )

        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/736x/c0/25/f0/c025f0739fa6c361de4b76871d9b37f5.jpg",
                "118 hình ảnh đẹp nhất về Ao dai Viet ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/06/d5/a5/06d5a5795ee552431f510a42dd6dd25f.jpg",
                "Mặc áo dài đến lớp không còn là ác ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/ff/ce/c9/ffcec97bbc676e13ec91b1e4bb7e6ef3.jpg",
                "Trao giải Hội thi \"Người đẹp áo dài qua ...",
                "Description"
            )
        )
        itemDatas.add(
            ItemData(
                "https://i.pinimg.com/originals/3b/3e/bf/3b3ebfb28e871eccd0a1804a621a27d2.jpg",
                "Chân dung nữ sinh Đà Nẵng trong tà áo ...",
                "Description"
            )
        )
    }
}