package com.haider.support.universalimageloading.imageChahelib.cache.disc.naming;

public interface FileNameGenerator {

	/** Generates unique file name for image defined by URI */
	String generate(String imageUri);
}
