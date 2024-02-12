package xyz.cotoha.program.taskboard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_screen)

        // 2秒後にMainActivityに遷移する
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // LoadingActivityを終了して、バックスタックから削除する
        }, 3000) // 遅延時間をミリ秒で設定（ここでは2000ミリ秒、つまり2秒）
    }
}
