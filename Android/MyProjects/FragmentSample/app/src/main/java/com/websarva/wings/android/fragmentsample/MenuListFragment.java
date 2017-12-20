package com.websarva.wings.android.fragmentsample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuListFragment extends Fragment {

    private Activity _parentActivity;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_list,container,false);
        ListView lvMenu = (ListView) view.findViewById(R.id.lvMenu);


        List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();

        Map<String, String> menu = new HashMap<String, String>();
        menu.put("name", "から揚げ定食");
        menu.put("price", "800円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "ステーキ定食");
        menu.put("price", "1000円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", "750円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "とんかつ定食");
        menu.put("price", "900円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", "900円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "コロッケ定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "焼き魚定食");
        menu.put("price", "850円");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "焼肉定食");
        menu.put("price", "950円");
        menuList.add(menu);

        String[] from = {"name", "price"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(_parentActivity, menuList, android.R.layout.simple_list_item_2, from, to);
        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new ListItemClickListener());

        return view;
    }

    private boolean _isLayoutXLarge = true;  // （1）
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  // （2）
        super.onActivityCreated(savedInstanceState);
        View menuThanksFrame = _parentActivity.findViewById(R.id.menuThanksFrame);  // （3）
        if(menuThanksFrame == null) {  // （4）
            _isLayoutXLarge = false;  // （5）
        }
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);  // （1）
            String menuName = item.get("name");  // （1）
            String menuPrice = item.get("price");  // （1）

            if(_isLayoutXLarge) {  // （2）
                Bundle bundle = new Bundle();  // （3）
                bundle.putString("menuName", menuName);  // （4）
                bundle.putString("menuPrice", menuPrice);  // （4）

                FragmentManager manager = getFragmentManager();  // （5）
                FragmentTransaction transaction = manager.beginTransaction();  // （6）
                MenuThanksFragment menuThanksFragment = new MenuThanksFragment();  // （7）
                menuThanksFragment.setArguments(bundle);  // （8）
                transaction.replace(R.id.menuThanksFrame, menuThanksFragment);  // （9）
                transaction.commit();  // （10）
            }
            else {  // （11）
                Intent intent = new Intent(_parentActivity, MenuThanksActivity.class);  // （12）
                intent.putExtra("menuName", menuName);  // （12）
                intent.putExtra("menuPrice", menuPrice);  // （12）
                startActivity(intent);  // （12）
            }
        }
    }


}
