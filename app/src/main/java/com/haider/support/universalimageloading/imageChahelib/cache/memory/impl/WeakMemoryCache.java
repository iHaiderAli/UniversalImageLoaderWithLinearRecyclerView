package com.haider.support.universalimageloading.imageChahelib.cache.memory.impl;

import android.graphics.Bitmap;

import com.haider.support.universalimageloading.imageChahelib.cache.memory.BaseMemoryCache;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class WeakMemoryCache extends BaseMemoryCache {
	@Override
	protected Reference<Bitmap> createReference(Bitmap value) {
		return new WeakReference<Bitmap>(value);
	}
}
