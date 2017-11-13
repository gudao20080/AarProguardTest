package com.example.aarproguardtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.example.aarproguardtest.adapter.ImageLoadAdapter


class MainActivity : AppCompatActivity() {
    val url = "https://api.m.jd.com/client.action?functionId=searchWare&body=%7B%22pageIdx%22:1,%22pageSize%22:20,%22searchType%22:%223%22,%22shopId%22:%221000080061%22,%22sort%22:%220%22,%22source%22:%22app-paipai%22%7D&client=paipai&clientVersion=6.5.0"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler = findViewById<RecyclerView>(R.id.rv)

        val list = ArrayList<String>()
        list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=51c0fd78bbb7d0a264c9029dfbed760d/b2de9c82d158ccbf907524f010d8bc3eb035412b.jpg")
        list.add("http://g.hiphotos.baidu.com/image/h%3D300/sign=c0bf9c7b5943fbf2da2ca023807fca1e/9825bc315c6034a8583c01f2c1134954082376e2.jpg")
        list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=4b997e01f2edab646b724bc0c737af81/8b13632762d0f7037e19951601fa513d2797c555.jpg")
        list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=ba15d3049025bc31345d07986edd8de7/8694a4c27d1ed21b9914282fa46eddc450da3f1e.jpg")
        list.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=155ef02584b1cb1321693a13ed5656da/1ad5ad6eddc451daa03d9721bffd5266d1163234.jpg")
        list.add("http://a.hiphotos.baidu.com/image/h%3D300/sign=7d8163b49b58d109dbe3afb2e15accd0/b7fd5266d01609240bcda2d1dd0735fae7cd340b.jpg")
        list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=2f3862ea5ee736d147138a08ab504ffc/241f95cad1c8a7865e2166386d09c93d70cf50f8.jpg")
        list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=0527487397510fb367197197e931c893/b999a9014c086e06fe7f39810b087bf40bd1cb21.jpg")
        list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=b95a950e12d5ad6eb5f962eab1ca39a3/8718367adab44aed4532102eba1c8701a08bfbf8.jpg")
        list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=2f3862ea5ee736d147138a08ab504ffc/241f95cad1c8a7865e2166386d09c93d70cf50f8.jpg")
        list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=0527487397510fb367197197e931c893/b999a9014c086e06fe7f39810b087bf40bd1cb21.jpg")
        list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=02ad1d008b8ba61ec0eece2f713697cc/0e2442a7d933c89562db83b1d81373f083020056.jpg")
        list.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=b2c5ee93fd03918fc8d13bca613c264b/b3119313b07eca80b4da80949b2397dda04483e2.jpg")
        list.add("http://a.hiphotos.baidu.com/image/h%3D300/sign=08414ca4b63eb1355bc7b1bb961fa8cb/7a899e510fb30f24caec8c4fc295d143ad4b0303.jpg")
        list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=3e7c169124738bd4db21b431918a876c/f7246b600c3387440f3046305b0fd9f9d62aa081.jpg")
        list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=b1c87c22db09b3def4bfe268fcbe6cd3/5366d0160924ab1870ad3a7d3ffae6cd7a890bc5.jpg")
        list.add("http://g.hiphotos.baidu.com/image/h%3D300/sign=36c2cf38a74bd1131bcdb1326aaea488/7af40ad162d9f2d3a97b0fa4a3ec8a136327cc17.jpg")
        list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=15f8367371f40ad10ae4c1e3672d1151/d439b6003af33a87f6d30151cc5c10385343b53a.jpg")
        list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=d63eb6e2a3014c08063b2ea53a7a025b/359b033b5bb5c9ea2ad438a8df39b6003af3b351.jpg")
        list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=711cf18814178a82d13c79a0c602737f/6c224f4a20a44623facdae269222720e0cf3d76b.jpg")
//        list.add("")
//        list.add("")
//        list.add("")
        val adapter = ImageLoadAdapter(this, list)
        recycler.adapter = adapter


    }


}
