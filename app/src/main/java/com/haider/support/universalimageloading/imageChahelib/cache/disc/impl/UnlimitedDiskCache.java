package com.haider.support.universalimageloading.imageChahelib.cache.disc.impl;

import com.haider.support.universalimageloading.imageChahelib.cache.disc.naming.FileNameGenerator;

import java.io.File;


public class UnlimitedDiskCache extends BaseDiskCache {
	/** @param cacheDir Directory for file caching */
	public UnlimitedDiskCache(File cacheDir) {
		super(cacheDir);
	}

	/**
	 * @param cacheDir        Directory for file caching
	 * @param reserveCacheDir null-ok; Reserve directory for file caching. It's used when the primary directory isn't available.
	 */
	public UnlimitedDiskCache(File cacheDir, File reserveCacheDir) {
		super(cacheDir, reserveCacheDir);
	}

	public UnlimitedDiskCache(File cacheDir, File reserveCacheDir, FileNameGenerator fileNameGenerator) {
		super(cacheDir, reserveCacheDir, fileNameGenerator);
	}
}
