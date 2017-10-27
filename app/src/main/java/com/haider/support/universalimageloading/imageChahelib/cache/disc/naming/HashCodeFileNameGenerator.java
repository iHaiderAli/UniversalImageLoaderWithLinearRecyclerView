package com.haider.support.universalimageloading.imageChahelib.cache.disc.naming;

public class HashCodeFileNameGenerator implements FileNameGenerator {
	@Override
	public String generate(String imageUri) {
		return String.valueOf(imageUri.hashCode());
	}
}
