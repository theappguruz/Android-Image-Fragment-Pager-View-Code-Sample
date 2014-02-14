package com.theappguruz.pagerview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.theappguruz.R;

public class Images {

	private Random randNo;
	private ArrayList<Integer> imageId;

	public Images() {
		imageId = new ArrayList<Integer>();
		imageId.add(R.drawable.a1);
		imageId.add(R.drawable.a2);
		imageId.add(R.drawable.a3);
		imageId.add(R.drawable.a4);
		imageId.add(R.drawable.a5);
	}

	public int getImageId() {
		randNo = new Random();
		return imageId.get(randNo.nextInt(imageId.size()));
	}

	public ArrayList<Integer> getImageItem() {
		return imageId;
	}
}
