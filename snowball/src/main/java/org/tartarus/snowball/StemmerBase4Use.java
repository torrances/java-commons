package org.tartarus.snowball;

import com.trimc.blogger.commons.exception.BusinessException;

public class StemmerBase4Use {

	public static final String	CLASS_NAME	= "org.tartarus.snowball.ext.englishStemmer";

	private SnowballStemmer4Use		stemmer;

	protected SnowballStemmer4Use getStemmer() throws BusinessException {
		if (null == stemmer) instantiate();
		return stemmer;
	}

	protected void instantiate() throws BusinessException {
		try {

			Class<?> stemClass = Class.forName(CLASS_NAME);
			setStemmer((SnowballStemmer4Use) stemClass.newInstance());

		} catch (ClassNotFoundException e) {
			throw new BusinessException(e, String.format("Class not found (class = %s)", CLASS_NAME));
		} catch (InstantiationException e) {
			throw new BusinessException(e, String.format("Unable to instantiate English Stemmer (class = %s)", CLASS_NAME));
		} catch (IllegalAccessException e) {
			throw new BusinessException(e);
		}
	}

	protected void setStemmer(SnowballStemmer4Use stemmer) {
		this.stemmer = stemmer;
	}
}
