package com.example.movingvideoviewproject;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.VideoView;
import android.net.Uri;
import android.media.MediaPlayer;
import android.widget.FrameLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    protected VideoView mVideoView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = (VideoView) findViewById(R.id.video_view);

        // sample.mp4 설정
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/sample");
        //리소스의 위치를 지정                                현재 애플리케이션의 패키지 이름 반환
        mVideoView.setVideoURI(uri);
        //videoview에 설정

        // 비디오가 재생가능한 상태가 되면 호출되는 콜백함수 등록
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // 준비 완료되면 비디오 재생
                mp.start();
            }
        });



        // 영상 위치 조정 파트
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)mVideoView.getLayoutParams();
        // VideoView 객체의 layoutparams를 가져오는 코드
        params.leftMargin += 200;
        // 영상을 우로 200dp만큼 이동
        params.bottomMargin -= 400;
        // 영상을 아래로 400만큼 이동
        mVideoView.setLayoutParams(params);

    }
}