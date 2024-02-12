package xyz.cotoha.program.taskboard

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import java.util.*

class NotificationUtils(private val context: Context) {

    fun showPopupNotification(message: String) {
        val channelId = "default_channel_id"
        val channelDescription = "Default Channel"

        // 通知チャネルをシステムに登録（Android 8.0以上必要）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelDescription, NotificationManager.IMPORTANCE_HIGH)
            channel.description = channelDescription
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        // 通知の権限があるかをチェック
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            // 通知を構築
            val builder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.icon)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)

            // 通知を表示
            if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                // 通知の権限がない場合は、権限リクエストのロジックを追加
                // ...
                return
            }
            NotificationManagerCompat.from(context).notify(Random().nextInt(), builder.build())
        } else {
            // 通知の権限がない場合、ユーザーに権限を要請するための設定画面を開く
            val intent = Intent().apply {
                action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
                putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
            }
            context.startActivity(intent)
        }
    }
}
