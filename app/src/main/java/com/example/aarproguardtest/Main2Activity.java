package com.example.aarproguardtest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.aarproguardtest.adapter.ImageLoadAdapter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        findViewById(R.id.btn_apply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyPermission();
            }
        });

    }

    private void applyPermission() {
        String[] requirePermissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (ContextCompat.checkSelfPermission(this, requirePermissions[0]) == 0) {
            LinearLayoutManager manager = new MyLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            mRecyclerView.setLayoutManager(manager);
            ArrayList<String> list = new ArrayList<>();
            list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=51c0fd78bbb7d0a264c9029dfbed760d/b2de9c82d158ccbf907524f010d8bc3eb035412b.jpg");
            list.add("http://g.hiphotos.baidu.com/image/h%3D300/sign=c0bf9c7b5943fbf2da2ca023807fca1e/9825bc315c6034a8583c01f2c1134954082376e2.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=4b997e01f2edab646b724bc0c737af81/8b13632762d0f7037e19951601fa513d2797c555.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=ba15d3049025bc31345d07986edd8de7/8694a4c27d1ed21b9914282fa46eddc450da3f1e.jpg");
            list.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=155ef02584b1cb1321693a13ed5656da/1ad5ad6eddc451daa03d9721bffd5266d1163234.jpg");
            list.add("http://a.hiphotos.baidu.com/image/h%3D300/sign=7d8163b49b58d109dbe3afb2e15accd0/b7fd5266d01609240bcda2d1dd0735fae7cd340b.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=2f3862ea5ee736d147138a08ab504ffc/241f95cad1c8a7865e2166386d09c93d70cf50f8.jpg");
            list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=0527487397510fb367197197e931c893/b999a9014c086e06fe7f39810b087bf40bd1cb21.jpg");
            list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=b95a950e12d5ad6eb5f962eab1ca39a3/8718367adab44aed4532102eba1c8701a08bfbf8.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=2f3862ea5ee736d147138a08ab504ffc/241f95cad1c8a7865e2166386d09c93d70cf50f8.jpg");
            list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=0527487397510fb367197197e931c893/b999a9014c086e06fe7f39810b087bf40bd1cb21.jpg");
            list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=02ad1d008b8ba61ec0eece2f713697cc/0e2442a7d933c89562db83b1d81373f083020056.jpg");
            list.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=b2c5ee93fd03918fc8d13bca613c264b/b3119313b07eca80b4da80949b2397dda04483e2.jpg");
            list.add("http://a.hiphotos.baidu.com/image/h%3D300/sign=08414ca4b63eb1355bc7b1bb961fa8cb/7a899e510fb30f24caec8c4fc295d143ad4b0303.jpg");
            list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=3e7c169124738bd4db21b431918a876c/f7246b600c3387440f3046305b0fd9f9d62aa081.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=b1c87c22db09b3def4bfe268fcbe6cd3/5366d0160924ab1870ad3a7d3ffae6cd7a890bc5.jpg");
            list.add("http://g.hiphotos.baidu.com/image/h%3D300/sign=36c2cf38a74bd1131bcdb1326aaea488/7af40ad162d9f2d3a97b0fa4a3ec8a136327cc17.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=15f8367371f40ad10ae4c1e3672d1151/d439b6003af33a87f6d30151cc5c10385343b53a.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=d63eb6e2a3014c08063b2ea53a7a025b/359b033b5bb5c9ea2ad438a8df39b6003af3b351.jpg");
            list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=711cf18814178a82d13c79a0c602737f/6c224f4a20a44623facdae269222720e0cf3d76b.jpg");
            list.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=1bbab46eadc27d1eba263dc42bd4adaf/3812b31bb051f819499d0580d3b44aed2f73e744.jpg");
            list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=7a720afb283fb80e13d167d706d32ffb/4034970a304e251fee51e232ae86c9177e3e5351.jpg");
            list.add("http://c.hiphotos.baidu.com/image/h%3D300/sign=986c04733f2ac65c78056073cbf3b21d/3b292df5e0fe99251edab1433ea85edf8cb171cb.jpg");
            list.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=38a6b1b6580fd9f9bf175369152cd42b/9a504fc2d562853536834ceb99ef76c6a6ef639d.jpg");
            list.add("http://f.hiphotos.baidu.com/image/h%3D300/sign=1b2b638f94510fb367197197e932c893/b999a9014c086e06e073127d08087bf40ad1cb29.jpg");
            list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=9608a32cd3f9d72a0864161de42a282a/4ec2d5628535e5dd6b5562cc7cc6a7efce1b62ac.jpg");
            list.add("http://f.hiphotos.baidu.com/image/h%3D300/sign=e68d6822ab8b87d64f42ad1f37092860/eaf81a4c510fd9f982bb8f7a2f2dd42a2834a471.jpg");
            list.add("http://h.hiphotos.baidu.com/image/pic/item/faedab64034f78f04831813270310a55b3191c3c.jpg");
            list.add("http://b.hiphotos.baidu.com/image/pic/item/48540923dd54564e9b9f40f8bade9c82d0584f7c.jpg");
            list.add("http://e.hiphotos.baidu.com/image/pic/item/d4628535e5dde7114ca0d236aeefce1b9c166184.jpg");
            list.add("http://f.hiphotos.baidu.com/image/pic/item/1f178a82b9014a9043d3357da0773912b21bee05.jpg");
            list.add("http://c.hiphotos.baidu.com/image/pic/item/0bd162d9f2d3572ce3ad851d8313632763d0c3a0.jpg");
            list.add("http://e.hiphotos.baidu.com/image/pic/item/cc11728b4710b912a4ad903fcafdfc0393452286.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510928393&di=d919a5aff2354b8face1194d1f916f34&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D07092ce6104c510fbac9ea5908304f58%2Fd8f9d72a6059252d5467ef2a3e9b033b5bb5b9a8.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510333672436&di=0b7ff56405878b781e88ed5983735625&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Df41920539858d109d0eea1f1b931a6ca%2Fb2de9c82d158ccbf45ccf61713d8bc3eb13541ae.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510333672436&di=a99bc62fd974881f52684d67e6ebb53b&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fb7fd5266d01609241842b608de0735fae6cd34b9.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510333672436&di=8771da6a87f07d5322fbb3d4982823a2&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D160ba1b9a3014c080d3620e66212687d%2F6f061d950a7b020884db13f168d9f2d3572cc894.jpg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510333672435&di=7c2c4d5b57b7e8dec892d845c464f59e&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D4fd0e688007b020818c437a20ab098a6%2F7af40ad162d9f2d376faeac2a3ec8a136327cc30.jpg");
            ImageLoadAdapter adapter = new ImageLoadAdapter(this, list);
            mRecyclerView.setAdapter(adapter);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    int height = mRecyclerView.getHeight();
                    Log.i("way", "height" + height);
                }
            }, 2000);
        }else {

            ActivityCompat.requestPermissions(this, requirePermissions, 0);
        }


    }
}
