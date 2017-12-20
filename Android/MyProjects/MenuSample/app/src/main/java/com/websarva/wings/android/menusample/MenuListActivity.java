package com.websarva.wings.android.menusample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity {

    /**
     * リストビューを表すフィールド。
     */
    private ListView _lvMenu;

    /**
     * リストビューに表示するリストデータ。
     */
    private List<Map<String, String>> _menuList;


    /**
     * SimpleAdapterの第4引数fromに使用する定数フィールド。
     */
    private static final String[] FROM = {"name", "price"};

    /**
     * SimpleAdapterの第5引数toに使用する定数フィールド。
     */
    private static final int[] TO = {android.R.id.text1, android.R.id.text2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        _lvMenu = (ListView)findViewById(R.id.lvMenu);

        _menuList = createTeishokuList();
        SimpleAdapter adapter =
                new SimpleAdapter(
                        MenuListActivity.this,
                        _menuList,
                        android.R.layout.simple_list_item_2,
                        FROM,TO);
        _lvMenu.setAdapter(adapter);

        _lvMenu.setOnItemClickListener(new ListItemClickListener());

        registerForContextMenu(_lvMenu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_menu_list, menu);
        menu.setHeaderTitle(R.string.menu_list_context_header);
        menu.setHeaderIcon(android.R.drawable.ic_menu_info_details);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch(itemId) {
            case R.id.menuListOptionTeishoku:
                _menuList = createTeishokuList();
                break;
            case R.id.menuListOptionCurry:
                _menuList = createCurryList();
                break;
        }
        SimpleAdapter adapter =
                new SimpleAdapter(
                        MenuListActivity.this,
                        _menuList,
                        android.R.layout.simple_list_item_2,
                        FROM, TO);
        _lvMenu.setAdapter(adapter);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();  //（1）
        int listPosition = info.position;  //（2）
        Map<String, String> menu = _menuList.get(listPosition);  //（3）

        int itemId = item.getItemId();
        switch(itemId) {  //（4）
            case R.id.menuListContextDesc:  //（5）
                String desc = menu.get("desc");
                Toast.makeText(MenuListActivity.this, desc, Toast.LENGTH_LONG).show();
                break;
            case R.id.menuListContextOrder:  //（6）
                // ここに注文処理を記述。
                order(menu);
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * リストビューに表示させる定食リストデータを生成するメソッド。
     *
     * @return 生成された定食リストデータ。
     */
    private List<Map<String, String>> createTeishokuList() {
        List<Map<String, String>> menuList = new ArrayList<Map<String,String>>();

        Map<String, String> menu = new HashMap<String, String>();
        menu.put("name", "から揚げ定食");
        menu.put("price", "800円");
        menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "850円");
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", "850円");
        menu.put("desc", "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "ステーキ定食");
        menu.put("price", "1000円");
        menu.put("desc", "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", "750円");
        menu.put("desc", "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "とんかつ定食");
        menu.put("price", "900円");
        menu.put("desc", "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", "850円");
        menu.put("desc", "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", "900円");
        menu.put("desc", "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "コロッケ定食");
        menu.put("price", "850円");
        menu.put("desc", "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "焼き魚定食");
        menu.put("price", "850円");
        menu.put("desc", "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "焼肉定食");
        menu.put("price", "950円");
        menu.put("desc", "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;
    }

    /**
     * リストビューに表示させるカレーリストデータを生成するメソッド。
     *
     * @return 生成されたカレーリストデータ。
     */
    private List<Map<String, String>> createCurryList() {
        List<Map<String, String>> menuList = new ArrayList<Map<String,String>>();

        Map<String, String> menu = new HashMap<String, String>();
        menu.put("name", "ビーフカレー");
        menu.put("price", "520円");
        menu.put("desc", "特選スパイスをきかせた国産ビーフ100%のカレーです。");
        menuList.add(menu);
        menu = new HashMap<String, String>();
        menu.put("name", "ポークカレー");
        menu.put("price", "420円");
        menu.put("desc", "特選スパイスをきかせた国産ポーク100%のカレーです。");
        menuList.add(menu);
        menu = new HashMap<String, String>();
        menu.put("name", "ハンバーグカレー");
        menu.put("price", "620円");
        menu.put("desc", "特選スパイスをきかせたカレーに手ごねハンバーグをトッピングです。");
        menuList.add(menu);
        menu = new HashMap<String, String>();
        menu.put("name", "チーズカレー");
        menu.put("price", "560円");
        menu.put("desc", "特選スパイスをきかせたカレーにとろけるチーズをトッピングです。");
        menuList.add(menu);
        menu = new HashMap<String, String>();
        menu.put("name", "カツカレー");
        menu.put("price", "760円");
        menu.put("desc", "特選スパイスをきかせたカレーに国産ロースカツをトッピングです。");
        menuList.add(menu);
        menu = new HashMap<String, String>();
        menu.put("name", "ビーフカツカレー");
        menu.put("price", "880円");
        menu.put("desc", "特選スパイスをきかせたカレーに国産ビーフカツをトッピングです。");
        menuList.add(menu);
        menu = new HashMap<String, String>();
        menu.put("name", "からあげカレー");
        menu.put("price", "540円");
        menu.put("desc", "特選スパイスをきかせたカレーに若鳥のから揚げをトッピングです。");
        menuList.add(menu);

        return menuList;
    }

    /**
     * 注文処理を行うメソッド。
     *
     * @param menu 注文するメニューを表すMapオブジェクト。
     */
    private void order(Map<String, String> menu) {
        String menuName = menu.get("name");
        String menuPrice = menu.get("price");

        Intent intent = new Intent(MenuListActivity.this, MenuThanksActivity.class);
        intent.putExtra("menuName", menuName);
        intent.putExtra("menuPrice", menuPrice);
        startActivity(intent);
    }

    /**
     * リストが選択されたときの処理が記述されたメンバクラス。
     *
     * @author Shinzo SAITO
     *
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            order(item);
        }
    }
}
