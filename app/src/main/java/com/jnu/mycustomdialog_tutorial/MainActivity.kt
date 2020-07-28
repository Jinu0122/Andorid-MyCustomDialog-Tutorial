package com.jnu.mycustomdialog_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), MyCustomDialogInterface {
    
    companion object{
        const val TAG: String = "로그"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"MainActivity - onCreate() called")
    }
    // 뷰로 설정하면 장점이 메인엑티비티에서 만들었던 함수를 xml의 onClick 리스너로 설정 가능하다.
    fun onDialogBtnClicked(view: View){
        Log.d(TAG,"MainActivity - onDialogBtnClicked() called")

        val myCustomDialog = MyCustomDialog(this, this)

        myCustomDialog.show()


    }


    // 구독버튼 클릭
    override fun onSubscribeBtnClicked() {
        Log.d(TAG,"MainActivity - 구독버튼 클릭")
        Toast.makeText(this,"구독버튼 클릭!", Toast.LENGTH_SHORT).show()

    }

    // 좋아요버튼 클
    override fun onLikeBtnClicked() {
        Log.d(TAG,"MainActivity - 좋아요 버튼 클")

        Toast.makeText(this,"좋아요버튼 클릭!", Toast.LENGTH_SHORT).show()

    }
}