package cn.leo.zlogger

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.leo.z_logger.Logger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PermissionUtil.Result {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        PermissionUtil.getInstance(this).request(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).execute(this)

        val json =
            "{\"code\":0,\"data\":[{\"count\":0,\"createDate\":1581925048554,\"esId\":\"0\",\"id\":1,\"modifyDate\":1581925048554,\"name\":\"系统消息\"},{\"count\":0,\"createDate\":1581925048566,\"esId\":\"0\",\"id\":2,\"modifyDate\":1581925048566,\"name\":\"评论回复\"}],\"msg\":\"成功\",\"times\":1581925048569}"
        Logger.d("123$json")

        tvTest.setOnClickListener {
            throw RuntimeException("测试崩溃！")
        }

        //throw RuntimeException("测试崩溃！")
    }

    override fun onSuccess() {

    }

    override fun onFailed(failedPermissions: Array<String>?) {

    }
}
