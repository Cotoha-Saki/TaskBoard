package xyz.cotoha.program.taskboard.Menu

import android.content.Context
import android.view.View
import androidx.core.view.forEach
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import xyz.cotoha.program.taskboard.NotificationUtils

class DrawerToggleListener(private val navView: NavigationView, private val context: Context) : DrawerLayout.DrawerListener {

    override fun onDrawerClosed(drawerView: View) {
        // ドロワーが閉じた時にメニューの選択をクリアする
        navView.menu.forEach { item ->
            item.isChecked = false
        }
    }

    override fun onDrawerOpened(drawerView: View) {
        // ドロワーが開いた時の処理
        val notificationUtils = NotificationUtils(context)
        notificationUtils.showPopupNotification("ドロワーが開きました")
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        // ドロワーがスライドする時の処理が必要な場合はここに記述する
    }

    override fun onDrawerStateChanged(newState: Int) {
        // ドロワーの状態が変わった時の処理が必要な場合はここに記述する
    }
}

