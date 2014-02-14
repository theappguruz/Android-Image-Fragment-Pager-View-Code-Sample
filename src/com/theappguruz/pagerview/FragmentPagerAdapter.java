package com.theappguruz.pagerview;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Integer> itemData;

	public FragmentPagerAdapter(FragmentManager fm,
			ArrayList<Integer> itemData) {
		super(fm);
		this.itemData = itemData;
	}

	@Override
	public int getCount() {
		return itemData.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}

	@Override
	public Fragment getItem(int position) {
		FragmentImageView f = FragmentImageView.newInstance();
		f.setImageList(itemData.get(position));
		return f;
	}
}