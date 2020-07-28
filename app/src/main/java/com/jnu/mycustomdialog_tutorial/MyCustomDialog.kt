package com.jnu.mycustomdialog_tutorial

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.custom_dialog.*

// 컨택스트와 인터페이스는 생성자고 , 다이얼로그는 상속이다.
// 다이어로그는 context 를 꼭넣어야하기떄문에 상속시켜준다.
class MyCustomDialog(context: Context, myCustomDialogInterface: MyCustomDialogInterface)
                     : Dialog(context), View.OnClickListener
{

    companion object{
        const val TAG: String = "로그"
    }
    //
    private var myCustomDialogInterface: MyCustomDialogInterface? = null

    //인터페이스 연결
    //기본생성자 생
    init{
        this.myCustomDialogInterface= myCustomDialogInterface
    }

    //onCreate = 다이어로그가 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.custom_dialog)

        Log.d(TAG,"MyCustomDialog - onCreate() called")
        // 배경 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        like_btn.setOnClickListener(this)
        subscribe_btn.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when(view) {

            // 좋아요 버튼이 클릭 되었을때
            like_btn -> {
                Log.d(TAG,"MyCustomDialog - 좋아요 버튼 클릭!")
                //값이 없을수도있으니 옵셔널체크 해준다.
                this.myCustomDialogInterface?.onLikeBtnClicked()
            }

            // 구독 버튼이 클릭 되었을때
            subscribe_btn -> {
                Log.d(TAG,"MyCustomDialog - 구독 버튼 클릭!")
                //값이 없을수도있으니 옵셔널체크 해준다.
                this.myCustomDialogInterface?.onSubscribeBtnClicked()

            }
        }
    }

}