package xyz.cotoha.program.taskboard

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import xyz.cotoha.program.taskboard.Menu.DrawerToggleListener
import xyz.cotoha.program.taskboard.Menu.KebabMenuHandler

class MainActivity : AppCompatActivity() {
    private lateinit var kebabMenuHandler: KebabMenuHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        // 既存の ActionBarDrawerToggle の設定を継続
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // DrawerToggleListener のインスタンスを生成してドロワーリスナーに追加
        val drawerToggleListener = DrawerToggleListener(navView, this)
        drawerLayout.addDrawerListener(drawerToggleListener)

        // ナビゲーションドロワーのアイテム選択イベントを設定
        navView.setNavigationItemSelectedListener { menuItem ->
            // アイテムが選択された時の処理
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
        //KebabMenuHandlerの初期化
        kebabMenuHandler = KebabMenuHandler(this, toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.kebab_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

