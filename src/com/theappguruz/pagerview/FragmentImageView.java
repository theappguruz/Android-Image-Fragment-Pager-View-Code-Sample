package com.theappguruz.pagerview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.theappguruz.R;

public class FragmentImageView extends Fragment {

	private Integer itemData;
	private Bitmap myBitmap;
	public ProgressDialog pd;
	private ImageView ivImage;

	public static FragmentImageView newInstance() {
		FragmentImageView f = new FragmentImageView();
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.imageview, container, false);
		ivImage = (ImageView) root.findViewById(R.id.ivImageView);
		setImageInViewPager();
		return root;
	}

	public void setImageList(Integer integer) {
		this.itemData = integer;
	}

	public void setImageInViewPager() {
		try {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			myBitmap = BitmapFactory.decodeResource(getResources(), itemData,
					options);
			if (options.outWidth > 3000 || options.outHeight > 2000) {
				options.inSampleSize = 4;
			} else if (options.outWidth > 2000 || options.outHeight > 1500) {
				options.inSampleSize = 3;
			} else if (options.outWidth > 1000 || options.outHeight > 1000) {
				options.inSampleSize = 2;
			}
			options.inJustDecodeBounds = false;
			myBitmap = BitmapFactory.decodeResource(getResources(), itemData,
					options);
			if (myBitmap != null) {
				try {
					if (ivImage != null) {
						ivImage.setImageBitmap(myBitmap);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
			System.gc();
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (myBitmap != null) {
			myBitmap.recycle();
			myBitmap = null;
		}
	}
}
