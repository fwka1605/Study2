package com.websarva.wings.android.fragmentsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * フラグメントサンプル
 *
 * 注文完了のフラグメントクラス。
 *
 * @author Shinzo SAITO
 */
public class MenuThanksFragment extends Fragment {

    /**
     * このフラグメントが所属するアクティビティオブジェクト。
     */
    private Activity _parentActivity;

    private boolean _isLayoutXLarge = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _parentActivity = getActivity();

        FragmentManager manager = getFragmentManager();
        MenuListFragment menuListFragment = (MenuListFragment) manager.findFragmentById(R.id.fragmentMenuList);
        if(menuListFragment==null){
            _isLayoutXLarge=false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_thanks, container, false);

        String menuName = "";
        String menuPrice= "";


        if(_isLayoutXLarge){
            Bundle extras = getArguments();
            menuName = extras.getString("menuName");  //（4）
            menuPrice = extras.getString("menuPrice");  //（4）
        }
        else{
            Intent intent = _parentActivity.getIntent();  // （5）
            menuName = intent.getStringExtra("menuName");
            menuPrice = intent.getStringExtra("menuPrice");

        }

        TextView tvMenuName = (TextView) view.findViewById(R.id.tvMenuName);  // （6）
        TextView tvMenuPrice = (TextView) view.findViewById(R.id.tvMenuPrice);  // （6）
        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);

        Button btBackButton = (Button) view.findViewById(R.id.btBackButton);
        btBackButton.setOnClickListener(new ButtonClickListener());

        return view;
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(_isLayoutXLarge){
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(MenuThanksFragment.this);
                transaction.commit();
            }
            else{
                _parentActivity.finish();  // （7）
            }
        }
    }
}
