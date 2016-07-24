package com.example.mygoogleplay.fragment;

import java.util.ArrayList;

import com.example.mygoogleplay.domain.AppInfo;
import com.example.mygoogleplay.http.protocol.HomeProtocol;
import com.example.mygoogleplay.ui.adapter.MyBaseAdapter;
import com.example.mygoogleplay.ui.holder.BaseHolder;
import com.example.mygoogleplay.ui.holder.HomeHolder;
import com.example.mygoogleplay.ui.view.LoadingPager.ResultState;
import com.example.mygoogleplay.utils.UIUtils;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class HomeFragment extends BaseFragment {
	private ListView listView;
	private ArrayList<AppInfo> data;

	@Override
	public View OnCreateSuccessView() {
		listView = new ListView(UIUtils.getContext());
		listView.setAdapter(new HomeAdapter(data));
		return listView;
	}

	@Override
	public ResultState OnLoad() {
		// for (int i = 0; i < 50; i++) {
		// homeArrayList.add("这是homePager中的数据：" + i);
		// }
		HomeProtocol protocol = new HomeProtocol();
		data = protocol.getData(0);
		return check(data);
	}

	public class HomeAdapter extends MyBaseAdapter<AppInfo> {

		public HomeAdapter(ArrayList<AppInfo> data) {
			super(data);
		}

		@Override
		public BaseHolder<AppInfo> getHolder() {
			HomeHolder holder = new HomeHolder();
			return holder;
		}

		@Override
		public boolean hanMore() {
			return true;
		}

		@Override
		public ArrayList<AppInfo> onLoadMore() {
			ArrayList<String> moreData = new ArrayList<String>();
			for (int i = 0; i < 20; i++) {
				moreData.add("更多数据：" + i);
			}
			SystemClock.sleep(2000);
			return null;
		}

	}
}
