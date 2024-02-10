package com.example.myedpsapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;




//サンプルコードをだいぶパクっています

public class CameraActivity extends AppCompatActivity{

    ActivityResultLauncher<Intent> _cameraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallbackFromCamera());
    private Uri _imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eighth);
    }


    public void onCameraImageClick(View view) {//カメラボタンがクリックされたとき

        int r = (int)Math.random()*9000000+1000000;
        // ストレージに格納する画像のファイル名を生成
        String fileName = "Photo_" + r +".jpg";

        // ContentValuesオブジェクトを生成。
        ContentValues values = new ContentValues();
        // 画像ファイル名を設定。
        values.put(MediaStore.Images.Media.TITLE, fileName);
        // 画像ファイルの種類を設定。
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");

        // ContentResolverオブジェクトを生成。
        ContentResolver resolver = getContentResolver();
        // ContentResolverを使ってURIオブジェクトを生成。
        _imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        // Intentオブジェクトを生成。
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Extra情報として_imageUriを設定。
        intent.putExtra(MediaStore.EXTRA_OUTPUT, _imageUri);
        // アクティビティを起動。
        _cameraLauncher.launch(intent);
    }


    private class ActivityResultCallbackFromCamera implements ActivityResultCallback<ActivityResult> {//カメラ撮影後
        @Override
        public void onActivityResult(ActivityResult result) {
            // カメラアプリで撮影成功の場合
            if(result.getResultCode() == RESULT_OK) {
                // 撮影された画像のビットマップデータを取得。
                Intent data = result.getData();
                Bitmap bitmap;
                if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                    bitmap = data.getParcelableExtra("data", Bitmap.class);
                }
                else {
                    bitmap = data.getParcelableExtra("data");
                }
                // 画像を表示するImageViewを取得。
                ImageView ivCamera = findViewById(R.id.ivCamera);
                // 撮影された画像をImageViewに設定。
                ivCamera.setImageBitmap(bitmap);
                // フィールドの画像URIをImageViewに設定。
                ivCamera.setImageURI(_imageUri);


                Intent CameraToSeventhIntent = new Intent(CameraActivity.this, SeventhActivity.class);//一時的にrakutenから変更
                // 名前を渡す
                startActivity(CameraToSeventhIntent);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // スライドアニメーション
                finish(); // CameraActivityを終了させる



            }
        }
    }


}
