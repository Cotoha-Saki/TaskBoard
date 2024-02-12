package xyz.cotoha.program.taskboard.Menu

import android.content.Context
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.PopupMenu
import xyz.cotoha.program.taskboard.R

class KebabMenuHandler(private val context: Context, private val anchor: View) {

    fun showMenu() {
        val popupMenu = PopupMenu(context, anchor)
        popupMenu.menuInflater.inflate(R.menu.kebab_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            handleMenuItemClick(menuItem)
            true
        }
        popupMenu.show()
    }

    private fun handleMenuItemClick(item: MenuItem) {
        when (item.itemId) {
            R.id.action_settings -> {
                // 設定アクションを処理、例: 設定画面を表示
            }
            // 他のメニューアイテムの処理をここに追加
        }
    }
}
